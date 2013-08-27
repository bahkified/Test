package com.blargh.AanP.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ItemListPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<ItemListPlace> {

		public ItemListPlace getPlace(String token) {
			return new ItemListPlace();
		}

		public String getToken(ItemListPlace place) {
			return "list";
		}
		
	}
	
}
