package com.blargh.AanP.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class HomePlace extends Place {
	
	private final static String token = "home";
	
	public static class Tokenizer implements PlaceTokenizer<HomePlace> {

		public HomePlace getPlace(String token) {
			return new HomePlace();
		}

		public String getToken(HomePlace place) {
			return token;
		}
		
	}
	
}
