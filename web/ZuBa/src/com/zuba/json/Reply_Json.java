package com.zuba.json;

import org.json.JSONException;
import org.json.JSONObject;

import com.zuba.moclass.Reply;

public class Reply_Json {
	public static Reply insertReply(String jString) {
		Reply reply = new Reply();
		try {
			JSONObject jsonObject = new JSONObject(jString.toString());
			// Iterator iterator = jsonObject.keys();
			// while (iterator.hasNext()) {
			// key = iterator.next().toString();
			//
			// }
			reply.setTopic_id(Integer.parseInt(jsonObject.getString("topic_id")));
			reply.setUsername(jsonObject.getString("username"));
			reply.setComment(jsonObject.getString("comment"));
			reply.setCom_date(jsonObject.getString("com_date"));

			// mapuser.put(key, user);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reply;
	}
}
