package com.vaadin.ui;

import com.vaadin.flow.component.dialog.Dialog;

/**
 * Make a Vaadin 14 Dialog look (a bit) like a Vaadin 8 Window.
 *  
 * @author richard.newton
 */
public class Window extends Dialog implements Component {

	private static final long serialVersionUID = 1L;

	public Window(String title) {
		super();
	}
	
	public Window() {
		super();
	}
	
	public void setContent(Component component) {
		add(component.asFlowComponent());
	}
	
	public Dialog asFlowComponent() {
		return this;
	}
}
