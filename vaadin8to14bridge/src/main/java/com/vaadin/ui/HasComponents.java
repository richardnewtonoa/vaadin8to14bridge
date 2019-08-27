package com.vaadin.ui;

public interface HasComponents extends Component {

	public default void addComponent(Component... cs) {
		if (cs != null) {
			for (Component c : cs) {
				if (c != null) {
					addComponent(c);
				}
			}
		}		
	}
	
	public void addComponent(Component component);
}
