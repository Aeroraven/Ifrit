package com.aeroraven.ifrit.component;

import java.util.ArrayList;
import com.aeroraven.ifrit.primitive.*;
public interface IfritComponentInterface {
	public abstract void setZDepth(int x);
	public abstract int getZDepth();
	public abstract ArrayList<IfritPrimitiveBase> getPrimitives();
}
