package com.blargh.AanP.client.widgets;

import com.blargh.AanP.client.model.Item;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class ItemCell extends AbstractCell<Item> {

	@Override
	public void render(Context context, Item value, SafeHtmlBuilder sb) {
		
		if (value == null) {
			return;
		}
		
		sb.appendHtmlConstant("<table>");
		
		sb.appendHtmlConstant("<tr><td>");
		sb.appendHtmlConstant(value.name());
		sb.appendHtmlConstant("</td></tr>");
		
		sb.appendHtmlConstant("<tr><td>");
		sb.appendHtmlConstant(value.type());
		sb.appendHtmlConstant("</td></tr>");
		
		sb.appendHtmlConstant("<tr><td>");
		sb.appendHtmlConstant(value.level());
		sb.appendHtmlConstant("</td></tr>");
		
		sb.appendHtmlConstant("<tr><td>");
		sb.appendHtmlConstant(value.description());
		sb.appendHtmlConstant("</td></tr>");
		
	}
	
}