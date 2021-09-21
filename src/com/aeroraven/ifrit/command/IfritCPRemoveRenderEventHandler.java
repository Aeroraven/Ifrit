package com.aeroraven.ifrit.command;

import java.util.HashMap;

import com.aeroraven.ifrit.core.IfritDefs;
import com.aeroraven.ifrit.parallel.IfritThreadBase;
import com.aeroraven.ifrit.parallel.IfritThreadMediator;
import com.aeroraven.ifrit.parallel.IfritThreadRender;

public final class IfritCPRemoveRenderEventHandler
extends IfritCommandBase{
	public IfritCPRemoveRenderEventHandler(Object ...objects) {
		super(objects);
	}
	@Override
	//Execute Argument: ThreadMediator, ThreadList
	public void execute(Object... objects) {
		if(objects[0] instanceof IfritThreadMediator) {
			HashMap<String,IfritThreadBase> threadList = (HashMap<String,IfritThreadBase>)objects[1];
			IfritThreadRender renderThread = (IfritThreadRender)threadList.get(IfritDefs.IfritRenderThreadName);
			renderThread.removeEventHandler((String)paramList.get(0));
		}
	}
	@Override
	public void undo() {
		
	}
}
