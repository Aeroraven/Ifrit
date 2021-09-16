package com.aeroraven.ifrit.shapeBuilder;


import com.aeroraven.ifrit.natives.IfritGraphicsNativeWin32;
import com.aeroraven.ifrit.primitive.*;
import com.aeroraven.ifrit.core.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class IfritShapeImageBuilder
extends IfritShapeBuilderBase{
	protected IfritPrimitiveCompound product;
	double offsetx=0;
	double offsety=0;
	public IfritShapeImageBuilder() {
		builderBegin();
	}
	public void builderBegin() {
		product=new IfritPrimitiveCompound();
	}
	public void addFromFile(String arg,int zdepth) throws Exception{
		IfritGraphicsNativeWin32 nat = new IfritGraphicsNativeWin32();
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
		for (int j = miny; j < height; j++) {
			nat.setTextPos((short)0, (short)j);
			for (int i = minx; i < width; i++) {
				int pixel = bi.getRGB(i, j); 
				r = (pixel & 0xff0000) >> 16;
				g = (pixel & 0xff00) >> 8;
				b = (pixel & 0xff);
				IfritPrimitiveBase px = new IfritPrimitiveDot(offsetx+i,offsety+j);
				px.setColor3d(new IfritVectord((double)r,(double)g,(double)b));
				product.add(px);
			}
		}
	}
	public void addPresets(String arg,int zdepth,String ... xargs) {
		
	}
	public void setConfigStr(String arg,String ...xargs) {
		
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
}
