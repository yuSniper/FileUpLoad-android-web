package com.zuba.json;

import org.json.JSONException;
import org.json.JSONObject;

import com.zuba.moclass.User;

/**
 * // int someInt = jsonObject.getInt("intParamName"); // String someString =
 * jsonObject.getString("stringParamName"); // JSONObject nestedObj =
 * jsonObject.getJSONObject("nestedObjName"); // JSONArray arr =
 * jsonObject.getJSONArray("arrayParamName");
 * 
 * @author yu_longji
 * 
 */

public class User_Json {
	// 登录
	public static User loginUser(String jString) {
		User user = new User();
		// Map<String, User> mapuser = new HashMap<String, User>();
		// String key = null;
		try {
			JSONObject jsonObject = new JSONObject(jString.toString());
			// Iterator iterator = jsonObject.keys();
			// while (iterator.hasNext()) {
			// key = iterator.next().toString();
			//
			// }
			user.setUsername(jsonObject.getString("username"));
			user.setPwd(jsonObject.getString("psw"));
			// mapuser.put(key, user);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	// 注册
	public static User registerUser(String jString) {
		User user = new User();
		// Map<String, User> mapuser = new HashMap<String, User>();
		// String key = null;
		try {
			JSONObject jsonObject = new JSONObject(jString.toString());
			// Iterator iterator = jsonObject.keys();
			// while (iterator.hasNext()) {
			// key = iterator.next().toString();
			//
			// }
			user.setUsername(jsonObject.getString("username"));
			user.setPwd(jsonObject.getString("psw"));

			// mapuser.put(key, user);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	// 更新
	public static User updateUser(String jString) {
		User user = new User();
		// Map<String, User> mapuser = new HashMap<String, User>();
		// String key = null;
		try {
			JSONObject jsonObject = new JSONObject(jString.toString());

			user.setUsername(jsonObject.getString("username"));
			user.setHeadpicture(jsonObject.getString("headpicture"));
			user.setNickname(jsonObject.getString("nickname"));
			user.setName(jsonObject.getString("name"));
			user.setJob(jsonObject.getString("job"));
			user.setAge(jsonObject.getInt("age"));
			user.setSex(jsonObject.getString("sex"));
			user.setAddress(jsonObject.getString("address"));
			// user.setId(jsonObject.getInt("id"));
			System.out.println("json:" + user);
			// mapuser.put(key, user);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
