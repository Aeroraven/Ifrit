package com.aeroraven.shapeBuilder;

public class IfritShapeDirector {
	void createImageContainer(IfritShapeBuilderBase builder,String image,int offsetX,int offsetY,int zdepth) throws Exception {
		builder.builderBegin();
		builder.setConfig("setx", offsetX);
		builder.setConfig("sety", offsetY);
		builder.addFromFile(image, zdepth);
	}
}
