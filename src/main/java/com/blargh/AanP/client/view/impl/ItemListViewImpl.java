package com.blargh.AanP.client.view.impl;

import com.blargh.AanP.client.model.Item;
import com.blargh.AanP.client.model.Items;
import com.blargh.AanP.client.view.ItemListView;
import com.blargh.AanP.client.widgets.ItemCell;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.view.client.MultiSelectionModel;

public class ItemListViewImpl extends Composite implements ItemListView {

	private Presenter presenter;
	
	private FlowPanel main;
	
	//private ShowMorePagerPanel pager_panel;
	private ScrollPanel top;
	
	private CellList<Item> cell_list;
	private MultiSelectionModel<Item> selection_model;
	
	public ItemListViewImpl() {
		main = new FlowPanel();
		//pager_panel = new ShowMorePagerPanel();
		top = new ScrollPanel();
		
		//main.add(pager_panel);
		main.add(top);
		
		cell_list = new CellList<Item> (new ItemCell());
		cell_list.setPageSize(20);
		
		selection_model = new MultiSelectionModel<Item>();
		cell_list.setSelectionModel(selection_model);
		
		//pager_panel.setDisplay(cell_list);
		top.add(cell_list);
		
		initWidget(main);
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void setItems(Items items) {
		cell_list.setRowCount(20, true);
		cell_list.setRowData(items.asList());
	}

}
