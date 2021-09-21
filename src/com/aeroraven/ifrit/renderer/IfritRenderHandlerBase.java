package com.aeroraven.ifrit.renderer;

import com.aeroraven.ifrit.component.*;
import java.util.ArrayList;

abstract class IfritRenderHandlerBase
implements IfritRenderHandlerInterface{
	public abstract IfritFrameBase handleComponents(ArrayList<IfritComponentBase> arg,int sW,int sH);
	public abstract void handleFrame(IfritFrameBase fr);
}
