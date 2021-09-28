package com.aeroraven.mizuki.parser;

import com.aeroraven.mizuki.scanner.GrammarScannerToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class AssemblyParser {
    private HashMap<String,AssemblyInstruction> insRegistry;
    public AssemblyParser(){
        insRegistry = new HashMap<String,AssemblyInstruction>();
    }
    public void registerInstruction(String instruction,AssemblyInstruction handler){
        insRegistry.put(instruction,handler);
    }
    private ArrayList<GrammarScannerToken> filterValidTokens(ArrayList<GrammarScannerToken> arg){
        ArrayList<GrammarScannerToken> list = new ArrayList<GrammarScannerToken>();
        for(GrammarScannerToken i:arg){
            if(!((String) i.token).equals("Neglectable")){
                list.add(i);
            }
        }
        return list;
    }
    public void execute(ArrayList<GrammarScannerToken> arg, ArrayList<Object> executorArg) {
        ArrayList<GrammarScannerToken> filter = filterValidTokens(arg);
        ArrayList<Object> pending = new ArrayList<Object>();
        for(GrammarScannerToken i:filter){
            if(!Objects.equals((String) i.token, "NewLine") && !Objects.equals((String) i.token, "Comma")){
                pending.add(i.value);
            }else if(((String) i.token).equals("NewLine")){
                if(pending.size()!=0){
                    String execIns = (String)pending.get(0);
                    if(insRegistry.get(execIns)!=null){
                        AssemblyInstruction handler = insRegistry.get(execIns);
                        handler.asmHandler(execIns,pending,executorArg);
                        pending.clear();
                    }else{
                        System.out.println("CANNOT FIND COMMAND "+execIns);
                        pending.clear();
                    }
                }
            }
        }
    }


}
