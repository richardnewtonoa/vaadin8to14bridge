package com.vaadin.ui;

public class FormLayout extends com.vaadin.flow.component.formlayout.FormLayout implements Component, HasComponents {

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
