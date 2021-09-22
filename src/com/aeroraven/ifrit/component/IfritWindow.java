package com.aeroraven.ifrit.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.aeroraven.ifrit.exception.IfritComponentException;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;

public class IfritWindow
extends IfritComponentBase{
	private HashMap<String,IfritComponentBase> shapeList;
	public IfritWindow() {
		shapeList = new  HashMap<String,IfritComponentBase>();
	}
	
	@Override
	public ArrayList<IfritPrimitiveBase> getPrimitives() {
		ArrayList<IfritComponentBase> srList = new ArrayList<IfritComponentBase>();
		for(IfritComponentBase i:shapeList.values()) {
			srList.add(i);
		}
		Collections.sort(srList);
		ArrayList<IfritPrimitiveBase> ret = new ArrayList<IfritPrimitiveBase>();
		for(IfritComponentBase i:srList) {
			ArrayList<IfritPrimitiveBase> reta = new ArrayList<IfritPrimitiveBase>();
			for(IfritPrimitiveBase j:i.getPrimitives()) {
				reta.add(j);
			}
			Collections.sort(reta);
			for(IfritPrimitiveBase j:reta) {
				ret.add(j);
			}
		}
		return ret;
	}
	
	@Override
	public void addPrimitive(IfritPrimitiveBase x) throws IfritComponentException {
		throw new IfritComponentException("Window component cannot receive single primitives");
	}

	public void addComponent(String alias,IfritComponentBase x) {
		shapeList.put(alias, x);
	}
	@Override
	public void addPrimitive(IfritPrimitiveBase x, int frameIdx) throws IfritComponentException {
		throw new IfritComponentException("Window component cannot receive single primitives");
	}

	@Override
	public void frameAdvance() {
		return ;
	}

	@Override
	public void setTotalFrames(int cnt) {
		return ;
	}

	@Override
	public void translate2d(double x, double y) {
		for(IfritComponentBase i:shapeList.values()) {
			i.translate2d(x, y);
		}
	}

	@Override
	public int getLeftMargin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<IfritComponentBase> getChildComponents() {
		ArrayList<IfritComponentBase> srList = new ArrayList<IfritComponentBase>();
		for(IfritComponentBase i:shapeList.values()) {
			srList.add(i);
		}
		return srList;
	}

}
