package com.aeroraven.ifrit.scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.aeroraven.ifrit.component.IfritComponentBase;
import com.aeroraven.ifrit.renderer.*;

public class IfritScene
extends IfritSceneBase{
	private IfritRenderer renderer;
	public IfritScene() {
		comList = new HashMap<String,IfritComponentBase>();
		renderer = IfritRenderer.getInst();
	}
	public void render() {
		renderer.render(getSortedComponents(), sceneW, sceneH);
	}
	public ArrayList<IfritComponentBase> getSortedComponents(){
		ArrayList<IfritComponentBase> srList = new ArrayList<IfritComponentBase>();
		for(IfritComponentBase i:comList.values()) {
			srList.add(i);
		}
		Collections.sort(srList);
		return srList;
	}
}
