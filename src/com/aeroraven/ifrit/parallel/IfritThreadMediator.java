package com.aeroraven.ifrit.parallel;

import java.util.*;
import com.aeroraven.ifrit.command.*;
import com.aeroraven.ifrit.core.*;
import com.aeroraven.ifrit.exception.IfritCommandException;

public class IfritThreadMediator
extends IfritCommandScheduler
implements Runnable{
	private static IfritThreadMediator instance;
	private HashMap<String,IfritThreadBase> threadList;
	private Thread notifierThread = null;
	private Object waitLock = new Object();
	
	private IfritThreadMediator() {
		super();
	}
	public synchronized static IfritThreadMediator getInst() {
		if(instance == null) {
			instance = new IfritThreadMediator();
			instance.threadList = new HashMap<String,IfritThreadBase>();
			instance.notifierThread = new Thread(instance,"notifier");
			instance.notifierThread.start();
			instance.initialize();
		}
		return instance;
	}
	@Override
	public void addCommand(IfritCommandBase cmd) {
		synchronized(cmdQueue) {
			cmdQueue.offer(cmd);
		}
		synchronized(waitLock) {
			waitLock.notify();
		}
	}
	public synchronized void initialize() {
		//Create Renderer Thread
		addCommand(new IfritCPThreadCreate(IfritDefs.IfritRenderThreadName,new IfritThreadRender()));
		addCommand(new IfritCPThreadStart(IfritDefs.IfritRenderThreadName));
		//Create IO Thread
		addCommand(new IfritCPThreadCreate(IfritDefs.IfritIOThreadName,new IfritThreadIO()));
		addCommand(new IfritCPThreadStart(IfritDefs.IfritIOThreadName));
		//Create IO Thread
		addCommand(new IfritCPThreadCreate(IfritDefs.IfritGCThreadName,new IfritThreadGC()));
		addCommand(new IfritCPThreadStart(IfritDefs.IfritGCThreadName));
	}
	 
	@Override
	public void run() {
		while(true) {
			if(cmdQueue.isEmpty()) {
				try {
					synchronized(waitLock) {
						waitLock.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				executeCommand(this,this.threadList);
			} catch (IfritCommandException e) {
				e.printStackTrace();
			}
		}
	}
	
}
