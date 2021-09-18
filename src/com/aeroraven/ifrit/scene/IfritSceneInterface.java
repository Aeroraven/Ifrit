package com.aeroraven.ifrit.scene;

import com.aeroraven.ifrit.core.*;
import com.aeroraven.ifrit.primitive.*;
import com.aeroraven.ifrit.component.*;
import java.util.ArrayList;

public interface IfritSceneInterface {
	public abstract void setSceneSize(int w,int h);
	public abstract IfritVectord getSceneSize();
	public abstract ArrayList<IfritComponentBase> getSortedComponents();
	public abstract void addComponent(String alias,IfritComponentBase component);
	public abstract IfritComponentBase getComponent(String alias);
	public abstract void removeComponent(String alias);
}
