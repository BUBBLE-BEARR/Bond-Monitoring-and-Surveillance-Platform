package com.project.common.core.constant;

/**
 * 缓存的key 常量
 * 
 * @author project
 */
public class CacheConstants
{
    /**
     * 缓存有效期，默认720（分钟）
     */
    public final static long EXPIRATION = 30;//720;

    /**
     * 缓存刷新时间，默认120（分钟）
     */
    public final static long REFRESH_TIME = 120;

    /**
     * 权限缓存前缀
     */
    public final static String LOGIN_TOKEN_KEY = Constants.ALL_CODE_KEY + "login_tokens:";
}
