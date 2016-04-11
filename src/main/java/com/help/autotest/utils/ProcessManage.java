package com.help.autotest.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ProcessManage {

	/**
	 * 查找进程
	 *
	 * @param processname
	 * @return
	 */
	public static boolean findProcess(String processname) {
		BufferedReader bufferedreader = null;
		try {
			Process proc = Runtime.getRuntime().exec(
					"tasklist /fi \" imagename eq " + processname + " \" ");
			bufferedreader = new BufferedReader(new InputStreamReader(proc
					.getInputStream()));
			String line = null;
			while ((line = bufferedreader.readLine()) != null) {
				if (line.contains(processname)) {
					return true;
				}
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if (bufferedreader != null) {
				try {
					bufferedreader.close();
				} catch (Exception ex) {
				}
			}
		}
	}

	/**
	 * 杀进程
	 *
	 * @param processname
	 */
	public static void killProcess(String processname) {
		BufferedReader bufferedreader = null;
		try {
			Process proc = Runtime.getRuntime().exec(
					"taskkill /F /IM " + processname);
			bufferedreader = new BufferedReader(new InputStreamReader(proc
					.getInputStream()));
			String line = null;
			while ((line = bufferedreader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (bufferedreader != null) {
				try {
					bufferedreader.close();
				} catch (Exception ex) {
				}
			}
		}
	}
}
