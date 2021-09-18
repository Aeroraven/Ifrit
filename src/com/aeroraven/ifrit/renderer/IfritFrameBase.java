package com.aeroraven.ifrit.renderer;

import java.util.*;


public abstract class IfritFrameBase {
	protected HashMap<Integer,IfritPixel> pixels;
	int frameW,frameH;
	public void setFrame(int w,int h) {
		frameW=w;
		frameH=h;
	}
	public int getFrameW() {
		return frameW;
	}
	public int getFrameH() {
		return frameH;
	}
	public int getIndex(int x,int y) {
		return x+y*frameW;
	}
	public IfritPixel getter(int x,int y) {
		return pixels.get(getIndex(x,y));
	}
	public void initalize(int w,int h) {
		setFrame(w,h);
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				IfritPixel temp = new IfritPixel();
				temp.setBgColor(com.aeroraven.ifrit.constant.IfritColor16.BLACK);
				temp.setFgColor(com.aeroraven.ifrit.constant.IfritColor16.WHITE);
				temp.setDispCh("  ");
				pixels.put(getIndex(j,i), temp);
			}
		}
	}
}
