package com.aeroraven.ifrit.primitive;

import java.util.ArrayList;
import com.aeroraven.ifrit.core.IfritVectord;

public abstract class IfritPrimitiveBase 
implements IfritPrimitiveEventInterface, IfritPrimitiveGeometryInterface {
	protected ArrayList<IfritVectord> pointlist;
	protected String alias;
	protected Boolean isFinal;
	
	public abstract IfritVectord getColor3d();
	public abstract void setColor3d(IfritVectord color3d);
	public abstract IfritVectord getColor4d();
	public abstract void setColor4d(IfritVectord color4d);
	public abstract void translate2d(IfritVectord offset2d);

	
	public void setAlias(String arg) {alias=arg;}
	public String getAlias(String arg) {return alias;}
}
