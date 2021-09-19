package com.aeroraven.ifrit.core;

public class IfritVectord extends IfritVector<Double> {
	public IfritVectord(Double ... init_args){
		super(init_args);
	}
	public IfritVectord getDuplicate() {
		IfritVectord ret = new IfritVectord();
		for(Double i:vector) {
			ret.add(Double.valueOf(i));
		}
		return ret;
	}
	public static IfritVectord val(Double ...init_args) {
		return new IfritVectord(init_args);
	}
}
