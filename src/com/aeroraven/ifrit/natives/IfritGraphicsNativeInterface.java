package com.aeroraven.ifrit.natives;

import com.aeroraven.ifrit.constant.*;

public interface IfritGraphicsNativeInterface {
	public abstract void setTextColor(IfritColor16 bg,IfritColor16 fg);
	public abstract void setTextPos(short x,short y);
	public abstract void setCursorMode(IfritCursorMode arg);
	public abstract void setWindowSize(int x,int y);
	
	public abstract void init();
	public abstract char getch(Byte ... ignoreList);
	public abstract char kbhit();
	public abstract void cls();	
}
