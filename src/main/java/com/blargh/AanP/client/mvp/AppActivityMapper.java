package com.blargh.AanP.client.mvp;

import com.blargh.AanP.client.ClientFactory;
import com.blargh.AanP.client.activity.HomeActivity;
import com.blargh.AanP.client.activity.ItemListActivity;
import com.blargh.AanP.client.place.HomePlace;
import com.blargh.AanP.client.place.ItemListPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory client_factory;
	
	public AppActivityMapper(ClientFactory client_factory) {
		super();
		this.client_factory = client_factory;
	}
	
	/**
	 * Map each Place to its corresponding Activity.
	 */
	public Activity getActivity(Place place) {
		
		if (place instanceof HomePlace) {
			return new HomeActivity((HomePlace) place, client_factory);
		} else if (place instanceof ItemListPlace) {
			return new ItemListActivity((ItemListPlace) place, client_factory);
		}
		
		return null;
	}
	
}
