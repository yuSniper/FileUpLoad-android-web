package com.zuba.json;

import org.json.JSONException;
import org.json.JSONObject;

import com.zuba.moclass.Publish;

public class Publish_Json {
	public static Publish insertPublish(String jString) {
		Publish publish = new Publish();
		try {
			JSONObject jsonObject = new JSONObject(jString.toString());
			// Iterator iterator = jsonObject.keys();
			// while (iterator.hasNext()) {
			// key = iterator.next().toString();
			//
			// }
			
			publish.setUsername(jsonObject.getString("username"));
			publish.setType(Integer.parseInt(jsonObject.getString("type")));
			publish.setTopic(jsonObject.getString("topic"));
			publish.setPhonenum(jsonObject.getString("phonenum"));
			publish.setSalary(jsonObject.getString("salary"));
			publish.setContext(jsonObject.getString("context"));
			publish.setImgurl(jsonObject.getString("imgurl"));
			publish.setPub_date(jsonObject.getString("pub_date"));
			// mapuser.put(key, user);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return publish;
	}
}
