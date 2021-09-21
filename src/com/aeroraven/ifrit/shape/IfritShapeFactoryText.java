package com.aeroraven.ifrit.shape;

public class IfritShapeFactoryText
extends IfritShapeFactoryBase{
	IfritShapeFactory parent;
	public IfritShapeFactoryText(IfritShapeFactory x) {
		builder = new IfritShapeTextBuilder();
		parent=x;
	}
	public IfritShapeFactoryText setFillChar(String fillCh) {
		builder.setConfigStr("setFillCh", new String(fillCh));
		return this;
	}
	public IfritShapeFactoryText setForeColor(int R,int G,int B) {
		builder.setConfig("setForeColor3", R,G,B);
		return this;
	}
	public IfritShapeFactoryText setBackColor(int R,int G,int B) {
		builder.setConfig("setBackColor3", R,G,B);
		return this;
	}
	public IfritShapeFactoryText createTextContainer(String text,int offsetX,int offsetY,int zdepth) throws Exception {
		builder.builderBegin();
		builder.setConfig("setx", offsetX);
		builder.setConfig("sety", offsetY);
		builder.addFromString(text, zdepth);
		return this;
	}
	public void store() {
		parent.setCache(builder.getResult());
	}
}
