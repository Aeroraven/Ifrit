package com.aeroraven.ifrit.core;

public class IfritVectori extends IfritVector<Integer> {
	public IfritVectori(Integer ... init_args){
		super(init_args);
	}
	IfritVectori getDuplicate() {
		IfritVectori ret = new IfritVectori();
		for(Integer i:vector) {
			ret.add(Integer.valueOf(i));
		}
		return ret;
	}
}
