package com.aeroraven.ifrit.component;

import java.util.ArrayList;

public interface IfritComponentAbstractContainer {
	ArrayList<IfritComponentBase> getSortedComponentsByLeftMargin();
	void onActivationHooked();
	ArrayList<IfritComponentBase> getChildComponents();
}
