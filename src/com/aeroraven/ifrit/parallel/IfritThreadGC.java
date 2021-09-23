package com.aeroraven.ifrit.parallel;

import com.aeroraven.ifrit.core.IfritDefs;

public final class IfritThreadGC 
extends IfritThreadBase{
	private Thread t;
	private Object mutex=new Object();
	
	@Override
	public void run() {
		while(true) {
			System.gc();
			try {
				Thread.sleep(IfritDefs.IfritGCInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		t = new Thread(this,"IfritJVMGCThread");
		t.start();
	}
}