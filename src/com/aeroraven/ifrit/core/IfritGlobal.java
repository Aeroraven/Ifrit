package com.aeroraven.ifrit.core;

import com.aeroraven.ifrit.constant.*;
import com.aeroraven.ifrit.natives.IfritEnvironmentAdapter;
import com.aeroraven.ifrit.natives.IfritGraphicsNativeBase;

public final class IfritGlobal {
	private static IfritGlobal instance;
	private IfritEnvironmentAdapter envAdapter;
	//Global Variables
	int frameUpdateRate = 100;
	
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
	public int getWindowWidth() {
		return 170;
	}
	public int getWindowHeight() {
		return 60;
	}
	public int getFrameUpdateInterval() {
		return frameUpdateRate;
	}
	public void setFrameUpdateInterval(int x) {
		frameUpdateRate = x;
	}
	
	public IfritGraphicsNativeBase getGraphicsAPI() {
		return envAdapter.getAPI();
	}
	public IfritEnvironmentAdapter getEnv() {
		return envAdapter;
	}
}
