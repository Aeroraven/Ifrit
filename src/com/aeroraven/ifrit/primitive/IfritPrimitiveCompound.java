package com.aeroraven.ifrit.primitive;

import java.util.ArrayList;

import com.aeroraven.ifrit.constant.IfritRenderMode;
import com.aeroraven.ifrit.core.IfritVectord;
import java.util.Collections;

public class IfritPrimitiveCompound 
extends IfritPrimitiveBase {
	protected ArrayList<IfritPrimitiveBase> child;
	
	public IfritPrimitiveCompound() {
		child = new ArrayList<IfritPrimitiveBase>();
		this.isFinal=false;
		this.renderMode=IfritRenderMode.COMPOUND;
	}
	public IfritPrimitiveCompound(IfritPrimitiveBase ...args) {
		child = new ArrayList<IfritPrimitiveBase>();
		for(IfritPrimitiveBase i:args) {
			child.add(i);
		}
		this.isFinal=false;
		this.renderMode=IfritRenderMode.COMPOUND;
	}
	public IfritVectord getForeColor3d() {
		return new IfritVectord(0.,0.,0.);
	}
	public void setForeColor3d(IfritVectord color3d) {
		for(IfritPrimitiveBase i:child) {
			i.setForeColor3d(color3d);
		}
	}
	public IfritVectord getForeColor4d() {
		return new IfritVectord(0.,0.,0.);
	}
	public void setForeColor4d(IfritVectord color4d) {
		for(IfritPrimitiveBase i:child) {
			i.setForeColor4d(color4d);
		}
	}
	
	public IfritVectord getBackColor3d() {
		return new IfritVectord(0.,0.,0.);
	}
	public void setBackColor3d(IfritVectord color3d) {
		for(IfritPrimitiveBase i:child) {
			i.setBackColor3d(color3d);
		}
	}
	public IfritVectord getBackColor4d() {
		return new IfritVectord(0.,0.,0.);
	}
	public void setBackColor4d(IfritVectord color4d) {
		for(IfritPrimitiveBase i:child) {
			i.setBackColor4d(color4d);
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
	public ArrayList<IfritPrimitiveBase> getDirectChild(){
		ArrayList<IfritPrimitiveBase> ret=new ArrayList<IfritPrimitiveBase>();
		for(IfritPrimitiveBase i:child) {
			ret.add(i);
		}
		Collections.sort(ret);
		return ret;
	}
	public IfritRenderMode getRenderMode() {
		return renderMode;
	}
	public void setRenderMode(IfritRenderMode e) {
		
	}
	public  ArrayList<IfritVectord> getVertices(){
		return null;
	}
	public void translate2d(double x,double y) {
		for(IfritPrimitiveBase i:child) {
			i.translate2d(x, y);
		}
	}
	public void setDisplayChar(String e) {
		dispChar = new String(e);
		for(IfritPrimitiveBase i:child) {
			i.setDisplayChar(e);
		}
	}
	public String getDisplayChar() {
		return this.dispChar;
	}
	@Override
	public double getLeftMargin() {
		double leftMargin = 1e+9;
		for(IfritPrimitiveBase i:child) {
			leftMargin = Math.min(leftMargin, i.getLeftMargin());
		}
		return leftMargin;
	}
	@Override
	public double getTopMargin() {
		double topMargin = 1e+9;
		for(IfritPrimitiveBase i:child) {
			topMargin = Math.min(topMargin, i.getTopMargin());
		}
		return topMargin;
	}
}
