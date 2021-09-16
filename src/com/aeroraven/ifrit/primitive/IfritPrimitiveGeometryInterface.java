package com.aeroraven.ifrit.primitive;
import com.aeroraven.ifrit.core.*;

public interface IfritPrimitiveGeometryInterface {
	public abstract IfritVectord getColor3d();
	public abstract void setColor3d(IfritVectord color3d);
	public abstract IfritVectord getColor4d();
	public abstract void setColor4d(IfritVectord color4d);
	public abstract void translate2d(IfritVectord offset2d);

}
