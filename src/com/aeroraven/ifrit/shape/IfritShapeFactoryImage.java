package com.aeroraven.ifrit.shape;

public class IfritShapeFactoryImage
extends IfritShapeFactoryBase{
	IfritShapeFactory parent;
	public IfritShapeFactoryImage(IfritShapeFactory x) {
		builder = new IfritShapeImageBuilder();
		parent=x;
	}
	public IfritShapeFactoryImage setFillChar(String fillCh) {
		builder.setConfigStr("setFillCh", new String(fillCh));
		return this;
	}
	public IfritShapeFactoryImage setForeColor(int R,int G,int B) {
		builder.setConfig("setForeColor3", R,G,B);
		return this;
	}
	public IfritShapeFactoryImage setBackColor(int R,int G,int B) {
		builder.setConfig("setBackColor3", R,G,B);
		return this;
	}
	public IfritShapeFactoryImage createImageContainer(String image,int offsetX,int offsetY,int zdepth) throws Exception {
		builder.builderBegin();
		builder.setConfig("setx", offsetX);
		builder.setConfig("sety", offsetY);
		builder.addFromString(image, zdepth);
		return this;
	}
	@Override
	public void store() {
		parent.setCache(builder.getResult());
	}
}
