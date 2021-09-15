package com.aeroraven.ifrit.win32;
import java.io.*;

public class IfritConsoleInterface {
	static {
		System.loadLibrary("IfritNative");
	}
	//WINAPI: Get Standard Handle
	public static native long ICI_GetStdHandle(int nStdHandle);
	//WINAPI: Set Text Attribute
	public static native boolean ICI_SetConsoleTextAttribute(long hConsoleOutput,short wAttribute);
	//WINAPI: Set Cursor Position
	public static native boolean ICI_SetConsoleCursorPosition(long hConsoleOutput, short wX, short wY);
	//WINAPI: Get Cursor Position
	public static native int ICI_GetConsoleCursorPositionX(long hConsoleOutput);
	public static native int ICI_GetConsoleCursorPositionY(long hConsoleOutput);
	//WINAPI: Set Console Font (FontFace will be ignored)
	public static native int ICI_SetConsoleFontInfoEx(int nFont,short fsx,short fsy,int fontfam,int fontweight,String fontface);
}
