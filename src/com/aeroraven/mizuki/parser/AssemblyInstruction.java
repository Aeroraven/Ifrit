package com.aeroraven.mizuki.parser;

import java.util.ArrayList;

@FunctionalInterface
public interface AssemblyInstruction {
    void asmHandler(String asmIns, ArrayList<Object> params, ArrayList<Object> executorParam);
}
