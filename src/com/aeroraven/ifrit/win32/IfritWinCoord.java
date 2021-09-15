package com.aeroraven.ifrit.win32;

public class IfritWinCoord {
	private short wX;
	private short wY;
	public IfritWinCoord() {wX=0;wY=0;}
	public IfritWinCoord(short _wX,short _wY) {wX=_wX;wY=_wY;}
	public void set(short _wX,short _wY) {wX = _wX;wY = _wY;}
	public short getX() {return wX;}
	public short getY() {return wY;}
}
