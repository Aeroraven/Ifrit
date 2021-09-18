package com.aeroraven.ifrit.core;

public final class IfritGlobal {
	private static IfritGlobal instance;
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
