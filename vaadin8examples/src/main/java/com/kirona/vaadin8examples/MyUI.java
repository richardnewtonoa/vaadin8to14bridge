package com.kirona.vaadin8examples;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	final BasicForm form = new BasicForm();
	final GridExample grid = new GridExample();
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        {
	        Button button = new Button("A Form");
	        button.addClickListener(e -> {
	        	final Window w = form.popupWindow(
	        			BasicForm.FormBean::new, 
	        			fb->System.out.println("Received FormBean = " + fb));
	        	this.addWindow(w);
	        });
	        
	        layout.addComponent(button);
        }
        
        {
	        Button button = new Button("A Grid");
	        button.addClickListener(e -> {
	        	final Window w = grid.popupWindow(GridExample.listSize(10000));
	        	this.addWindow(w);
	        });
	        
	        layout.addComponent(button);
        }
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
