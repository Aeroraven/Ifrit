package com.aeroraven.ifrit.parallel;

import com.aeroraven.ifrit.core.IfritGlobal;
import com.aeroraven.ifrit.scene.IfritScene;

public final class IfritThreadRender 
extends IfritThreadBase{
	private Thread t;
	private volatile IfritScene activeScene = null;
	private Object mutex=new Object();
	
	@Override
	public void run() {
		IfritGlobal globalArgs = IfritGlobal.getInst();
		while(true) {
			if(activeScene!=null) {
				activeScene.render();
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
		}
	}
	
	public void start() {
		t = new Thread(this,"IfritRendererThread");
		t.start();
	}
}