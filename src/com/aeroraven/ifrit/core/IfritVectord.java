package com.aeroraven.ifrit.core;

public class IfritVectord extends IfritVector<Double> {
	public IfritVectord(Double ... init_args){
		super(init_args);
	}
	IfritVectord getDuplicate() {
		IfritVectord ret = new IfritVectord();
		for(Double i:vector) {
			ret.add(Double.valueOf(i));
		}
		return ret;
	}
}
