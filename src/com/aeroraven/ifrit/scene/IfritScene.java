package com.aeroraven.ifrit.scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import com.aeroraven.ifrit.app.IfritApplication;
import com.aeroraven.ifrit.command.IfritCPSetIOSceneEventHandler;
import com.aeroraven.ifrit.component.IfritComponentAbstractContainer;
import com.aeroraven.ifrit.component.IfritComponentAbstractSelectable;
import com.aeroraven.ifrit.component.IfritComponentBase;
import com.aeroraven.ifrit.constant.IfritEnvAttribs;
import com.aeroraven.ifrit.constant.IfritEventName;
import com.aeroraven.ifrit.core.IfritDefs;
import com.aeroraven.ifrit.event.IfritEventHandler;
import com.aeroraven.ifrit.renderer.*;

public class IfritScene
extends IfritSceneBase
implements IfritComponentAbstractContainer,IfritSceneRenderInterface{
	private IfritRenderer renderer;
	private IfritComponentAbstractContainer activeContainer = this;
	private ArrayList<IfritComponentBase> activeContainerComs;
	private int activeContainerComsIdx = 0;
	
	public void selectableFocusHandler(IfritEventName eventName, Object ...params) {
		if(activeContainerComs.size()==0) {
			return;
		}
		IfritApplication app = IfritApplication.createApplication();
		if(activeContainerComsIdx<activeContainerComs.size()) {
			IfritComponentAbstractSelectable xt = (IfritComponentAbstractSelectable)activeContainerComs.get(activeContainerComsIdx);
			xt.onBlur();
		}
		if(((Integer)(params[0])).equals(app.getEnv().getAttr(IfritEnvAttribs.KEYCODE_LEFT))) {
			activeContainerComsIdx = (activeContainerComsIdx-1+activeContainerComs.size())%activeContainerComs.size();
		}
		if(((Integer)(params[0])).equals(app.getEnv().getAttr(IfritEnvAttribs.KEYCODE_RIGHT))) {
			activeContainerComsIdx = (activeContainerComsIdx+1+activeContainerComs.size())%activeContainerComs.size();
		}
		if(activeContainerComs.size()>0) {
			IfritComponentAbstractSelectable xt = (IfritComponentAbstractSelectable)activeContainerComs.get(activeContainerComsIdx);
			xt.onSelect();
		}
		
	}
	@Override
	public void addComponent(String alias,IfritComponentBase component) {
		comList.put(alias, component);
		updateActiveComs();
	}
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
	
	public void findTopCompContainer() {
		ArrayList<IfritComponentBase> list = getSortedComponents();
		boolean findReplacement = false;
		IfritComponentBase newSelection = null;
		for(int i=list.size()-1;i>=0;i--) {
			if(list.get(i) instanceof IfritComponentAbstractContainer && list.get(i).isDisabled()==false) {
				findReplacement=true;
				newSelection=list.get(i);
				break;
			}
		}
		if(newSelection!=null) {
			while(true) {
				boolean doRecursion = false;
				
			}
		}
	}
	
	public ArrayList<IfritComponentBase> getSortedComponentsByLeftMargin() {
		ArrayList<IfritComponentBase> r = this.getSortedComponents();
		Collections.sort(r,new Comparator<IfritComponentBase>() {
			public int compare(IfritComponentBase o1, IfritComponentBase o2) {
				double r1 = o1.getLeftMargin();
				double r2 = o2.getLeftMargin();
				if(r1<r2) {
					return -1;
				}else if(r1==r2) {
					return 0;
				}else {
					return 1;
				}
			}
		
		});
		return r;
	}

	
	private synchronized void updateActiveComs() {
		activeContainer = this;
		activeContainerComs = this.getSortedComponentsByLeftMargin();
		Iterator<IfritComponentBase> iterator = activeContainerComs.iterator();
		while(iterator.hasNext()) {
			IfritComponentBase i = iterator.next();
			if(!(i instanceof IfritComponentAbstractSelectable)) {
				iterator.remove();
			}
		}
		if(activeContainerComs.size()>0) {
			IfritComponentAbstractSelectable xt = (IfritComponentAbstractSelectable)activeContainerComs.get(activeContainerComsIdx);
			xt.onSelect();
		}
	}
	
	@Override
	public void onRenderHooked() {
		updateActiveComs();
		IfritApplication app = IfritApplication.createApplication();
		app.getMediator().addCommand(new IfritCPSetIOSceneEventHandler((IfritEventHandler)this::selectableFocusHandler));
	}
	@Override
	public void onActivationHooked() {
		// TODO Auto-generated method stub
		
	}
}
