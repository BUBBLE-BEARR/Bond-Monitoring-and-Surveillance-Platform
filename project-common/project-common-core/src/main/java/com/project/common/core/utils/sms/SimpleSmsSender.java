package com.project.common.core.utils.sms;


import com.project.common.core.domain.SmsSenderInfo;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SimpleSmsSender {

	private static String smsEncoding = "GB2312";

	public SimpleSmsSender(){}

	public String getMsgText(SmsSenderInfo smsSenderInfo){
		String xml = (new StringBuilder()).append("<?xml version=\"1.0\" encoding=\"").append(smsEncoding).append("\"?>").toString();
		xml = (new StringBuilder()).append(xml).append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">").toString();
		xml = (new StringBuilder()).append(xml).append("<soap:Body>").toString();
		xml = (new StringBuilder()).append(xml).append("<mt xmlns=\"http://tempuri.org/\">").toString();
		xml = (new StringBuilder()).append(xml).append("<sn>").append(smsSenderInfo.getSn()).append("</sn>").toString();
		xml = (new StringBuilder()).append(xml).append("<pwd>").append(smsSenderInfo.getPassword()).append("</pwd>").toString();
		xml = (new StringBuilder()).append(xml).append("<mobile>").append(smsSenderInfo.getMobile()).append("</mobile>").toString();
		xml = (new StringBuilder()).append(xml).append("<content>").append(smsSenderInfo.getContent()).append("</content>").toString();
		xml = (new StringBuilder()).append(xml).append("<ext>").append(smsSenderInfo.getExt()).append("</ext>").toString();
		xml = (new StringBuilder()).append(xml).append("<stime>").append(smsSenderInfo.getStime()).append("</stime>").toString();
		xml = (new StringBuilder()).append(xml).append("<rrid>").append(smsSenderInfo.getRrid()).append("</rrid>").toString();
		xml = (new StringBuilder()).append(xml).append("</mt>").toString();
		xml = (new StringBuilder()).append(xml).append("</soap:Body>").toString();
		xml = (new StringBuilder()).append(xml).append("</soap:Envelope>").toString();
		return xml;
	}

	public static boolean isMobile(SmsSenderInfo smsSenderInfo){
		//如果有多个手机号码
		boolean flag = false;
		try{
			Pattern p = Pattern.compile(smsSenderInfo.getMobileCheckRule());
			String[] phone = StringUtils.split(smsSenderInfo.getMobile(), ",");
			for(String s:phone){
				Matcher m = p.matcher(smsSenderInfo.getMobile());
				flag = m.matches();
				System.out.println(s);
			}
		}catch (Exception e){
			flag = false;
		}
		return flag;
	}
	
	/*
	 * 方法名称：mdgxsend 
	 * 功    能：发送个性短信 
	 * 参    数：mobile,content,ext,stime,rrid,msgfmt(手机号，内容，扩展码，定时时间，唯一标识，内容编码)
	 * 返 回 值：唯一标识，如果不填写rrid将返回系统生成的
	 */
	
	public Map<String, Object> sendSMS(SmsSenderInfo smsSenderInfo){
		Map<String, Object> returnMap = new HashMap<>();
		if ("".equals(smsSenderInfo.getMobile())){
			returnMap.put("success", Boolean.valueOf(false));
			returnMap.put("msg", "短信接收方手机号码不存在");
		} 
//		else if (!isMobile(smsSenderInfo)){
//			returnMap.put("success", Boolean.valueOf(false));
//			returnMap.put("msg", "短信接收方手机号码号码非法");
//		} 
		else{
			String soapAction = "http://tempuri.org/mt";
			String result = "";
			String xml = getMsgText(smsSenderInfo);
			try{
				URL url = new URL(smsSenderInfo.getServiceURL());
				URLConnection connection = url.openConnection();
				HttpURLConnection httpconn = (HttpURLConnection)connection;
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				bout.write(xml.getBytes("GB2312"));
				byte b[] = bout.toByteArray();
				httpconn.setRequestProperty("Content-Length", String.valueOf(b.length));
				httpconn.setRequestProperty("Content-Type", (new StringBuilder()).append("text/xml; charset=").append(smsEncoding).toString());
				httpconn.setRequestProperty("SOAPAction", soapAction);
				httpconn.setRequestMethod("POST");
				httpconn.setDoInput(true);
				httpconn.setDoOutput(true);
				OutputStream out = httpconn.getOutputStream();
				out.write(b);
				out.close();
				InputStreamReader isr = new InputStreamReader(httpconn.getInputStream());
				BufferedReader in = new BufferedReader(isr);
				boolean sendSuccess = false;
				do{
					String inputLine;
					if (null == (inputLine = in.readLine()))
						break;
					Pattern pattern = Pattern.compile("<mtResult>(.*)</mtResult>");
					for (Matcher matcher = pattern.matcher(inputLine); matcher.find();){
						sendSuccess = true;
						result = matcher.group(1);
					}
					try{
						long code = Long.valueOf(result).longValue();
						if (code <= 0L){
							sendSuccess = false;
							result = "发送短信失败，可能系统已经欠费。";
						}
					}
					catch (Exception e){
						sendSuccess = false;
						result = "调用短信网关返回失败信息";
					}
				} while (true);
				returnMap.put("success", Boolean.valueOf(sendSuccess));
				returnMap.put("msg", result);
			}catch (Exception e){
				System.out.println((new StringBuilder()).append("调用sendSMS方法推送网关时候失败!").append(e.getMessage()).toString());
				returnMap.put("success", Boolean.valueOf(false));
				returnMap.put("msg", "调用短信网关时发生错误，请稍后重试");
			}
		}
		return returnMap;
	}
}
