package com.aeroraven.ifrit.natives;

public class IfritEnvironmentAdapter{
	private static IfritEnvironmentAdapter instance;
	protected IfritGraphicsNativeBase cgapi;
	public static IfritEnvironmentAdapter getInst() {
		if(instance==null) {
			instance = new IfritEnvironmentAdapter();
		}
		return instance;
	}
	protected IfritEnvironmentAdapter() {
		if(System.getProperty("os.name").toLowerCase().indexOf("windows")>-1) {
			cgapi = new IfritGraphicsNativeWin32();
		}else {
			cgapi = new IfritGraphicsNativeANSI();
		}
		cgapi.init();
	}
	public IfritGraphicsNativeBase getAPI() {
		return cgapi;
	}
}
