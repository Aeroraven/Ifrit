package com.aeroraven.ifrit.natives;

import com.aeroraven.ifrit.constant.IfritColor16;
import com.aeroraven.ifrit.constant.IfritCursorMode;
import com.aeroraven.ifrit.misc.IfritEnumConverter;
import com.aeroraven.ifrit.win32.IfritConsoleInterface;

import java.io.IOException;

public final class IfritGraphicsNativeWin32
extends IfritGraphicsNativeBase{
	private long hstd;
	public IfritGraphicsNativeWin32() {
		hstd = IfritConsoleInterface.ICI_GetStdHandle(-11);
	}
	public void setTextColor(IfritColor16 bg,IfritColor16 fg) {
		int fgc = IfritEnumConverter.Col16toWin32Int(fg);
		int bgc = IfritEnumConverter.Col16toWin32Int(bg);
		IfritConsoleInterface.ICI_SetConsoleTextAttribute(hstd, (short)((bgc<<4)|fgc));
	}
	public void setTextPos(short x,short y) {
		long hstd = IfritConsoleInterface.ICI_GetStdHandle(-11);
		IfritConsoleInterface.ICI_SetConsoleCursorPosition(hstd, x, y);
	}
	public void setCursorMode(IfritCursorMode arg) {
		
	}
	public void setWindowSize(int x,int y) {
		
	}
	public char getch(Byte ... ignoreList) {
		return '0';
	}
	public void cls() {
		try {
			Runtime.getRuntime().exec("cmd /c cls");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
