package com.blargh.AanP.client;

import com.blargh.AanP.client.mvp.AppActivityMapper;
import com.blargh.AanP.client.mvp.AppPlaceHistoryMapper;
import com.blargh.AanP.client.place.HomePlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

public class AandP implements EntryPoint {

	private Place default_place = new HomePlace();
	private SimplePanel container = new SimplePanel();
	
	public void onModuleLoad() {
		
		ClientFactory client_factory = GWT.create(ClientFactory.class);
		EventBus event_bus = client_factory.eventBus();
		PlaceController place_controller = client_factory.placeController();
		
		// Start ActivityManager for the main widget with the ActivityMapper
		ActivityMapper activity_mapper = new AppActivityMapper(client_factory);
		ActivityManager activity_manager = new ActivityManager(activity_mapper, event_bus);
		activity_manager.setDisplay(container);
		
		// Start PlaceHistoryHandler with PlaceHistoryMapper
		AppPlaceHistoryMapper history_mapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler history_handler = new PlaceHistoryHandler(history_mapper);
		history_handler.register(place_controller, event_bus, default_place);
		
		RootPanel.get().add(container);
		history_handler.handleCurrentHistory();
		
	}
	
}
