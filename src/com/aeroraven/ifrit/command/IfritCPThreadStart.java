package com.aeroraven.ifrit.command;

import java.util.HashMap;

import com.aeroraven.ifrit.parallel.IfritThreadBase;
import com.aeroraven.ifrit.parallel.IfritThreadMediator;

public final class IfritCPThreadStart
extends IfritCommandBase{
	public IfritCPThreadStart(Object ...objects) {
		super(objects);
	}
	@Override
	//Execute Argument: ThreadMediator, ThreadList
	public void execute(Object... objects) {
		if(objects[0] instanceof IfritThreadMediator) {
			HashMap<String,IfritThreadBase> threadList = (HashMap<String,IfritThreadBase>)objects[1];
			threadList.get((String)paramList.get(0)).start();
		}
	}

	@Override
	public void undo() {
		
	}
}
