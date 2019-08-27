package com.vaadin.ui;

public class HorizontalLayout extends com.vaadin.flow.component.orderedlayout.HorizontalLayout implements Component, HasComponents {

	private static final long serialVersionUID = 1L;

	@Override
	public com.vaadin.flow.component.Component asFlowComponent() {
		return this;
	}

	@Override
	public void addComponent(Component component) {
		add(component.asFlowComponent());
	}
}
