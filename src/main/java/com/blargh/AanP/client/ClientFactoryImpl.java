package com.blargh.AanP.client;

import com.blargh.AanP.client.view.HomeView;
import com.blargh.AanP.client.view.ItemListView;
import com.blargh.AanP.client.view.impl.HomeViewImpl;
import com.blargh.AanP.client.view.impl.ItemListViewImpl;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public class ClientFactoryImpl implements ClientFactory {

	private static final EventBus event_bus = new SimpleEventBus();
	private static final PlaceController place_controller = new PlaceController(event_bus);
	private static final HomeView home_view = new HomeViewImpl();
	private static final ItemListView item_list_view = new ItemListViewImpl();
	
	public EventBus eventBus() {
		return event_bus;
	}

	public PlaceController placeController() {
		return place_controller;
	}

	public HomeView homeView() {
		return home_view;
	}

	public ItemListView itemListView() {
		return item_list_view;
	}
	
	
	
}
