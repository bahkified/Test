package com.blargh.AanP.client.view.impl;

import com.blargh.AanP.client.place.ItemListPlace;
import com.blargh.AanP.client.view.HomeView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

public class HomeViewImpl extends Composite implements HomeView {

	private FlowPanel main;
	
	private Label item_list;
	
	private Presenter presenter;
	
	public HomeViewImpl() {
		main = new FlowPanel();
		
		item_list = new Label("List of Items");
		
		main.add(new HTML("<p>Welcome to this test page for Activities and Places, using"
				+ " the Google Web Toolkit.</p> </br>"));
		main.add(item_list);
		
		initWidget(main);
		
		item_list.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				presenter.goTo(new ItemListPlace());
			}
		});
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
