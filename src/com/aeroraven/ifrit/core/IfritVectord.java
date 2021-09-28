package com.aeroraven.ifrit.core;

import java.util.ArrayList;

/**
 * 双精度浮点向量
 */
public class IfritVectord
extends IfritVector<Double>
implements Cloneable{
	public IfritVectord(Double ... init_args){
		super(init_args);
	}
	public IfritVectord getDuplicate() {
		IfritVectord ret = new IfritVectord();
		for(Double i:vector) {
			ret.add(i);
		}
		return ret;
	}
	public static IfritVectord val(Double ...init_args) {
		return new IfritVectord(init_args);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		ArrayList<Double> newInst = new ArrayList<>();
		for(Double i:vector) {
			newInst.add((double) i);
		}
		return newInst;
	}

	public int R() {return (int) Math.round(vector.get(0));}
	public int G() {return (int) Math.round(vector.get(1));}
	public int B() {return (int) Math.round(vector.get(2));}
	public double X() {return vector.get(0);}
	public double Y() {return vector.get(1);}
	public double Z() {return vector.get(2);}

}
