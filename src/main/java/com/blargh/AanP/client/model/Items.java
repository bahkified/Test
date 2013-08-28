package com.blargh.AanP.client.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.blargh.AanP.client.model.Item.ItemCallback;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

public class Items implements Iterable<Item> {
// TODO: move data retrieval code to utility class
	private List<Item> items;
	
	public Items(List<Item> items) {
		this.items = items;
	}
	
	public List<Item> asList() {
		return items;
	}
	
	public int size() {
		return items.size();
	}
	
	public Item item(int index) {
		return items.get(index);
	}
	
	public Iterator<Item> iterator() {
		return items.iterator();
	}

	private static class JsItems extends JavaScriptObject {
		
		protected JsItems() {}
		
		public final native JsArrayInteger items() /*-{ return this.items; }-*/;
		
	}
	
	private static JsItems items_cache;
	private static Items cache;
	
	private static List<Integer> pending;
	
	public static void retrieveItems(final ItemListCallback cb) {
		pending = new ArrayList<Integer> ();
		
		final List<Item> items_list = new ArrayList<Item> ();
		
		final String items_url = "https://api.guildwars2.com/v1/items.json";
		
		if (cache != null) {
			cb.onItemsRetrieved(cache);
		}
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, items_url);
		
		try {
			
			builder.sendRequest(null, new RequestCallback() {
				public void onResponseReceived(Request request,
						Response response) {
					if (response.getStatusCode() == 200) {
						// Good response, received JSON data
						JsItems ids = 
								JsonUtils.safeEval(response.getText());
						
						items_cache = ids;
					} else {
						// TODO error
						Window.alert("Unable to get data.\n"
								+ response.getStatusText());
					}
					
					// TODO: paging
					for (int i = 0; i < /*ids.length()*/20; i++) {
						pending.add(items_cache.items().get(i));
						Item.addItem(items_cache.items().get(i), 
								new ItemCallback() {

							public void onItemRetrieved(Item item) {
								items_list.add(item);
								pending.remove(pending.size() - 1);
								
								if (pending.isEmpty()) {
									cache = new Items(items_list);
									cb.onItemsRetrieved(cache);
								}
							}
							
						});
					}
				}

				public void onError(Request request, Throwable exception) {
					// TODO
					Window.alert("Error getting data.\n" + exception.getMessage());
				}
			});
			
		} catch (RequestException e) {
			// TODO
			Window.alert("Error sending request.\n" + e.getMessage());
		}
	}
	
}
