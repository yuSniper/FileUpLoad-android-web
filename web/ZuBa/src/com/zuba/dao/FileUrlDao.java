package com.zuba.dao;

public class FileUrlDao {

	StringBuffer stringBuffer = new StringBuffer();

	private static final FileUrlDao single = new FileUrlDao();

	// 静态工厂方法
	public static FileUrlDao getInstance() {
		return single;
	}

	public void getFileUrl(String string) {
		
		
		stringBuffer.append(string + "|");
		System.out.println(stringBuffer.toString());
	}
}
