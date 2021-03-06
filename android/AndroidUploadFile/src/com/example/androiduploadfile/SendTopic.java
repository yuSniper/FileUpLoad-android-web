package com.example.androiduploadfile;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

public class SendTopic {
	public static void sendtopic(final String urlstring) {
		Thread t = new Thread() {
			@Override
			public void run() {
				// 提交的数据需要经过url编码，英文和数字编码后不变

				String path = "http://192.168.47.114:8080/ZuBa/servlet/InsertPublish";

				try {
					URL url = new URL(path);
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					conn.setRequestMethod("POST");
					conn.setConnectTimeout(5000);
					conn.setReadTimeout(5000);
					conn.setRequestProperty("connection", "keep-alive");
					conn.setRequestProperty("Content-Type",
							"multipart/form-data" + ";boundary="
									+ UUID.randomUUID().toString());

					// 拼接出要提交的数据的字符串
					// String data = "name=" + URLEncoder.encode(name) +
					// "&pass="
					// + pass;
					// String str = URLEncoder.encode("张三", "UTF-8");

					// String str1 =new String("张三".getBytes(), "utf-8");

					// insert into publish_table set username = ?, type = ?,
					// topic = ?, phonenum = ?, salary = ?, context = ?, imgurl
					// = ?, pub_date = ?;
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonObject1 = null;
					try {
						jsonObject.put("imgurl", urlstring);
						jsonObject.put("username", "李四");
						jsonObject.put("type", "1");
						jsonObject.put("topic", "发表主题");
						jsonObject.put("phonenum", "123456");
						jsonObject.put("salary", "10000");
						jsonObject.put("context", "发表主题内容。。。。。。");
						jsonObject.put("pub_date", "1860-01-01 12:00:00");

						// jsonObject1 = new JSONObject();
						// jsonObject1.put("login", jsonObject);
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Log.i("lifeweeker", jsonObject2.toString());

					String str = jsonObject.toString();
					String string = URLEncoder.encode(str, "UTF-8");
					
					System.out.println("sendtopic_json" + str);
					System.out.println(string);
					byte[] b = string.getBytes();
					// 添加post请求的两行属性
					conn.setRequestProperty("Content-Type",
							"application/x-www-form-urlencoded;charset=UTF-8");
					conn.setRequestProperty("Content-Length", b.length + "");

					// 设置打开输出流
					conn.setDoOutput(true);
					// 拿到输出流
					// OutputStreamWriter out = new
					// OutputStreamWriter(conn.getOutputStream(), "UTF-8");
					// out.append(string);

					OutputStream os = conn.getOutputStream();
					// 使用输出流往服务器提交数据
					os.write(b);
					// 如果响应码为200，说明请求成功

					System.out.println(conn.getResponseCode() + "");
					if (conn.getResponseCode() == 200) {
						// 获取服务器响应头中的流，流里的数据就是客户端请求的数据
						InputStream is = conn.getInputStream();

						String text = InputStreamString.getTextFromStream(is);
						System.out.println(text);

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		t.start();
	}
}
