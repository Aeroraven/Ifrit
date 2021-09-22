package com.aeroraven.ifrit.primitive;
import com.aeroraven.ifrit.constant.IfritRenderMode;
import com.aeroraven.ifrit.core.*;
import java.util.*;

public interface IfritPrimitiveGeometryInterface {
	public abstract IfritVectord getForeColor3d();
	public abstract void setForeColor3d(IfritVectord color3d);
	public abstract IfritVectord getForeColor4d();
	public abstract void setForeColor4d(IfritVectord color4d);
	
	public abstract IfritVectord getBackColor3d();
	public abstract void setBackColor3d(IfritVectord color3d);
	public abstract IfritVectord getBackColor4d();
	public abstract void setBackColor4d(IfritVectord color4d);
	
	
	public abstract void translate2d(IfritVectord offset2d);
	public abstract int getZDepth();
	public abstract void setZDepth(int x);
	public abstract ArrayList<IfritPrimitiveBase> getDirectChild();
	public abstract ArrayList<IfritVectord> getVertices();
	
	public abstract IfritRenderMode getRenderMode();
	public abstract void setRenderMode(IfritRenderMode e);
	public abstract void setDisplayChar(String e);
	public abstract String getDisplayChar();

	public abstract double getLeftMargin();
	public abstract double getTopMargin();
}
