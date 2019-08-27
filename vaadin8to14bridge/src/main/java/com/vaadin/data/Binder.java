package com.vaadin.data;

public class Binder<BEAN> extends com.vaadin.flow.data.binder.Binder<BEAN> {
	private static final long serialVersionUID = 1L;

//	public <FIELDVALUE> BindingBuilder<BEAN, FIELDVALUE> forField(com.vaadin.data.HasValue<FIELDVALUE> field) {
//		return super.forField(field.asFlowValue());
//	}

	public Binder(Class<BEAN> beanType) {
		super(beanType);
	}
}
