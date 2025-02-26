package com.project.common.core.domain;

import com.project.common.core.web.domain.BaseEntity;

public class SmsSenderInfo extends BaseEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serviceURL;
	private String sn;
	private String password;
	private String mobile;
	private String content;
	private String ext;
	private String stime;
	private String rrid;
	private String mobileCheckRule;

	public SmsSenderInfo()
	{
	}

	public String getServiceURL()
	{
		return serviceURL;
	}

	public void setServiceURL(String serviceURL)
	{
		this.serviceURL = serviceURL;
	}

	public String getSn()
	{
		return sn;
	}

	public void setSn(String sn)
	{
		this.sn = sn;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getMobile()
	{
		if (mobile == null)
			return "";
		else
			return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getContent()
	{
		if (content == null)
			return "";
		else
			return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getExt()
	{
		if (ext == null)
			return "";
		else
			return ext;
	}

	public void setExt(String ext)
	{
		this.ext = ext;
	}

	public String getStime()
	{
		if (stime == null)
			return "";
		else
			return stime;
	}

	public void setStime(String stime)
	{
		this.stime = stime;
	}

	public String getRrid()
	{
		if (rrid == null)
			return "";
		else
			return rrid;
	}

	public void setRrid(String rrid)
	{
		this.rrid = rrid;
	}

	public String getMobileCheckRule()
	{
		return mobileCheckRule;
	}

	public void setMobileCheckRule(String mobileCheckRule)
	{
		this.mobileCheckRule = mobileCheckRule;
	}
}
