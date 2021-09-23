package com.aeroraven.ifrit.scene;

import java.util.HashMap;
import java.util.ArrayList;
import com.aeroraven.ifrit.component.*;
import com.aeroraven.ifrit.core.IfritVectord;

public abstract class IfritSceneBase
implements IfritSceneInterface{
	HashMap<String,IfritComponentBase> comList;
	int sceneW,sceneH;
	public void setSceneSize(int w,int h) {
		sceneW= w;
		sceneH=h;
	}
	public IfritVectord getSceneSize() {
		return new IfritVectord((double)sceneW,(double)sceneH);
	}
	public abstract ArrayList<IfritComponentBase> getChildComponents();
	public void addComponent(String alias,IfritComponentBase component) {
		comList.put(alias, component);
	}
	public IfritComponentBase getComponent(String alias) {
		return comList.get(alias);
	}
	public void removeComponent(String alias) {
		comList.remove(alias);
	}
}
