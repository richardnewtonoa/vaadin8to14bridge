package com.vaadin.ui;

import com.vaadin.flow.component.notification.Notification.Position;

public class Notification {

	public static enum Type {
		WARNING_MESSAGE(0, Position.MIDDLE);
		
		final int duration;
		final Position position;
		
		Type(int duration, Position position) {
			this.duration = duration;
			this.position = position;
		}

		public int getDuration() {
			return duration;
		}

		public Position getPosition() {
			return position;
		}
		
		public String getCssClass() {
			return "v8-notification-" + name();
		}
	}

	public static void show(String message, Type type) {
		final com.vaadin.flow.component.notification.Notification n = new com.vaadin.flow.component.notification.Notification(message, type.getDuration(), type.getPosition());
		n.getElement().getClassList().add(type.getCssClass());
		n.open();
	}
}
