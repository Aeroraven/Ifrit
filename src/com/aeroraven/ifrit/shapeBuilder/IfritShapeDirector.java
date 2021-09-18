package com.aeroraven.ifrit.shapeBuilder;

import com.aeroraven.ifrit.core.*;
import java.util.*;

public class IfritShapeDirector {
	public void setFillChar(IfritShapeBuilderBase builder,String fillCh) {
		builder.setConfigStr("setFillCh", new String(fillCh));
	}
	public void setForeColor(IfritShapeBuilderBase builder,int R,int G,int B) {
		builder.setConfig("setForeColor3", R,G,B);
	}
	public void setBackColor(IfritShapeBuilderBase builder,int R,int G,int B) {
		builder.setConfig("setBackColor3", R,G,B);
	}
	public void createImageContainer(IfritShapeBuilderBase builder,String image,int offsetX,int offsetY,int zdepth) throws Exception {
		builder.builderBegin();
		builder.setConfig("setx", offsetX);
		builder.setConfig("sety", offsetY);
		builder.addFromFile(image, zdepth);
	}
	public void createLine(IfritShapeBuilderBase builder,IfritVectord st,IfritVectord ed,int zdepth) {
		builder.builderBegin();
		builder.setConfigStr("setmode", "line");
		ArrayList<IfritVectord> insSet = new ArrayList<IfritVectord>();
		insSet.add(st);
		insSet.add(ed);
		builder.addFromVertices(insSet, zdepth);
	}
	
	public void createCircleArc(IfritShapeBuilderBase builder,IfritVectord ct,double radius,int zdepth) {
		builder.builderBegin();
		builder.setConfigStr("setmode", "circle_arc");
		ArrayList<IfritVectord> insSet = new ArrayList<IfritVectord>();
		insSet.add(ct);
		insSet.add(new IfritVectord(ct.get(0),ct.get(1)-radius));
		builder.addFromVertices(insSet, zdepth);
	}
}
