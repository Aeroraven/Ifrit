package com.aeroraven.mizuki.grammar;

import com.aeroraven.mizuki.parser.AssemblyParser;
import com.aeroraven.mizuki.scanner.GrammarScannerPreset;
import com.aeroraven.mizuki.scanner.GrammarScannerToken;

import java.util.ArrayList;

public class AssemblyExecutor
extends AssemblyParser{
    private GrammarScannerPreset scanner;
    protected AssemblyExecutor() {
        scanner = new GrammarScannerPreset();
        scanner.loadPreset();
    }
    protected void executeString(String asmScript,ArrayList<Object> argv){
        ArrayList<GrammarScannerToken> tokens = scanner.scan(asmScript);
        execute(tokens,argv);
    }
}
