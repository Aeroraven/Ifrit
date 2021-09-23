package com.aeroraven.ifrit.natives;

import java.io.IOException;
import java.util.HashMap;

import com.aeroraven.ifrit.constant.*;

public class IfritEnvironmentAdapter{
	private static IfritEnvironmentAdapter instance;
	protected IfritGraphicsNativeBase cgapi;
	protected IfritOSType ostype;
	protected HashMap<IfritEnvAttribs,Object> envAttr;
	public static IfritEnvironmentAdapter getInst() {
		if(instance==null) {
			instance = new IfritEnvironmentAdapter();
		}
		return instance;
	}
	protected IfritEnvironmentAdapter() {
		envAttr = new HashMap<IfritEnvAttribs,Object>();
		if(System.getProperty("os.name").toLowerCase().indexOf("windows")>-1) {
			cgapi = new IfritGraphicsNativeWin32();
			
			envAttr.put(IfritEnvAttribs.KEYCODE_UP,Integer.valueOf(296));
			envAttr.put(IfritEnvAttribs.KEYCODE_DOWN,Integer.valueOf(304));
			envAttr.put(IfritEnvAttribs.KEYCODE_RIGHT,Integer.valueOf(301));
			envAttr.put(IfritEnvAttribs.KEYCODE_LEFT,Integer.valueOf(299));
			envAttr.put(IfritEnvAttribs.KEYCODE_ENTER,Integer.valueOf(13));
			
			ostype = IfritOSType.WINDOWS;
		}else {
			cgapi = new IfritGraphicsNativeANSI();
			
			envAttr.put(IfritEnvAttribs.KEYCODE_UP,Integer.valueOf(296));
			envAttr.put(IfritEnvAttribs.KEYCODE_DOWN,Integer.valueOf(304));
			envAttr.put(IfritEnvAttribs.KEYCODE_RIGHT,Integer.valueOf(301));
			envAttr.put(IfritEnvAttribs.KEYCODE_LEFT,Integer.valueOf(299));
			envAttr.put(IfritEnvAttribs.KEYCODE_ENTER,Integer.valueOf(13));
			ostype = IfritOSType.OTHER;
		}
		try {
			cgapi.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public IfritGraphicsNativeBase getAPI() {
		return cgapi;
	}
	public Object getAttr(IfritEnvAttribs x) {
		return envAttr.get(x);
	}
}
