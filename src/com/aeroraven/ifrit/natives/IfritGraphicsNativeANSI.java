package com.aeroraven.ifrit.natives;

import com.aeroraven.ifrit.constant.IfritCursorMode;
import com.aeroraven.ifrit.nativelib.IfritConsoleInterface;



final class IfritGraphicsNativeANSI
extends IfritGraphicsNativeGeneral{

	@Override
	public void setWindowSize(int x, int y) {
		
	}

	@Override
	public void init() {
		setCursorMode(IfritCursorMode.HIDDEN);
		cls();
	}

	@Override
	public char getch(Byte... ignoreList) {
		return (char)IfritConsoleInterface.ICI_Getch();
	}

	@Override
	public char kbhit() {
		return (char)IfritConsoleInterface.ICI_Kbhit();
	}
	
}
