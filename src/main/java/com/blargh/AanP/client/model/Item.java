package com.blargh.AanP.client.model;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

public class Item extends JavaScriptObject {
	
	public interface ItemCallback {
		void onItemRetrieved(Item item);
	}
	
	protected Item() {}
	
	public final native int id() /*-{ return this.item_id; }-*/;
	
	public final native String name() /*-{ return this.name; }-*/;
	public final native String description() /*-{ return this.description; }-*/;
	public final native String type() /*-{ return this.type; }-*/;
	public final native String level() /*-{ return this.level; }-*/;
	public final native String rarity() /*-{ return this.rarity; }-*/;
	public final native String vendor_value() /*-{ return this.vendor_value; }-*/;
	public final native String icon_file_id() /*-{ return this.icon_file_id; }-*/;
	public final native String icon_file_signature() /*-{ return this.icon_file_signature; }-*/;
	
	public static void addItem(int id, final ItemCallback cb) {
		
		final String item_url = 
				"https://api.guildwars2.com/v1/item_details.json?item_id="
				+ id;

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, item_url);
		
		try {
			
			builder.sendRequest(null, new RequestCallback() {
				public void onResponseReceived(Request request,
						Response response) {
					if (response.getStatusCode() == 200) {
						// Good response, received JSON data
						Item item = JsonUtils.safeEval(response.getText());
						Window.alert("Item: "
								+ item.id() + "\n"
								+ item.name());
						//items.add(item);
						
						cb.onItemRetrieved(item);
					} else {
						// TODO error
						Window.alert("Unable to get data.\n"
								+ response.getStatusText());
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
/*item_id (number) – The item id.
name (string) – The name of the item.
description (string) – The item description.
type (string) – The item type.
level (string) – The required level.
rarity (string) – The rarity.
vendor_value (string) – The value in coins when selling to a vendor.
icon_file_id (string) – The icon file id to be used with the render service.
icon_file_signature (string) – The icon file signature to be used with the render service.
game_types (list) – The game types where the item is usable.
flags (list) – Additional item flags.
restrictions (list) – Restrictions*/