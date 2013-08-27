package com.blargh.AanP.client.view;

import com.blargh.AanP.client.AandPPresenter;
import com.google.gwt.user.client.ui.IsWidget;

public interface HomeView extends IsWidget {
	
	void setPresenter(Presenter presenter);
	
	public interface Presenter extends AandPPresenter {
		
	}
	
}
