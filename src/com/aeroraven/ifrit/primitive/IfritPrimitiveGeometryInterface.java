package com.aeroraven.ifrit.primitive;
import com.aeroraven.ifrit.constant.IfritRenderMode;
import com.aeroraven.ifrit.core.*;
import com.aeroraven.ifrit.primitive.*;
import java.util.*;

public interface IfritPrimitiveGeometryInterface {
	public abstract IfritVectord getColor3d();
	public abstract void setColor3d(IfritVectord color3d);
	public abstract IfritVectord getColor4d();
	public abstract void setColor4d(IfritVectord color4d);
	public abstract void translate2d(IfritVectord offset2d);
	public abstract int getZDepth();
	public abstract void setZDepth(int x);
	public abstract ArrayList<IfritPrimitiveBase> getDirectChild();
	public abstract ArrayList<IfritVectord> getVertices();
	
	public abstract IfritRenderMode getRenderMode();
	public abstract void setRenderMode(IfritRenderMode e);

}
