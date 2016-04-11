package com.help.autotest.listener;

public class StaticPara {
	public static String resultCsvFilename = null;
	public static StringBuffer successStr = new StringBuffer();
	public static StringBuffer failureStr = new StringBuffer();
	public static StringBuffer skipStr = new StringBuffer();
	public static StringBuffer unknowStr = new StringBuffer();
	public static StringBuffer headStr = new StringBuffer();
	public static StringBuffer endStr = new StringBuffer();

	public static Long successCount = 0L;
	public static Long failureCount = 0L;
	public static Long skipCount = 0L;
	public static Long unknowCount = 0L;
	public static Long allCount = 0L;

}
