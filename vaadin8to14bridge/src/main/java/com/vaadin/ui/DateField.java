package com.vaadin.ui;

public class DateField extends com.vaadin.flow.component.datepicker.DatePicker implements Component {
	private static final long serialVersionUID = 1L;

	public DateField(String label) {
		super(label);
		
	}

	@Override
	public com.vaadin.flow.component.Component asFlowComponent() {
		return this;
	}
}
