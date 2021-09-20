package com.aeroraven.ifrit.command;

import java.util.*;

public abstract class IfritCommandBase {
	protected ArrayList<Object> paramList;
	public IfritCommandBase(Object ...objects) {
		paramList = new ArrayList<Object>();
		for(Object i:objects) {
			paramList.add(i);
		}
	}
	public void setParam(Object ...objects) {
		paramList.clear();
		for(Object i:objects) {
			paramList.add(i);
		}
	}
	public abstract void execute(Object ...objects);
	public abstract void undo();
}
