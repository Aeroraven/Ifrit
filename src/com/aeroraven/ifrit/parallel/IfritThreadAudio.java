package com.aeroraven.ifrit.parallel;

import java.util.LinkedList;
import java.util.Queue;

import com.aeroraven.ifrit.core.IfritDefs;
import com.aeroraven.ifrit.misc.IfritAudio;

public final class IfritThreadAudio 
extends IfritThreadBase{
	private Thread t;
	private Queue<String> name=new LinkedList<String>();
	private Object mutex=new Object();
	
	@Override
	public void run() {
		while(true) {
			if(name.size()>0) {
				try {
					IfritAudio.playMusic(name.peek());
				} catch (Exception e) {
					e.printStackTrace();
				}
				name.poll();
			}
			try {
				Thread.sleep(IfritDefs.IfritAudioRetryInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		t = new Thread(this,"IfritAudioThread");
		t.start();
	}
	public void addFile(String e) {
		synchronized(mutex) {
			name.offer(e);
		}
	}
}