package com.aeroraven.ifrit.component;

public abstract class IfritComponentBase
implements IfritComponentInterface,Comparable<IfritComponentBase>{
	private int zdepth;
	protected boolean isFinal;
	public void setZDepth(int x) {
		zdepth=x;
	}
	public int getZDepth() {
		return zdepth;
	}
	public int compareTo(IfritComponentBase dest) {
		if(zdepth<dest.zdepth) {
			return -1;
		}else if(zdepth==dest.zdepth) {
			return 0;
		}else {
			return 1;
		}
	}
}
