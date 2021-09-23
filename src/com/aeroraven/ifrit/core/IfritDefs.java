package com.aeroraven.ifrit.core;

public final class IfritDefs {
	private IfritDefs() {}
	public final static String IfritRenderThreadName = "renderer";
	public final static String IfritIOThreadName = "input_output";
	public final static String IfritGCThreadName = "javavm_gc";
	public final static int IfritMaxWidth = 65536;
	public final static int IfritGCInterval = 2000;
}
