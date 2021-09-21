package com.aeroraven.ifrit.shape;

import java.util.*;
import com.aeroraven.ifrit.core.*;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;

public interface IfritShapeBuilderInterface {
	void builderBegin();
	void addFromString(String arg,int zdepth) throws Exception;
	void addFromVertices(ArrayList<IfritVectord> arg,int zdepth);
	void addPresets(String arg,int zdepth,String ... xargs);
	void setConfigStr(String arg,String ...xargs);
	void setConfig(String arg,Integer ...xargs);
	public IfritPrimitiveCompound getResult();
}
