package com.aeroraven.ifrit.shape;


import com.aeroraven.ifrit.primitive.*;
import com.aeroraven.ifrit.core.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

class IfritShapeImageBuilder
extends IfritShapeBuilderBase{
	protected IfritPrimitiveCompound product;
	String fillCh="  ";
	double offsetx=0;
	double offsety=0;
	public IfritShapeImageBuilder() {
		builderBegin();
	}
	public void builderBegin() {
		product=new IfritPrimitiveCompound();
	}
	public void addFromString(String arg,int zdepth) throws Exception{
		int r,g,b;
		File file = new File(arg);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {
				int pixel = bi.getRGB(i, j); 
				r = (pixel & 0xff0000) >> 16;
				g = (pixel & 0xff00) >> 8;
				b = (pixel & 0xff);
				IfritPrimitiveBase px = new IfritPrimitiveDot(offsetx+i,offsety+j);
				px.setBackColor3d(new IfritVectord((double)r,(double)g,(double)b));
				px.setDisplayChar(new String("  "));
				px.setForeColor3d(new IfritVectord(0.,0.,0.));
				product.add(px);
			}
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
	}
	public IfritPrimitiveCompound getResult() {
		return product;
	}
	public void addFromVertices(ArrayList<IfritVectord> arg,int zdepth) {
		
	}
}
