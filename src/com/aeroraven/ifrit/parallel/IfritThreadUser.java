package com.aeroraven.ifrit.parallel;

public abstract class IfritThreadUser
extends IfritThreadBase{
	private Thread t;
	public abstract  void run();
	public final void start() {
		t = new Thread(this,"UserThread");
		t.start();
	}
}
