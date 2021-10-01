package com.aeroraven.ifrit.core;

import java.util.ArrayList;
import java.util.Arrays;

public class IfritVecAssist {
    public static ArrayList<IfritVectord> conv2List(IfritVectord ... args) {
        return new ArrayList<>(Arrays.asList(args));
    }
    public static ArrayList<String> conv2ListStr(String ... args) {
        return new ArrayList<>(Arrays.asList(args));
    }
    public static ArrayList<Double> conv2ListDbl(Double ... args) {
        return new ArrayList<>(Arrays.asList(args));
    }
}