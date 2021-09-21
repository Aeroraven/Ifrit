package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;

public class IfritShapeFactory {
	IfritPrimitiveBase cache;
	public IfritShapeFactoryImage imageBuilder() {
		return new IfritShapeFactoryImage(this);
	}
	public IfritShapeFactoryPrimitive primitiveBuilder() {
		return new IfritShapeFactoryPrimitive(this);
	}
	public IfritShapeFactoryText textBuilder() {
		return new IfritShapeFactoryText(this);
	}
	public IfritPrimitiveBase getFinalShape() {
		return cache;
	}
	void setCache(IfritPrimitiveBase x) {
		cache=x;
	}

}
