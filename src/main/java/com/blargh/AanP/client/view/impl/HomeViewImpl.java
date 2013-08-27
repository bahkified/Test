package com.blargh.AanP.client.view.impl;

import com.blargh.AanP.client.view.HomeView;
import com.google.gwt.user.client.ui.Composite;

public class HomeViewImpl extends Composite implements HomeView {

	private Presenter presenter;
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
