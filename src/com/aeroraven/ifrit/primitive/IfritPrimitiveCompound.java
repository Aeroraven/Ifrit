package com.aeroraven.ifrit.primitive;

import java.util.ArrayList;
import com.aeroraven.ifrit.core.IfritVectord;

public class IfritPrimitiveCompound extends IfritPrimitiveBase {
	protected ArrayList<IfritPrimitiveBase> child;
	
	public IfritPrimitiveCompound() {
		child = new ArrayList<IfritPrimitiveBase>();
	}
	public IfritPrimitiveCompound(IfritPrimitiveBase ...args) {
		child = new ArrayList<IfritPrimitiveBase>();
		for(IfritPrimitiveBase i:args) {
			child.add(i);
		}
	}
	public IfritVectord getColor3d() {
		return new IfritVectord(0.,0.,0.);
	}
	public void setColor3d(IfritVectord color3d) {
		for(IfritPrimitiveBase i:child) {
			i.setColor3d(color3d);
		}
	}
	public IfritVectord getColor4d() {
		return new IfritVectord(0.,0.,0.);
	}
	public void setColor4d(IfritVectord color4d) {
		for(IfritPrimitiveBase i:child) {
			i.setColor4d(color4d);
		}
	}
	public void translate2d(IfritVectord offset2d) {
		for(IfritPrimitiveBase i:child) {
			i.translate2d(offset2d);
		}
	}
	public int getZDepth() {
		return this.zdepth;
	}
	public void setZDepth(int x) {
		this.zdepth=x;
		for(IfritPrimitiveBase i:child) {
			i.setZDepth(x);
		}
	}
	public void add(IfritPrimitiveBase x) {
		child.add(x);
	}
}
