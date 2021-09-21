package com.aeroraven.ifrit.event;

import com.aeroraven.ifrit.constant.IfritEventName;

@FunctionalInterface
public interface IfritEventHandler {
	public abstract void handle(IfritEventName eventName, Object ...params);
}
