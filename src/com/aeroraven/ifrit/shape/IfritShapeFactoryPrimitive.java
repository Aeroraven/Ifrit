package com.aeroraven.ifrit.shape;

import java.util.ArrayList;

import com.aeroraven.ifrit.core.IfritVectord;

/**
 * @deprecated
 */
public class IfritShapeFactoryPrimitive
extends IfritShapeFactoryBase{
	IfritShapeFactory parent;
	public IfritShapeFactoryPrimitive(IfritShapeFactory x) {
		builder = new IfritPrimitiveBuilder();
		parent=x;
	}
	public IfritShapeFactoryPrimitive setFillChar(String fillCh) {
		builder.setConfigStr("setFillCh", new String(fillCh));
		return this;
	}
	public IfritShapeFactoryPrimitive setForeColor(int R,int G,int B) {
		builder.setConfig("setForeColor3", R,G,B);
		return this;
	}
	public IfritShapeFactoryPrimitive setBackColor(int R,int G,int B) {
		builder.setConfig("setBackColor3", R,G,B);
		return this;
	}
	public IfritShapeFactoryPrimitive createLine(IfritVectord st,IfritVectord ed,int zdepth) {
		builder.builderBegin();
		builder.setConfigStr("setmode", "line");
		ArrayList<IfritVectord> insSet = new ArrayList<IfritVectord>();
		insSet.add(st);
		insSet.add(ed);
		builder.addFromVertices(insSet, zdepth);
		return this;
	}
	public IfritShapeFactoryPrimitive createCircleArc(IfritVectord ct,double radius,int zdepth) {
		builder.builderBegin();
		builder.setConfigStr("setmode", "circle_arc");
		ArrayList<IfritVectord> insSet = new ArrayList<IfritVectord>();
		insSet.add(ct);
		insSet.add(new IfritVectord(ct.get(0),ct.get(1)-radius));
		builder.addFromVertices(insSet, zdepth);
		return this;
	}
	
	public IfritShapeFactoryPrimitive createRound(IfritVectord ct,double radius,int zdepth) {
		builder.builderBegin();
		builder.setConfigStr("setmode", "circle_filled");
		ArrayList<IfritVectord> insSet = new ArrayList<IfritVectord>();
		insSet.add(ct);
		insSet.add(new IfritVectord(ct.get(0),ct.get(1)-radius));
		builder.addFromVertices(insSet, zdepth);
		return this;
	}
	public IfritShapeFactoryPrimitive createTriangle(IfritVectord t0,IfritVectord t1,IfritVectord t2,int zdepth) {
		builder.builderBegin();
		builder.setConfigStr("setmode", "triangle");
		ArrayList<IfritVectord> insSet = new ArrayList<IfritVectord>();
		insSet.add(t0);
		insSet.add(t1);
		insSet.add(t2);
		builder.addFromVertices(insSet, zdepth);
		return this;
	}
	public IfritShapeFactoryPrimitive createHollowPolygon(int zdepth,IfritVectord ...vertices) {
		builder.builderBegin();
		builder.setConfigStr("setmode", "lineloop");
		ArrayList<IfritVectord> insSet = new ArrayList<IfritVectord>();
		for(IfritVectord i:vertices) {
			insSet.add(i);
		}
		builder.addFromVertices(insSet, zdepth);
		return this;
	}
	public IfritShapeFactoryPrimitive createSolidPolygon(int zdepth,IfritVectord ...vertices) {
		builder.builderBegin();
		builder.setConfigStr("setmode", "polygon");
		ArrayList<IfritVectord> insSet = new ArrayList<IfritVectord>();
		for(IfritVectord i:vertices) {
			insSet.add(i);
		}
		builder.addFromVertices(insSet, zdepth);
		return this;
	}
	
	public IfritShapeFactoryPrimitive createHollowRectangle(int zdepth,IfritVectord st,double width,double height) {
		IfritVectord rt=IfritVectord.val(st.get(0)+width,st.get(1));
		IfritVectord rb=IfritVectord.val(st.get(0)+width,st.get(1)+height);
		IfritVectord lb=IfritVectord.val(st.get(0),st.get(1)+height);
		IfritVectord lt=IfritVectord.val(st.get(0),st.get(1));
		createHollowPolygon(zdepth,lt,rt,rb,lb);
		return this;
	}
	
	public IfritShapeFactoryPrimitive createSolidRectangle(int zdepth,IfritVectord st,double width,double height) {
		IfritVectord rt=IfritVectord.val(st.get(0)+width,st.get(1));
		IfritVectord rb=IfritVectord.val(st.get(0)+width,st.get(1)+height);
		IfritVectord lb=IfritVectord.val(st.get(0),st.get(1)+height);
		IfritVectord lt=IfritVectord.val(st.get(0),st.get(1));
		createSolidPolygon(zdepth,lt,rt,rb,lb);
		return this;
	}
	public void store() {
		parent.setCache(builder.getResult());
	}
}
