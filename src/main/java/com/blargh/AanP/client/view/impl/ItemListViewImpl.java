package com.blargh.AanP.client.view.impl;

import com.blargh.AanP.client.view.ItemListView;
import com.google.gwt.user.client.ui.Composite;

public class ItemListViewImpl extends Composite implements ItemListView {

	private Presenter presenter;
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
