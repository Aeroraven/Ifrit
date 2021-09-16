package com.aeroraven.ifrit.misc;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import com.aeroraven.ifrit.core.*;
import com.aeroraven.ifrit.constant.*;
import com.aeroraven.ifrit.natives.*;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;

public class IfritMisc {
	public static void getImagePixel(String image) throws Exception {
		IfritGraphicsNativeWin32 nat = new IfritGraphicsNativeWin32();
		int[] rgb = new int[3];
		File file = new File(image);
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
		System.out.println("width=" + width + ",height=" + height + ".");
		System.out.println("minx=" + minx + ",miniy=" + miny + ".");
		nat.cls();
		OutputStream out = new BufferedOutputStream ( System.out );
		IfritColor16 c= com.aeroraven.ifrit.constant.IfritColor16.WHITE;
		String op="";
		for (int j = miny; j < height; j++) {
			nat.setTextPos((short)0, (short)j);
			for (int i = minx; i < width; i++) {
				int pixel = bi.getRGB(i, j); 
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				IfritColor16 aprx = IfritMath.findApporximateColor(new IfritVectord((double)rgb[0],(double)rgb[1],(double)rgb[2]));
				if(aprx.ordinal()!=c.ordinal()) {
					out.write(op.getBytes());
					op="";
					out.flush();
					nat.setTextColor(com.aeroraven.ifrit.constant.IfritColor16.BLACK, aprx);
					c=aprx;
				}
				op+="¡ö";
				
			}
			out.write(op.getBytes());
			out.flush();
			op="";
		}
		out.write(op.getBytes());
		out.flush();
		op="";
		
	}
}
