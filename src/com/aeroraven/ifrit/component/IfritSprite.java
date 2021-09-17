package com.aeroraven.ifrit.component;

import java.util.ArrayList;
import java.util.Collections;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;

public class IfritSprite extends IfritComponentBase {
	private ArrayList<IfritPrimitiveBase> shapeList;
	public IfritSprite() {
		shapeList = new ArrayList<IfritPrimitiveBase>();
	}
	public ArrayList<IfritPrimitiveBase> getPrimitives(){
		ArrayList<IfritPrimitiveBase> ret = new ArrayList<IfritPrimitiveBase>();
		for(IfritPrimitiveBase i:shapeList) {
			ret.add(i);
		}
		Collections.sort(ret);
		return ret;
	}
	
	@Override
	public void addPrimitive(IfritPrimitiveBase x) {
		shapeList.add(x);
	}
}
