package com.blargh.AanP.client.activity;

import com.blargh.AanP.client.ClientFactory;
import com.blargh.AanP.client.place.HomePlace;
import com.blargh.AanP.client.view.HomeView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class HomeActivity extends AbstractActivity implements HomeView.Presenter {

	private ClientFactory client_factory;
	
	public HomeActivity(HomePlace place, ClientFactory client_factory) {
		this.client_factory = client_factory;
	}
	
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		HomeView home_view = client_factory.homeView();
		home_view.setPresenter(this);
		panel.setWidget(home_view.asWidget());
	}
	
	@Override
	public String mayStop() {
		return "Stopping...";
	}
}
