package com.project.common.swagger.domain;

import com.project.common.core.constant.HttpStatus;
import com.project.common.core.utils.StringUtils;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 	操作消息提醒
 * 
 * @author yangyc
 */
@Schema(description = "操作消息封装对象")
public class AjaxResultTo<T> extends BaseResult {
	private static final long serialVersionUID = 1L;

	/**	数据对象 */
	@Schema(description = "数据对象")
    public T data = null;
	
    /**
     * - 初始化一个新创建的 AjaxResultTo 对象，使其表示一个空消息。
     */
    public AjaxResultTo()
    {
    	super();
    }

    /**
     * - 初始化一个新创建的 AjaxResultTo 对象
     * 
     * @param code 状态码
     * @param msg 返回内容
     */
    public AjaxResultTo(int code, String msg)
    {
        super(code, msg);
    }

    /**
     * - 初始化一个新创建的 AjaxResultTo 对象
     * 
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public AjaxResultTo(int code, String msg, T data)
    {
    	super(code, msg);
        if (StringUtils.isNotNull(data))
        {
            this.data = data;
        }
    }
    
    /**
     * 	返回成功消息
     * 
     * @return 成功消息
     */
    public AjaxResultTo<T> success()
    {
        return this.success("操作成功");
    }

    /**
     * 	返回成功数据
     * 
     * @return 成功消息
     */
    public AjaxResultTo<T> success(T data)
    {
        return this.success("操作成功", data);
    }

    /**
     * 	返回成功消息
     * 
     * @param msg 返回内容
     * @return 成功消息
     */
    public AjaxResultTo<T> success(String msg)
    {
        return this.success(msg, null);
    }

    /**
     * 	返回成功消息
     * 
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public AjaxResultTo<T> success(String msg, T data)
    {
        return new AjaxResultTo<T>(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 	返回错误消息
     * 
     * @return
     */
    public AjaxResultTo<T> error()
    {
        return this.error("操作失败");
    }

    /**
     * 	返回错误消息
     * 
     * @param msg 返回内容
     * @return 警告消息
     */
    public AjaxResultTo<T> error(String msg)
    {
        return this.error(msg, null);
    }

    /**
     * 	返回错误消息
     * 
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public AjaxResultTo<T> error(String msg, T data)
    {
        return new AjaxResultTo<T>(HttpStatus.ERROR, msg, data);
    }

    /**
     * 	返回错误消息
     * 
     * @param code 状态码
     * @param msg 返回内容
     * @return 警告消息
     */
    public AjaxResultTo<T> error(int code, String msg)
    {
        return new AjaxResultTo<T>(code, msg, null);
    }
}
