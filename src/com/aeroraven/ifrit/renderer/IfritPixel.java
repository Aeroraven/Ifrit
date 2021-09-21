package com.aeroraven.ifrit.renderer;

import com.aeroraven.ifrit.constant.*;

final class IfritPixel {
	private String dispCh;
	private int windowX;
	private int windowY;
	private IfritColor16 fgcolor;
	private IfritColor16 bgcolor;
	void setDispCh(String e) {
		dispCh=e;
	}
	String getDispCh() {
		return dispCh;
	}
	void setPos(int x,int y) {
		windowX=x;
		windowY=y;
	}
	int getPosX() {
		return windowX;
	}
	int getPosY() {
		return windowY;
	}
	void setFgColor(IfritColor16 e) {
		fgcolor=e;
	}
	IfritColor16 getFgColor() {
		return fgcolor;
	}
	void setBgColor(IfritColor16 e) {
		bgcolor=e;
	}
	IfritColor16 getBgColor() {
		return bgcolor;
	}
}

