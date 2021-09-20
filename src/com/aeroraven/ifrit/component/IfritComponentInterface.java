package com.aeroraven.ifrit.component;

import java.util.ArrayList;
import com.aeroraven.ifrit.primitive.*;


public interface IfritComponentInterface {
	public abstract void setZDepth(int x);
	public abstract int getZDepth();
	public abstract ArrayList<IfritPrimitiveBase> getPrimitives();
	public abstract void addPrimitive(IfritPrimitiveBase x);
	public abstract void addPrimitive(IfritPrimitiveBase x,int frameIdx);
	public abstract void frameAdvance();
	public abstract void setTotalFrames(int cnt);
}
