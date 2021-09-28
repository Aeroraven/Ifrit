package com.aeroraven.ifrit.renderer;

import java.util.*;


abstract class IfritFrameBase {
	protected ArrayList<IfritPixel> pixels;
	int frameW,frameH;
	boolean initialized=false;
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
	public void clear() {
		for(int i=0;i<frameH;i++) {
			for(int j=0;j<frameW;j++) {
				IfritPixel temp = getter(j,i);
				temp.setBgColor(com.aeroraven.ifrit.constant.IfritColor16.BLACK);
				temp.setFgColor(com.aeroraven.ifrit.constant.IfritColor16.WHITE);
				temp.setDispCh("  ");
			}
		}
	}
	public void initalize(int w,int h) {
		if(!initialized) {
			setFrame(w,h);
			initialized=true;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					IfritPixel temp = new IfritPixel();
					temp.setBgColor(com.aeroraven.ifrit.constant.IfritColor16.BLACK);
					temp.setFgColor(com.aeroraven.ifrit.constant.IfritColor16.WHITE);
					temp.setDispCh("  ");
					pixels.add(temp);
				}
			}
		}else {
			clear();
			setFrame(w,h);
			if(pixels.size()<getIndex(h-1,w-1)) {
				int diff = getIndex(h-1,w-1)-pixels.size();
				for(int j=0;j<diff;j++) {
					IfritPixel temp = new IfritPixel();
					temp.setBgColor(com.aeroraven.ifrit.constant.IfritColor16.BLACK);
					temp.setFgColor(com.aeroraven.ifrit.constant.IfritColor16.WHITE);
					temp.setDispCh("  ");
					pixels.add(temp);
				}
			}
		}
		
	}
}
