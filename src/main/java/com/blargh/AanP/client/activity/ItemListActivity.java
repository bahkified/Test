package com.blargh.AanP.client.activity;

import com.blargh.AanP.client.ClientFactory;
import com.blargh.AanP.client.model.ItemListCallback;
import com.blargh.AanP.client.model.Items;
import com.blargh.AanP.client.place.ItemListPlace;
import com.blargh.AanP.client.view.ItemListView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ItemListActivity extends AbstractActivity implements ItemListView.Presenter {

	private ClientFactory client_factory;
	
	public ItemListActivity(ItemListPlace place, ClientFactory client_factory) {
		this.client_factory = client_factory;
	}
	
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		ItemListView item_list_view = client_factory.itemListView();
		item_list_view.setPresenter(this);
		panel.setWidget(item_list_view.asWidget());
		
		Items.retrieveItems(new ItemListCallback() {
			public void onItemsRetrieved(Items items) {
				ItemListView view = client_factory.itemListView();
				
				view.setItems(items);
			}
		});
	}

	public void goTo(Place place) {
		client_factory.placeController().goTo(place);
	}

}
