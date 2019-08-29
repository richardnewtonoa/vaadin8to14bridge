package com.kirona.vaadin8examples;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.SerializablePredicate;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import lombok.AllArgsConstructor;
import lombok.Data;

public class GridExample {

	@Data
	@AllArgsConstructor
	public static class GridBean {
		private long id;
		private LocalDateTime dateTime;
		private String description;
		private boolean enabled;
	}
	
	public static List<GridBean> listSize(int listSize) {
		final List<GridBean> l = new ArrayList<>();
		
		for (int i = 0; i < listSize; i++) {
			GridBean b = new GridBean(i, LocalDateTime.now().plusHours(i), "Bean " + i, (i%3==0) );
			l.add(b);
		}
		
		return l;
	}
	
	public Window popupWindow(Collection<GridBean> data) {
		final Window w = new Window("Basic Grid");
		w.addStyleName("basicGrid");
		w.setWidth("90%");
		w.setHeight("90%");
		
		w.setContent(generateGrid(data, fb->{
			w.close();
		}));
		
		return w;
	}

	private String format(LocalDateTime ldt) {
		if (ldt == null) { return ""; }
		return ldt.format(DateTimeFormatter.ofPattern("d MMM uu KK:mm a"));
	}
	
	private String format(boolean b) {
		return b ? "Yes" : "";
	}
	
	private Component generateGrid(final Collection<GridBean> data, final Consumer<Collection<GridBean>> closeHandler) {
		// here we generate a Grid above a close button
		
		final DataProvider<GridBean, SerializablePredicate<GridBean>> dp = new ListDataProvider<>(data);
		
		final Grid<GridBean> grid = new Grid<>();
		grid.setDataProvider(dp);
		grid.addStyleName("grid");
		grid.setWidth("100%");
		grid.setHeight("100%");
		grid.setSelectionMode(SelectionMode.NONE);
	
		grid.setColumns();
		
		grid.addColumn(GridBean::getId)
			.setCaption("ID")
			.setExpandRatio(1);
		
		grid.addColumn(b->this.format(b.isEnabled()))
			.setCaption("Enabled?")
			.setExpandRatio(1);
		
		grid.addColumn(b->this.format(b.getDateTime()))
			.setCaption("Date / Time")
			.setExpandRatio(1);
		
		grid.addColumn(GridBean::getDescription)
			.setCaption("Description")
			.setExpandRatio(10);
		
		final Button close = new Button("Close");
		close.addClickListener(ev-> closeHandler.accept( ((ListDataProvider<GridBean>)dp).getItems()));
		
		
		final VerticalLayout vl = new VerticalLayout();
		vl.setWidth("100%");
		vl.setHeight("100%");
		
		vl.addComponent(grid);
		vl.addComponent(close);
		
		vl.setExpandRatio(grid, 1f);
		
		return vl;
	}
	
}
