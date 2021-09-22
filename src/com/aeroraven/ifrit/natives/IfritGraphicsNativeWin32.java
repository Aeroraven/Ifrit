package com.aeroraven.ifrit.natives;

import com.aeroraven.ifrit.constant.IfritCursorMode;
import com.aeroraven.ifrit.nativelib.IfritConsoleInterface;

final class IfritGraphicsNativeWin32
extends IfritGraphicsNativeGeneral{
	private long hstdIn,hstdOut,hstdErr;
	
	@Override
	public void setWindowSize(int x, int y) {
		
	}

	@Override
	public void init() {
		hstdIn = IfritConsoleInterface.ICI_GetStdHandle(-10);
		int modeIn = IfritConsoleInterface.ICI_GetConsoleMode(hstdIn);
		IfritConsoleInterface.ICI_SetConsoleMode(hstdIn, modeIn&(~0x0040));
		
		hstdOut = IfritConsoleInterface.ICI_GetStdHandle(-11);
		int modeOut = IfritConsoleInterface.ICI_GetConsoleMode(hstdOut);
		IfritConsoleInterface.ICI_SetConsoleMode(hstdOut, modeOut|0x0004);
		
		hstdErr = IfritConsoleInterface.ICI_GetStdHandle(-12);
		int modeErr = IfritConsoleInterface.ICI_GetConsoleMode(hstdErr);
		IfritConsoleInterface.ICI_SetConsoleMode(hstdErr, modeErr|0x0004);
		
		setCursorMode(IfritCursorMode.HIDDEN);
		setConsoleTitle("Demo ");
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
