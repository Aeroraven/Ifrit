package com.aeroraven.ifrit.core;

public abstract class IfritParamEquation2d {
	private double tbegin=0,tend=1;
	public abstract double x(double t);
	public abstract double y(double t);
	public final void setParamRange(double start,double end) {
		tbegin=start;
		tend=end;
	}
}
