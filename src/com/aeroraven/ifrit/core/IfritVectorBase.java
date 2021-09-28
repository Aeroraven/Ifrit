package com.aeroraven.ifrit.core;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ��������
 * @param <T> ���Ͳ���,����TӦ��ʵ��Cloneable�ӿ�
 */
abstract public class  IfritVectorBase<T> {
	protected ArrayList<T> vector;
	@SafeVarargs
	public IfritVectorBase(T ... init_args){
		vector = new ArrayList<T>();
		vector.addAll(Arrays.asList(init_args));
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
	@SafeVarargs
	public final void reset(T... init_args) {
		vector = new ArrayList<T>();
		vector.addAll(Arrays.asList(init_args));
	}


}
