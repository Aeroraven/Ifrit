package com.aeroraven.ifrit.core;

import com.aeroraven.ifrit.constant.*;

public final class IfritGlobal {
	private static IfritGlobal instance;
	
	private IfritDisplayMode displayMode;
	
	public static IfritGlobal getInst() {
		if(instance==null) {
			instance = new IfritGlobal();
		}
		return instance;
	}
	public int getScreenWidth() {
		return 2000;
	}
	public int getScreenHeight() {
		return 1000;
	}
}
