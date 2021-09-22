package com.aeroraven.ifrit.component;

import java.util.ArrayList;

import com.aeroraven.ifrit.exception.IfritComponentException;
import com.aeroraven.ifrit.primitive.*;


public interface IfritComponentInterface {
	public abstract void setZDepth(int x);
	public abstract int getZDepth();
	public abstract ArrayList<IfritPrimitiveBase> getPrimitives();
	public abstract void addPrimitive(IfritPrimitiveBase x) throws IfritComponentException;
	public abstract void addPrimitive(IfritPrimitiveBase x,int frameIdx) throws IfritComponentException;
	public abstract void frameAdvance();
	public abstract void setTotalFrames(int cnt);
	public abstract void translate2d(double x,double y);
	
	public abstract int getLeftMargin();
	public abstract ArrayList<IfritComponentBase> getChildComponents();
}
