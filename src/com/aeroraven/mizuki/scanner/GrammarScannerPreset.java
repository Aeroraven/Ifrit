package com.aeroraven.mizuki.scanner;

import com.aeroraven.mizuki.dfa.*;

public class GrammarScannerPreset
extends GrammarScanner{
	public void loadPreset() {
		TrieGraphNode x,x2;
		//Integer Scanner
		x = this.locateNode("");
		x = this.appendNonTerminalNode(x, "num");
		x = this.appendLoop(x, "num");
		x  = this.appendTerminalNode(x, "nonnum", "Integer", 1);
		
		//Negative Integer Scanner
		x = this.locateNode("");
		x = this.appendNonTerminalNode(x, "-");
		x = this.appendNonTerminalNode(x, "num");
		x = this.appendLoop(x, "num");
		x = this.appendTerminalNode(x, "nonnum", "Integer", 1);
		
		//Comma
		x = this.locateNode("");
		x = this.appendTerminalNode(x, ",", "Comma", 0);
		
		//Semicolon
		x = this.locateNode("");
		x = this.appendTerminalNode(x, ";", "NewLine", 0);
		
		//Alphabetic
		x = this.locateNode("");
		x = this.appendNonTerminalNode(x, "alphabet");
		x2 = this.appendTerminalNode(x,"nonnumoralp","Word",1);
		x = this.appendLoop(x, "numoralp");
		//x = this.appendTerminalNode(x, "nonnumoralp", "Word", 1);
		
		//RN
		x = this.locateNode("");
		x = this.appendTerminalNode(x, "\n", "Neglectable", 0);
		x = this.locateNode("");
		x = this.appendTerminalNode(x, "\r", "Neglectable", 0);
		x = this.locateNode("");
		x = this.appendTerminalNode(x, " ", "Neglectable", 0);
	}
}
