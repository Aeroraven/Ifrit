package com.aeroraven.ifrit.app;

import com.aeroraven.ifrit.command.IfritCPSwitchRenderScene;
import com.aeroraven.ifrit.core.IfritGlobal;
import com.aeroraven.ifrit.natives.IfritEnvironmentAdapter;
import com.aeroraven.ifrit.parallel.IfritThreadMediator;
import com.aeroraven.ifrit.scene.IfritScene;

public final class IfritApplication {
	private static IfritApplication app;
	private IfritThreadMediator mediator;
	private IfritGlobal global;
	private IfritApplication() {
		global = IfritGlobal.getInst();
		mediator = IfritThreadMediator.getInst();
	}
	public static IfritApplication createApplication() {
		if(app==null) {
			app=new IfritApplication();
			app.adjustWindowSize();
		}
		return app;
	}
	public IfritThreadMediator getMediator() {
		return mediator;
	}
	public IfritGlobal getGlobal() {
		return global;
	}
	public IfritEnvironmentAdapter getEnv() {
		return global.getEnv();
	}
	//Quick Ops
	public void setRenderScene(IfritScene scene) {
		getMediator().addCommand(new IfritCPSwitchRenderScene(scene));
	}
	public void setTitle(String title) {
		getEnv().getAPI().setConsoleTitle(title+" ");
	}
	private void adjustWindowSize() {
		getEnv().getAPI().setWindowSize(getGlobal().getWindowHeight(), getGlobal().getWindowWidth());
	}
}
