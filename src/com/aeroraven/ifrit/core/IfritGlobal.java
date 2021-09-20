package com.aeroraven.ifrit.core;

import com.aeroraven.ifrit.constant.*;
import com.aeroraven.ifrit.natives.IfritEnvironmentAdapter;
import com.aeroraven.ifrit.natives.IfritGraphicsNativeBase;

public final class IfritGlobal {
	private static IfritGlobal instance;
	private IfritEnvironmentAdapter envAdapter;
	private IfritDisplayMode displayMode;
	private IfritGlobal() {
		envAdapter = IfritEnvironmentAdapter.getInst();
	}
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
	public int getFrameUpdateInterval() {
		return 100;
	}
	public IfritGraphicsNativeBase getGraphicsAPI() {
		return envAdapter.getAPI();
	}
}
