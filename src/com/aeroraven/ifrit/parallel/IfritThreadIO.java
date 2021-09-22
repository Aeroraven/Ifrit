package com.aeroraven.ifrit.parallel;

import java.util.*;

import com.aeroraven.ifrit.constant.IfritEventName;
import com.aeroraven.ifrit.core.IfritGlobal;
import com.aeroraven.ifrit.natives.IfritGraphicsNativeBase;
import com.aeroraven.ifrit.event.*;

public class IfritThreadIO 
extends IfritThreadBase{
	private Thread t;
	HashMap<String,IfritEventHandler> eventHandlers;
	IfritEventHandler sceneEventHandler;
	
	public IfritThreadIO() {
		eventHandlers = new HashMap<String,IfritEventHandler>();
	}
	
	public void addEventHandler(String alias,IfritEventHandler x) {
		eventHandlers.put(alias, x);
	}
	public void setSceneEventHandler(IfritEventHandler x) {
		sceneEventHandler=x;
	}
	public void removeEventHandler(String alias) {
		eventHandlers.remove(alias);
	}
	
	@Override
	public void run() {
		while(true) {
			IfritGraphicsNativeBase nat = IfritGlobal.getInst().getGraphicsAPI();
			char x=nat.getch();
			for(String i:eventHandlers.keySet()) {
				eventHandlers.get(i).handle(IfritEventName.KEYBOARD_PRESS, Integer.valueOf(x));
			}
			if(sceneEventHandler!=null) {
				sceneEventHandler.handle(IfritEventName.KEYBOARD_PRESS, Integer.valueOf(x));
			}
		}
	}
	public void start() {
		t = new Thread(this,"IfritIOThread");
		t.start();
	}
}
