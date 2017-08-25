package org.lanqiao.util;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormat {
	/**
	 * 将java.util包中的Date转为java.sql.Date
	 * @return
	 */
	public static Date dateToSQLDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String curr = sdf.format(new java.util.Date());
		java.sql.Date curr_time = null;
		try {
			curr_time = new java.sql.Date(sdf.parse(curr).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return curr_time;
	}
	
	/**
	 * 将数据库时间转换为字符串类型
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String formatDate = sdf.format(date);
		return formatDate;
	}

}
