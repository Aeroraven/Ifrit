package com.aeroraven.ifrit;

public class IfritDemo {
	public static void main(String[] args) {
		System.out.println("Ifrit Demo is Running");
		System.out.println("Testing GetStdHandle");
		long hStd = IfritConsoleInterface.ICI_GetStdHandle(-10);
		System.out.println(hStd);
	}
}
