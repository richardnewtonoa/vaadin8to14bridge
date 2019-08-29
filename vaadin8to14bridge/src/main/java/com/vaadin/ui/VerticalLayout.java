package com.vaadin.ui;

public class VerticalLayout extends com.vaadin.flow.component.orderedlayout.VerticalLayout implements Component, HasComponents {

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
