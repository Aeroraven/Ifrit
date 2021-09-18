package com.aeroraven.ifrit.primitive;
import java.util.ArrayList;

import com.aeroraven.ifrit.constant.IfritRenderMode;
import com.aeroraven.ifrit.core.IfritVectord;

public final class IfritPrimitiveDot extends IfritPrimitiveBase {
	private IfritVectord colvec4;
	public IfritPrimitiveDot() {
		pointlist = new ArrayList<IfritVectord>();
		pointlist.add(new IfritVectord(0.0,0.0));
		colvec4 = new IfritVectord(1.,1.,1.,1.);
		this.isFinal=true;
		this.renderMode=IfritRenderMode.DOT;
	}
	public IfritPrimitiveDot(double x,double y) {
		pointlist = new ArrayList<IfritVectord>();
		pointlist.add(new IfritVectord(x,y));
		colvec4 = new IfritVectord(1.,1.,1.,1.);
		this.isFinal=true;
		this.renderMode=IfritRenderMode.DOT;
	}
	
	public IfritVectord getColor3d() {
		double r=colvec4.get(0);
		double g=colvec4.get(1);
		double b=colvec4.get(2);
		IfritVectord res = new IfritVectord(r,g,b);
		return res;
	}
	public void setColor3d(IfritVectord color3d) {
		double r=color3d.get(0);
		double g=color3d.get(1);
		double b=color3d.get(2);
		colvec4.reset(r,g,b,1.);
	}
	public IfritVectord getColor4d() {
		double r=colvec4.get(0);
		double g=colvec4.get(1);
		double b=colvec4.get(2);
		double a=colvec4.get(3);
		IfritVectord res = new IfritVectord(r,g,b,a);
		return res;
	}
	public void setColor4d(IfritVectord color4d) {
		double r=color4d.get(0);
		double g=color4d.get(1);
		double b=color4d.get(2);
		double a=color4d.get(3);
		colvec4.reset(r,g,b,a);
	}
	public void translate2d(IfritVectord offset2d) {
		for(IfritVectord i:pointlist) {
			for(int j=0;j<2;j++) {
				double temp=i.get(j)+offset2d.get(j);
				i.set(j, temp);
			}
		}
	}
	public int getZDepth() {
		return zdepth;
	}
	public void setZDepth(int x) {
		zdepth=x;
	}
	public ArrayList<IfritPrimitiveBase> getDirectChild(){
		ArrayList<IfritPrimitiveBase> ret=new ArrayList<IfritPrimitiveBase>();
		ret.add(this);
		return ret;
	}
	public IfritRenderMode getRenderMode() {
		return renderMode;
	}
	public void setRenderMode(IfritRenderMode e) {
		
	}
	public  ArrayList<IfritVectord> getVertices(){
		ArrayList<IfritVectord> ret = new ArrayList<IfritVectord>();
		for(IfritVectord i:pointlist) {
			ret.add(i);
		}
		return ret;
	}
	
	//Event Handlers
	public void translate2d(double x,double y) {
		for(IfritVectord i:pointlist) {
			i.set(0, i.get(0)+x);
			i.set(1, i.get(1)+y);
		}
	}
}
