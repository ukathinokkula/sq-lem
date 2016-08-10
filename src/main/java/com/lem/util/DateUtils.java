package com.lem.util;


import java.util.Calendar;


public class DateUtils {
	
	
	public static java.sql.Date currentDate(){
		 Calendar calendar = Calendar.getInstance();
	      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		
		return startDate;
	}

}
