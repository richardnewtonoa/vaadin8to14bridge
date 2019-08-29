package com.vaadin.ui;

public class Grid<T> extends com.vaadin.flow.component.grid.Grid<T> implements Component {

	private static final long serialVersionUID = 1L;

	@Override
	public com.vaadin.flow.component.Component asFlowComponent() {
		return this;
	}

}
