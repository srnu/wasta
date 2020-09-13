package com.id.wasta.util.action;

import java.util.Calendar;
import java.util.Date;

public class StringUtil {

	public static Date increaseDayCalendar(Date date,int days) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, days);
			return c.getTime();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static boolean isBlank(String str){
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

}