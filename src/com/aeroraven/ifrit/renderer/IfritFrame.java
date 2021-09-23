package com.aeroraven.ifrit.renderer;

import java.util.ArrayList;

class IfritFrame extends IfritFrameBase {
	public IfritFrame() {
		pixels = new ArrayList<IfritPixel>();
	}
	protected void finalize() throws Throwable{
		
    }
}
