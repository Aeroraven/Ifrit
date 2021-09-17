package com.aeroraven.ifrit.renderer;

import java.util.ArrayList;
import com.aeroraven.ifrit.component.IfritComponentBase;

public class IfritRenderer {
	private static IfritRenderer instance;
	public static IfritRenderer getInst() {
		if(instance==null) {
			instance = new IfritRenderer();
		}
		return instance;
	}
	public void render(ArrayList<IfritComponentBase> arg,int sW,int sH) {
		IfritRasterizationHandler rasterizer = new IfritRasterizationHandler();
		IfritDisplayHandler displayer = IfritDisplayHandler.getInst();
		IfritFrame renderFrame = rasterizer.handleComponents(arg, sW, sH);
		displayer.handleFrame(renderFrame);
	}
}
