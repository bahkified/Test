package com.blargh.AanP.client.mvp;

import com.blargh.AanP.client.place.HomePlace;
import com.blargh.AanP.client.place.ItemListPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({HomePlace.Tokenizer.class, ItemListPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
	
}
