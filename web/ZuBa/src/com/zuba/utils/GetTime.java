package com.zuba.utils;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class GetTime {

	@Test
	public void test() {
		System.out.println(GetCurDate());
		System.out.println(GetCurTime());
		System.out.println(GetDateTimeString());
	}

	@SuppressWarnings("deprecation")
	public String GetCurTime()// 获得当前时间
	{
		Date now = new Date();

		return now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
	}

	public String GetCurDate()// 获得当前日期
	{
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1)
				+ "月" + cal.get(Calendar.DATE) + "日";
	}

	public String GetDateTimeString() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1)
				+ "月" + cal.get(Calendar.DATE) + "日" + now.getHours() + ":"
				+ now.getMinutes() + ":" + now.getSeconds();
	}

	// 字符串转化为日期字符串20050412->2005-04012
	public String FormatDateStr(String Str) {
		try {
			String bb = "";
			int num = 8 - Str.length();
			for (int i = 0; i < num; i++)// 不足8位要补足8位
			{
				Str = "0" + Str;
			}
			String str1 = Str.substring(0, 4);
			bb = bb + str1 + "-";
			str1 = Str.substring(4, 6);
			bb = bb + str1 + "-";
			str1 = Str.substring(6, 8);
			bb = bb + str1;
			return bb;
		} catch (Exception e) {
			return "";
		}
	}

	// //字符串转化为时间字符串130416－>13:04:16
	public String FormatTimeStr(String Str) {
		try {
			String bb = "";
			int num = 6 - Str.length();
			for (int i = 0; i < num; i++)// 不足6位要补足6位51325->05:13:25
			{
				Str = "0" + Str;
			}
			String str1 = Str.substring(0, 2);
			bb = bb + str1 + ":";
			str1 = Str.substring(2, 4);
			bb = bb + str1 + ":";
			str1 = Str.substring(4, 6);
			bb = bb + str1;
			return bb;
		} catch (Exception e) {
			return "";
		}
	}
}
