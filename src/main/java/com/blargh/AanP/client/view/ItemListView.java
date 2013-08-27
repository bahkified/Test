package com.blargh.AanP.client.view;

import com.blargh.AanP.client.AandPPresenter;
import com.blargh.AanP.client.model.Items;
import com.google.gwt.user.client.ui.IsWidget;

public interface ItemListView extends IsWidget {
	
	void setItems(Items items);
	
	void setPresenter(Presenter presenter);
	
	public interface Presenter extends AandPPresenter {
		
	}
	
}
