package com.aeroraven.ifrit;

import java.util.ArrayList;

import com.aeroraven.ifrit.win32.IfritConsoleInterface;
import com.aeroraven.ifrit.misc.*;


public class IfritDemo {
	public static void main(String[] args) {
		System.out.println("Ifrit Demo is Running");
		System.out.println("==Testing GetStdHandle");
		long hStd = IfritConsoleInterface.ICI_GetStdHandle(-11);
		System.out.println(hStd);
		System.out.println("==Testing TextColor");
		IfritConsoleInterface.ICI_SetConsoleTextAttribute(hStd, (short)2);
		System.out.println("HelloWorld");
		IfritConsoleInterface.ICI_SetConsoleTextAttribute(hStd, (short)15);
		System.out.println("==Testing GetCurPos");
		int conX = IfritConsoleInterface.ICI_GetConsoleCursorPositionX(hStd);
		int conY = IfritConsoleInterface.ICI_GetConsoleCursorPositionY(hStd);
		System.out.println("XCoord="+conX);
		System.out.println("YCoord="+conY);
		System.out.println("==Testing ConsoleFont");
		IfritConsoleInterface.ICI_SetConsoleFontInfoEx(0, (short)2, (short)4, 0, 0, "Arial");
		//IfritMisc.getImagePixel("C:\\Users\\huang\\Pictures\\TEST.png");
	}
}
