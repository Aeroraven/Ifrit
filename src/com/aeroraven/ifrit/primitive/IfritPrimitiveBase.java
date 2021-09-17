package com.aeroraven.ifrit.primitive;

import java.util.*;
import com.aeroraven.ifrit.core.*;
import com.aeroraven.ifrit.constant.*;


public abstract class IfritPrimitiveBase 
implements IfritPrimitiveEventInterface, IfritPrimitiveGeometryInterface,Comparable<IfritPrimitiveBase> {
	protected ArrayList<IfritVectord> pointlist;
	protected String alias;
	protected Boolean isFinal;
	protected int zdepth;
	protected IfritRenderMode renderMode;
	
	public abstract IfritVectord getColor3d();
	public abstract void setColor3d(IfritVectord color3d);
	public abstract IfritVectord getColor4d();
	public abstract void setColor4d(IfritVectord color4d);
	public abstract void translate2d(IfritVectord offset2d);

	
	public void setAlias(String arg) {alias=arg;}
	public String getAlias(String arg) {return alias;}
	public boolean isFinal() {return isFinal;}
	
	public abstract IfritRenderMode getRenderMode();
	public abstract void setRenderMode(IfritRenderMode e);
	
	public int compareTo(IfritPrimitiveBase e) {
		if(zdepth<e.zdepth) {
			return -1;
		}else if(zdepth==e.zdepth) {
			return 0;
		}else {
			return 1;
		}
	}
}
