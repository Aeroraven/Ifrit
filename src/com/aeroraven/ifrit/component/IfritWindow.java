package com.aeroraven.ifrit.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import com.aeroraven.ifrit.exception.IfritComponentException;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;

public class IfritWindow
extends IfritComponentBase
implements IfritComponentAbstractContainer{
	private HashMap<String,IfritComponentBase> shapeList;
	public IfritWindow() {
		isFinal=false;
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
	public double getLeftMargin() {
		double leftMargin = 1E+100;
		for(IfritComponentBase i:shapeList.values()) {
			leftMargin = Math.min(leftMargin, i.getLeftMargin());
		}
		return leftMargin;
	}

	@Override
	public ArrayList<IfritComponentBase> getChildComponents() {
		ArrayList<IfritComponentBase> srList = new ArrayList<IfritComponentBase>();
		for(IfritComponentBase i:shapeList.values()) {
			srList.add(i);
		}
		return srList;
	}

	@Override
	public ArrayList<IfritComponentBase> getSortedComponentsByLeftMargin() {
		ArrayList<IfritComponentBase> r = this.getChildComponents();
		Collections.sort(r,new Comparator<IfritComponentBase>() {
			public int compare(IfritComponentBase o1, IfritComponentBase o2) {
				double r1 = o1.getLeftMargin();
				double r2 = o2.getLeftMargin();
				if(r1<r2) {
					return -1;
				}else if(r1==r2) {
					return 0;
				}else {
					return 1;
				}
			}
		
		});
		return r;
	}

}
