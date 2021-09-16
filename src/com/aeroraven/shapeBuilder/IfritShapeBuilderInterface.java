package com.aeroraven.shapeBuilder;

public interface IfritShapeBuilderInterface {
	void builderBegin();
	void addFromFile(String arg,int zdepth) throws Exception;
	void addPresets(String arg,int zdepth,String ... xargs);
	void setConfigStr(String arg,String ...xargs);
	void setConfig(String arg,Integer ...xargs);
}
