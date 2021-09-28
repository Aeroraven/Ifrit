package com.aeroraven.mizuki;

import java.util.ArrayList;

import com.aeroraven.mizuki.scanner.*;

public class MizukiDemo {
	public static void main(String[] args) throws Exception {
		GrammarScannerPreset x = new GrammarScannerPreset();
		x.loadPreset();
		ArrayList<GrammarScannerToken> w = x.scan("MOV eax,ebx;ADD eax,12;MUL eax,-9;");
		if(w==null) {
			System.out.println("Grammar Error");
		}else {
			for(GrammarScannerToken i:w) {
				System.out.println("<"+(String)i.token+"> "+i.value);
			}
		}
		
	}
}
