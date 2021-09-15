package com.aeroraven.ifrit;
import java.io.*;

public class IfritConsoleInterface {
	static {
		System.loadLibrary("IfritNative");
	}
	public static native long ICI_GetStdHandle(int nStdHandle);
	public static native boolean ICI_SetConsoleTextAttribute(long hConsoleOutput,short wAttribute);
	
}
