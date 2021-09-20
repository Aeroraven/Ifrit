package com.aeroraven.ifrit.app;

import com.aeroraven.ifrit.core.IfritGlobal;
import com.aeroraven.ifrit.parallel.IfritThreadMediator;

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
		}
		return app;
	}
	public IfritThreadMediator getMediator() {
		return mediator;
	}
	public IfritGlobal getGlobal() {
		return global;
	}
}
