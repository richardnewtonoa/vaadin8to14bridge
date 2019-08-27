package com.vaadin.ui;

public class Button extends com.vaadin.flow.component.button.Button implements Component {

	private static final long serialVersionUID = 1L;

	public Button(String caption) {
		super(caption);
	}
	
	@Override
	public com.vaadin.flow.component.Component asFlowComponent() {
		return this;
	}
}
