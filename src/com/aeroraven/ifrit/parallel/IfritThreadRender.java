package com.aeroraven.ifrit.parallel;

import java.util.HashMap;

import com.aeroraven.ifrit.constant.IfritEventName;
import com.aeroraven.ifrit.core.IfritGlobal;
import com.aeroraven.ifrit.event.IfritEventHandler;
import com.aeroraven.ifrit.scene.IfritNullScene;
import com.aeroraven.ifrit.scene.IfritScene;

public final class IfritThreadRender 
extends IfritThreadBase{
	private volatile IfritScene activeScene = new IfritNullScene();
	private final Object mutex=new Object();
	
	HashMap<String,IfritEventHandler> eventHandlers;
	
	public IfritThreadRender() {
		eventHandlers = new HashMap<String,IfritEventHandler>();
	}
	
	public void addEventHandler(String alias,IfritEventHandler x) {
		eventHandlers.put(alias, x);
	}
	public void removeEventHandler(String alias) {
		eventHandlers.remove(alias);
	}
	
	@Override
	public void run() {
		IfritGlobal globalArgs = IfritGlobal.getInst();
		while(true) {
			if(activeScene!=null) {
				activeScene.render();
				for(String i:eventHandlers.keySet()) {
					eventHandlers.get(i).handle(IfritEventName.FRAME_UPDATE);
				}
				try {
					Thread.sleep(globalArgs.getFrameUpdateInterval());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}else {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void setActiveScene(IfritScene arg) {
		synchronized(mutex) {
			activeScene=arg;
			activeScene.onRenderHooked();
		}
	}
	
	public void start() {
		Thread t = new Thread(this, "IfritRendererThread");
		t.start();
	}
}