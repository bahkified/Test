package com.blargh.AanP.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface ItemDetailView extends IsWidget {
	
	void setItemId(String id);
	
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		
	}
	
}
