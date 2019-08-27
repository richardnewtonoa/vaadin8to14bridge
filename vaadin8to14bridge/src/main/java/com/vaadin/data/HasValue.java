package com.vaadin.data;

public interface HasValue<T> {
	public com.vaadin.flow.component.HasValue<?, T> asFlowValue();
}
