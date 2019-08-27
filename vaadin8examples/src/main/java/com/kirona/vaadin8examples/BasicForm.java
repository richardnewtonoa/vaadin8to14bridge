package com.kirona.vaadin8examples;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.vaadin.data.Binder;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

import lombok.Data;

/**
 * Some basic Vaadin 8 functionality to convert to Vaadin 14+
 *  
 * @author richard.newton
 */
public class BasicForm {

	@Data
	public static class FormBean {
		private String name;
		private BigDecimal heightMeters;
		private LocalDate birthDate;
	}
	
	static BigDecimal toBigDecimal(String presentation) {
		if ((presentation == null) || presentation.isEmpty()) {
			return null;
		}
		try {
			return new BigDecimal(presentation);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	static String fromBigDecimal(BigDecimal model) {
		if (model == null) { return null; }
		return model.toPlainString();
	}
	
	static boolean greaterThanZero(BigDecimal value) {
		if (value == null) { return true; }  // not validating required here
		return (value.compareTo(BigDecimal.ZERO) > 0);
	}
	
	static boolean inThePast(LocalDate date) {
		if (date == null) { return true; } // not validating mandatory
		return date.isBefore(LocalDate.now());
	}
	
	public Window popupWindow(Supplier<FormBean> initialState, Consumer<FormBean> finalState) {
		final Window w = new Window("Basic Form");
		w.addStyleName("basicForm");
		w.setWidth("30em");
		w.setHeight("20em");
		
		w.setContent(generateForm(initialState, fb->{
			w.close();
			finalState.accept(fb);
		}));
		
		return w;
	}
	
	public Component generateForm(Supplier<FormBean> initialState, Consumer<FormBean> finalState) {
		
		final Binder<FormBean> binder = new Binder<>(FormBean.class);
		binder.setBean(initialState.get());
		
		
		final TextField name = new TextField("Name");
		binder.forField(name)
			.asRequired("Name is mandatory")
			.bind(FormBean::getName, FormBean::setName);
			
		final TextField height = new TextField("Height (m)");
		binder.forField(height)
			.withNullRepresentation("")
			.withConverter(BasicForm::toBigDecimal, BasicForm::fromBigDecimal)
			.withValidator(BasicForm::greaterThanZero, "Must be greater than 0")
			.bind(FormBean::getHeightMeters, FormBean::setHeightMeters);
			
		final DateField birthDate = new DateField("Born");
		binder.forField(birthDate)
			.asRequired("Birth date is required")
			.withValidator(BasicForm::inThePast, "Must be in the past")
			.bind(FormBean::getBirthDate, FormBean::setBirthDate);
		
		final Button cancel = new Button("Cancel");
		cancel.addClickListener(e-> {
			finalState.accept(null);
		});
		
		final Button ok = new Button("OK");
		ok.addClickListener(e-> {
			if (binder.validate().isOk()) {
				finalState.accept(binder.getBean());
			}
			else {
				Notification.show("Please correct any errors and try again", Notification.Type.WARNING_MESSAGE);
			}
		});
		
		final HorizontalLayout buttonArea = new HorizontalLayout();
		buttonArea.addComponent(ok);
		buttonArea.addComponent(cancel);
		
		
		final FormLayout form = new FormLayout();
		form.setWidth("100%");
		form.addStyleName("k-form");
		
		form.addComponent(name);
		form.addComponent(height);
		form.addComponent(birthDate);
		form.addComponent(buttonArea);
		
		return form;
	}
}
