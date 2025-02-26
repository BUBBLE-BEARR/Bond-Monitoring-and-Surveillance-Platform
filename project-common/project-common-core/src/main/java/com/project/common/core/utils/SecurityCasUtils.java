package com.project.common.core.utils;

import com.project.common.core.constant.CacheConstants;
import com.project.common.core.constant.HttpStatus;
import com.project.common.core.exception.CustomException;
import com.project.common.core.text.Convert;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
