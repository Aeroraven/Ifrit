package com.aeroraven.ifrit.command;

import java.util.HashMap;

import com.aeroraven.ifrit.core.IfritDefs;
import com.aeroraven.ifrit.parallel.IfritThreadBase;
import com.aeroraven.ifrit.parallel.IfritThreadIO;
import com.aeroraven.ifrit.parallel.IfritThreadMediator;

public final class IfritCPRemoveIOEventHandler
extends IfritCommandBase{
	public IfritCPRemoveIOEventHandler(Object ...objects) {
		super(objects);
	}
	@Override
	//Execute Argument: ThreadMediator, ThreadList
	public void execute(Object... objects) {
		if(objects[0] instanceof IfritThreadMediator) {
			HashMap<String,IfritThreadBase> threadList = (HashMap<String,IfritThreadBase>)objects[1];
			IfritThreadIO ioThread = (IfritThreadIO)threadList.get(IfritDefs.IfritIOThreadName);
			ioThread.removeEventHandler((String)paramList.get(0));
		}
	}
	@Override
	public void undo() {
		
	}
}
