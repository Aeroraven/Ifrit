package com.aeroraven.ifrit.component;

import java.util.ArrayList;
import java.util.Collections;

import com.aeroraven.ifrit.core.IfritDefs;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;

public class IfritSprite 
extends IfritComponentBase
implements IfritSpriteNotifyInterface{
	private ArrayList<ArrayList<IfritPrimitiveBase>> shapeList;
	private int currentFrameIdx;
	private int totalFrames;
	
	public IfritSprite() {
		isFinal=true;
		totalFrames=1;
		currentFrameIdx=0;
		shapeList = new ArrayList<ArrayList<IfritPrimitiveBase>>();
		for(int i=0;i<totalFrames;i++) {
			shapeList.add(new ArrayList<IfritPrimitiveBase>());
		}
	}
	
	public ArrayList<IfritPrimitiveBase> getPrimitives(){
		ArrayList<IfritPrimitiveBase> ret = new ArrayList<IfritPrimitiveBase>();
		for(IfritPrimitiveBase i:shapeList.get(currentFrameIdx)) {
			if(isVisible()==false) {
				return  new ArrayList<IfritPrimitiveBase>();
			}
			ret.add(i);
		}
		Collections.sort(ret);
		return ret;
	}
	
	@Override
	public void addPrimitive(IfritPrimitiveBase x) {
		shapeList.get(0).add(x);
	}
	
	@Override
	public void translate2d(double x, double y) {
		for(ArrayList<IfritPrimitiveBase> k:shapeList) {
			for(IfritPrimitiveBase i:k) {
				i.translate2d(x, y);
			}
		}
	}
	@Override
	public void addPrimitive(IfritPrimitiveBase x, int frameIdx) {
		shapeList.get(frameIdx).add(x);
	}
	@Override
	public void frameAdvance() {
		currentFrameIdx++;
		currentFrameIdx%=totalFrames;
	}

	@Override
	public void setTotalFrames(int cnt) {
		totalFrames=cnt;
		currentFrameIdx=0;
		shapeList = new ArrayList<ArrayList<IfritPrimitiveBase>>();
		for(int i=0;i<totalFrames;i++) {
			shapeList.add(new ArrayList<IfritPrimitiveBase>());
		}
	}

	@Override
	public double getLeftMargin() {
		double leftMargin = 1E+100;
		for(ArrayList<IfritPrimitiveBase> k:shapeList) {
			for(IfritPrimitiveBase i:k) {
				leftMargin = Math.min(leftMargin, i.getLeftMargin()+i.getTopMargin()*IfritDefs.IfritMaxWidth);
			}
		}
		return leftMargin;
	}

	@Override
	public ArrayList<IfritComponentBase> getChildComponents() {
		ArrayList<IfritComponentBase> ret = new ArrayList<IfritComponentBase>();
		ret.add(this);
		return ret;
	}
}
