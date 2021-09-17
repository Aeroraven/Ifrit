package com.aeroraven.ifrit.renderer;

import com.aeroraven.ifrit.component.*;
import java.util.ArrayList;

public abstract class IfritRenderHandlerBase
implements IfritRenderHandlerInterface{
	public abstract void handleComponents(ArrayList<IfritComponentBase> arg);
	public abstract void handleFrame(IfritFrameBase fr);
}
