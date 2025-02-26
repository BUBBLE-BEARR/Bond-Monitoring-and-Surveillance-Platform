package com.project.common.security.utils;

import com.project.common.core.constant.HttpStatus;
import com.project.common.core.exception.CustomException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityCasUtils {

    /**
     * 获取用户
     **/
    public static Object getLoginUser()
    {
        try
        {
            return  getAuthentication().getPrincipal();
        }
        catch (Exception e)
        {
            throw new CustomException("获取用户信息异常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    /**
     * 获取用户
     */
    /*public static String getUsername()
    {
        String username = ServletUtils.getRequest().getHeader(CacheConstants.DETAILS_USERNAME);
        return ServletUtils.urlDecode(username);
    }

    *//**
     * 获取用户ID
     *//*
    public static Long getUserId()
    {
        return Convert.toLong(ServletUtils.getRequest().getHeader(CacheConstants.DETAILS_USER_ID));
    }
*/

}
