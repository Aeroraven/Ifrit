package com.aeroraven.ifrit.component;

public abstract class IfritComponentBase
implements IfritComponentInterface{
	private int zdepth;
	public void setZDepth(int x) {
		zdepth=x;
	}
	public int getZDepth() {
		return zdepth;
	}
}
