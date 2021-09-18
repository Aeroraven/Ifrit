package com.aeroraven.ifrit.shapeBuilder;


import com.aeroraven.ifrit.natives.IfritGraphicsNativeWin32;
import com.aeroraven.ifrit.primitive.*;
import com.aeroraven.ifrit.core.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class IfritPrimitiveBuilder
extends IfritShapeBuilderBase{
	protected IfritPrimitiveCompound product;
	String builderMode;
	String fillCh="  ";
	IfritVectord bgColor,fgColor;
	public IfritPrimitiveBuilder() {
		builderBegin();
		bgColor  = new IfritVectord(0.,0.,0.,255.);
		fgColor  = new IfritVectord(255.,255.,255.,255.);
	}
	public void builderBegin() {
		product=new IfritPrimitiveCompound();
	}
	public void addFromFile(String arg,int zdepth){
		
	}
	public void addPresets(String arg,int zdepth,String ... xargs) {
		
	}
	public void setConfigStr(String arg,String ...xargs) {
		if(arg=="setmode") {
			if(xargs[0].equals("line")) {
				builderMode="line";
			}
			if(xargs[0].equals("circle_arc")) {
				builderMode="circle_arc";
			}
		}
		if(arg.equals("setFillCh")) {
			fillCh = new String(xargs[0]);
		}
	}
	public void setConfig(String arg,Integer ...xargs) {
		if(arg.equals("setForeColor3")) {
			IfritVectord colvec4 = new IfritVectord(0.,0.,0.,0.);
			colvec4.set(0, (double)Integer.valueOf(xargs[0]));
			colvec4.set(1, (double)Integer.valueOf(xargs[1]));
			colvec4.set(2, (double)Integer.valueOf(xargs[2]));
			colvec4.set(3, 255.);
			fgColor = colvec4;
		}
		if(arg.equals("setBackColor3")) {
			IfritVectord colvec4 = new IfritVectord(0.,0.,0.,0.);
			colvec4.set(0, (double)Integer.valueOf(xargs[0]));
			colvec4.set(1, (double)Integer.valueOf(xargs[1]));
			colvec4.set(2, (double)Integer.valueOf(xargs[2]));
			colvec4.set(3, 255.);
			bgColor = colvec4;
		}
	}
	public IfritPrimitiveCompound getResult() {
		return product;
	}
	public void addFromVertices(ArrayList<IfritVectord> arg,int zdepth) {
		if(builderMode.equals("line")) {
			IfritPrimitiveLine tmp = new IfritPrimitiveLine(arg.get(0).get(0),arg.get(0).get(1),
					arg.get(1).get(0),arg.get(1).get(1));
			tmp.setZDepth(zdepth);
			tmp.setDisplayChar(fillCh);
			tmp.setForeColor4d(fgColor);
			tmp.setBackColor4d(bgColor);
			product.add(tmp);
		}
		if(builderMode.equals("circle_arc")) {
			IfritPrimitiveCircleArc tmp = new IfritPrimitiveCircleArc(arg.get(0).get(0),arg.get(0).get(1),
					arg.get(1).get(0),arg.get(1).get(1));
			tmp.setZDepth(zdepth);
			tmp.setDisplayChar(fillCh);
			tmp.setForeColor4d(fgColor);
			tmp.setBackColor4d(bgColor);
			product.add(tmp);
		}
	}
	
}
