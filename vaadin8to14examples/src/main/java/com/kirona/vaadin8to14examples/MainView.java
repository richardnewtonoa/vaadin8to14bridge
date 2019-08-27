package com.kirona.vaadin8to14examples;

import com.kirona.vaadin8examples.BasicForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;

import com.vaadin.ui.Window;

/**
 * The main view contains a button and a click listener.
 */
@Route
@PWA(name = "My Application", shortName = "My Application")
public class MainView extends VerticalLayout {

	final BasicForm form = new BasicForm();
	
    public MainView() {
        Button button = new Button("Click me",
                event -> {
                	Window w = form.popupWindow(
                			BasicForm.FormBean::new, 
                			fb->System.out.println("Received FormBean = " + fb));
                	
                	w.open();
                });
        add(button);
    }
}
