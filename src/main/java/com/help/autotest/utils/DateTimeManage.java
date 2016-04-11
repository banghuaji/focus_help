package com.help.autotest.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeManage {
	public static String getSystemTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return (sdf.format(date) + (int) (Math.random() * 900000 + 100000));
	}

}
