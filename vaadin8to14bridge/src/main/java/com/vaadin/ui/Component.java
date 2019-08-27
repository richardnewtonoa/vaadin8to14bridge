package com.vaadin.ui;

import com.vaadin.flow.dom.ClassList;

public interface Component {
	com.vaadin.flow.component.Component asFlowComponent();
	
	public default void addStyleName(String styleName) {
		com.vaadin.flow.component.Component flow = asFlowComponent();
		if ((flow != null) && (styleName != null)) {
			ClassList classes = flow.getElement().getClassList();
			classes.add(styleName);
		}
	}
}
