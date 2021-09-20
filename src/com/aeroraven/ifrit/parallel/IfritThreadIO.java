package com.aeroraven.ifrit.parallel;

import com.aeroraven.ifrit.natives.IfritGraphicsNativeWin32;

public class IfritThreadIO 
extends IfritThreadBase{
	private Thread t;
	
	@Override
	public void run() {
		while(true) {
			IfritGraphicsNativeWin32 nat= new IfritGraphicsNativeWin32();
			nat.cls();
			char x=nat.getch();
			System.out.println("");
			System.out.println("You pressed = "+x);
		}
	}

	public void start() {
		t = new Thread(this,"IfritIOThread");
		t.start();
	}
}
