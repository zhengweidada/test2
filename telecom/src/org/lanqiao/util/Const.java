package org.lanqiao.util;

public class Const {
	/**
	 * 资费表-资费类型
	 */
	public static final int EXP_TYPE_MONTH_CODE = 0;
	public static final String  EXP_TYPE_MONTH = "包月";
	
	public static final int EXP_TYPE_MEAL_CODE= 1;
	public static final String  EXP_TYPE_MEAL = "套餐";
	
	public static final int EXP_TYPE_TIME_CODE = 2;
	public static final String EXP_TYPE_TIME = "计时";
	
	/**
	 * 将字符串类型转化为数字类型存储到数据库中
	 * @param str
	 * @return
	 */
	/*public static int changeTypeToCode(String str){
		int typeCode = EXP_TYPE_MONTH_CODE;
		switch (str) {
		case "0":
			typeCode = EXP_TYPE_MONTH_CODE;
			break;
		case "1":
			typeCode = EXP_TYPE_MEAL_CODE;
			break;
		case "2":
			typeCode = EXP_TYPE_TIME_CODE;
			break;
		default:
			typeCode = EXP_TYPE_MONTH_CODE;
			break;
		}
		return typeCode;
	}
	*/
	/**
	 * 将数字类型数字类型转化为字符串类型
	 * @param code
	 * @return
	 */
	public static String changeTypeToString(int code){
		String typeString = EXP_TYPE_MONTH;
		switch (code) {
		case EXP_TYPE_MONTH_CODE:
			typeString = EXP_TYPE_MONTH;
			break;
		case EXP_TYPE_MEAL_CODE:
			typeString = EXP_TYPE_MEAL;
			break;
		case EXP_TYPE_TIME_CODE:
			typeString = EXP_TYPE_TIME;
			break;
		default:
			typeString = EXP_TYPE_MONTH;
			break;
		}
		return typeString;
	}
	
	
	
	/**
	 * 资费表-资费状态
	 */
	public static final int EXP_STATUS_PAUSE_CODE = 0;
	public static final String EXP_STATUS_PAUSE = "暂停";
	
	public static final int EXP_STATUS_OPEN_CODE= 1;
	public static final String EXP_STATUS_OPEN = "启用";
	
	public static final int EXP_STATUS_DEL_CODE= 2;
	public static final String EXP_STATUS_DEL = "删除";
	
	/**
	 * 将资费状态转化为数字类型
	 * @param str
	 * @return
	 */
	/*public static int changeStatusToCode(String str){
		int statusCode = EXP_STATUS_PAUSE_CODE;
		switch (str) {
		case EXP_STATUS_PAUSE:
			statusCode = EXP_STATUS_PAUSE_CODE;
			break;
		case EXP_STATUS_OPEN:
			statusCode = EXP_STATUS_OPEN_CODE;
			break;
		case EXP_STATUS_DEL:
			statusCode = EXP_STATUS_DEL_CODE;
			break;
		default:
			statusCode = EXP_STATUS_PAUSE_CODE;
			break;
		}
		return statusCode;
	}*/
	
	public static String changeStatusToString(int code){
		String statuString = EXP_STATUS_OPEN;
		switch (code) {
		case EXP_STATUS_PAUSE_CODE:
			statuString = EXP_STATUS_PAUSE;
			break;
		case EXP_STATUS_OPEN_CODE:
			statuString = EXP_STATUS_OPEN;
			break;
		case EXP_STATUS_DEL_CODE:
			statuString = EXP_STATUS_DEL;
			break;
		default:
			statuString = EXP_STATUS_OPEN;
			break;
		}
		return statuString;
	}
	
	

}
