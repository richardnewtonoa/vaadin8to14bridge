package com.vaadin.ui;

public class TextField extends com.vaadin.flow.component.textfield.TextField implements Component {

	private static final long serialVersionUID = 1L;

	public TextField(String caption) {
		super(caption);
	}
	
	@Override
	public com.vaadin.flow.component.Component asFlowComponent() {
		return this;
	}

}
