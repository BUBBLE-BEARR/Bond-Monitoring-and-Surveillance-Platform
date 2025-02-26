package com.project.common.swagger.domain;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * Result基类
 * 
 * @author yangyc
 */
@Schema
public class BaseResult implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**	状态码 */
    @Schema(description = "状态码")
    private int code;

    /**	返回内容 */
    @Schema(description = "返回内容")
    private String msg;

	public BaseResult() {
		super();
	}

	public BaseResult(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
