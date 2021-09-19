package com.aeroraven.ifrit.core;
import java.util.ArrayList;

abstract public class  IfritVectorBase<T> {
	protected ArrayList<T> vector;
	public IfritVectorBase(T ... init_args){
		vector = new ArrayList<T>();
		for(T i:init_args) {
			vector.add(i);
		}
	}
	protected void add(T arg) {
		vector.add(arg);
	}
	public void set(int idx,T val) {
		vector.set(idx, val);
	}
	public T get(int idx) {
		return vector.get(idx);
	}
	public void clear() {
		vector.clear();
	}
	public int getDim() {
		return vector.size();
	}
	public void remove(int idx) {
		vector.remove(idx);
	}
	public void remove(T val) {
		vector.remove(val);
	}
	public void reset(T ... init_args) {
		vector = new ArrayList<T>();
		for(T i:init_args) {
			vector.add(i);
		}
	}
}
