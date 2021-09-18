package com.aeroraven.ifrit.shapeBuilder;

import java.util.*;
import com.aeroraven.ifrit.core.*;

public interface IfritShapeBuilderInterface {
	void builderBegin();
	void addFromFile(String arg,int zdepth) throws Exception;
	void addFromVertices(ArrayList<IfritVectord> arg,int zdepth);
	void addPresets(String arg,int zdepth,String ... xargs);
	void setConfigStr(String arg,String ...xargs);
	void setConfig(String arg,Integer ...xargs);
}
