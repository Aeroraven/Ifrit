package com.aeroraven.ifrit.component;

import com.aeroraven.ifrit.event.IfritEventHandler;

public interface IfritComponentAbstractSelectable {
	void onClick();
	void onSelect();
	void onBlur();
	void setClickHandler(IfritEventHandler handle);
	void setSelectHandler(IfritEventHandler handle);
	
}
