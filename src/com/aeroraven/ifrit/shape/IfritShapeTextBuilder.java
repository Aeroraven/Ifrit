package com.aeroraven.ifrit.shape;


import com.aeroraven.ifrit.primitive.*;
import com.aeroraven.ifrit.core.*;
import java.util.*;

class IfritShapeTextBuilder
extends IfritShapeBuilderBase{
	protected IfritPrimitiveCompound product;
	String fillCh="  ";
	double offsetx=0;
	double offsety=0;
	IfritVectord bgColor,fgColor;
	boolean syncWithZdepth = true;
	
	public IfritShapeTextBuilder() {
		builderBegin();
		bgColor  = new IfritVectord(0.,0.,0.,255.);
		fgColor  = new IfritVectord(255.,255.,255.,255.);
	}
	public void builderBegin() {
		product=new IfritPrimitiveCompound();
	}
	public void addFromString(String arg,int zdepth){
		int counter=0;
		int ycounter=0;
		if(syncWithZdepth) {
			product.setZDepth(zdepth);
		}
		for(int i=0;i<arg.length();i++) {
			String e=arg.substring(i,i+1);
			if(e.getBytes().length==1&&e.equals("\n")==false){
				if(i+1<arg.length()) {
					if(arg.substring(i+1,i+2).getBytes().length==1) {
						if(arg.substring(i+1,i+2).equals("\n")==false) {
							e=arg.substring(i,i+2);
							i++;
						}
						
					}
				}
			}else if(e.equals("\n")==true) {
				counter=0;
				ycounter++;
				continue;
			}
			IfritPrimitiveDot tmp=new IfritPrimitiveDot(offsetx+counter,offsety+ycounter);
			counter+=1;
			tmp.setZDepth(zdepth);
			tmp.setDisplayChar(e);
			tmp.setForeColor4d(fgColor);
			tmp.setBackColor4d(bgColor);
			product.add(tmp);
		}
	}
	public void addPresets(String arg,int zdepth,String ... xargs) {
		
	}
	public void setConfigStr(String arg,String ...xargs) {
		if(arg.equals("setFillCh")) {
			fillCh = new String(xargs[0]);
		}
	}
	public void setConfig(String arg,Integer ...xargs) {
		if(arg=="setx") {
			offsetx = xargs[0];
		}
		if(arg=="sety") {
			offsety = xargs[0];
		}
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
		
	}
}
