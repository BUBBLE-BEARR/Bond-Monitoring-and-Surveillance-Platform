package com.project.common.core.constant;

/**
 * 	SMS短信服务相关常量信息
 * 
 * @author yangyc
 */
public class SmsConstants
{
    /**
     * 	短信相关异常信息用于日志
     */
    public static final String SMS_SEND_LOG_MESSAGE = "短信发送异常";
	/**
	 * 	短信相关异常信息用于异常类
	 */
	public static final String SMS_SEND_EXP_MESSAGE = "短信发送失败，请联系网站管理员！";
	/**
	 * 	返回码的字段名称
	 */
	public static final String RESULT_CODE_NAME = "success";
	/**
	 * 	验证手机号码格式正则
	 */
	public static final String MOBILE_NUM_REGULAR_EXPRESSION = "^[1]\\\\d{10}$";
	/**
	 * 	存在期
	 */
	public static final String SMS_EXT_TIME = "60";
	/**
	 * 	签名
	 */
	public static final String SMS_SIGN_NAME = "【中证报价】";
}
