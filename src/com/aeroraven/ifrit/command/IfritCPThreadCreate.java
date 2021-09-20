package com.aeroraven.ifrit.command;

import java.util.HashMap;

import com.aeroraven.ifrit.parallel.IfritThreadBase;
import com.aeroraven.ifrit.parallel.IfritThreadMediator;

public final class IfritCPThreadCreate
extends IfritCommandBase{
	public IfritCPThreadCreate(Object ...objects) {
		super(objects);
	}
	@Override
	//Execute Argument: ThreadMediator, ThreadList
	public void execute(Object... objects) {
		if(objects[0] instanceof IfritThreadMediator) {
			HashMap<String,IfritThreadBase> threadList = (HashMap<String,IfritThreadBase>)objects[1];
			threadList.put((String)paramList.get(0), (IfritThreadBase)paramList.get(1));
		}
	}

	@Override
	public void undo() {
		
	}

}
