package com.blargh.AanP.client;

import com.blargh.AanP.client.view.HomeView;
import com.blargh.AanP.client.view.ItemListView;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {
	
	EventBus eventBus();
	PlaceController placeController();
	HomeView homeView();
	ItemListView itemListView();
	
}
