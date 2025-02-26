package com.project.common.core.utils.sms;

import com.project.common.core.constant.SmsConstants;
import com.project.common.core.domain.SmsSenderInfo;
import com.project.common.core.exception.ServiceException;
import com.project.common.core.utils.sign.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


/**
 * 
 * 	发送短信信息类
 * @author User
 *
 */
public class SmsUtils {
    private SmsUtils() {};

	private static final Logger log = LoggerFactory.getLogger(SmsUtils.class);
	public static boolean getSMSResult(String content,String moblie,String serviceURL,String sn,String password){
		Boolean result  = false;
		try {
			SmsSenderInfo smsSenderInfo = new SmsSenderInfo();
		    smsSenderInfo.setServiceURL(serviceURL.trim());
		    smsSenderInfo.setContent(content + SmsConstants.SMS_SIGN_NAME);
		    smsSenderInfo.setSn(sn.trim());
		    smsSenderInfo.setMobile(moblie);//
		    smsSenderInfo.setPassword(MD5Util.getMD5(sn.trim() + password.trim()));//MD5(SN+PWD)
		    smsSenderInfo.setExt(SmsConstants.SMS_EXT_TIME);
		    smsSenderInfo.setRrid("");
		    //验证手机号码格式，只需要匹配11位数字
		    smsSenderInfo.setMobileCheckRule(SmsConstants.MOBILE_NUM_REGULAR_EXPRESSION);
		    SimpleSmsSender simpleSmsSender = new SimpleSmsSender();
		    Map<String, Object> map = simpleSmsSender.sendSMS(smsSenderInfo);
		    result = (Boolean) map.get(SmsConstants.RESULT_CODE_NAME);
		} catch (Exception e) {
			result = false;
			log.error(SmsConstants.SMS_SEND_LOG_MESSAGE+"{}", e.getMessage());
			throw new ServiceException(SmsConstants.SMS_SEND_EXP_MESSAGE);
		}
	    return result;
	}
	
	/**
	 * 
	 * 	创建指定数量的随机字符串
	 * 
	 * @param numberFlag 是否是数字
	 * 
	 * @param length
	 * 
	 * @return
	 * 
	 */
	public static String createRandom(boolean numberFlag, int length) {
		String retStr = "";
		String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);
		return retStr;
	}
}
