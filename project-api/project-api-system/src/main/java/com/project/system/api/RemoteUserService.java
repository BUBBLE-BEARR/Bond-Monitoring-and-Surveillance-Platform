package com.project.system.api;

import com.project.common.core.constant.SecurityConstants;
import com.project.common.core.constant.ServiceNameConstants;
import com.project.common.core.domain.R;
import com.project.system.api.domain.SysUser;
import com.project.system.api.factory.RemoteUserFallbackFactory;
import com.project.system.api.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 用户服务
 * 
 * @author project
 */
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService
{
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param source 请求来源
     * @return 结果
     */
    @GetMapping("/user/info/{username}")
    public R<LoginUser> getUserInfo(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);


    /**
     * 通过用户名查询非公债用户信息
     *
     * @param username 用户名
     * @param source 请求来源
     * @return 结果
     */
    @GetMapping("/superviseUser/npddmInfo/{username}")
    public R<LoginUser> getNpddmUserInfo(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);


    @GetMapping("/superviseUser/getRouters/{userId}")
    public R<?> getRouters(@PathVariable("userId") Long userId, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);


    /**
     *  监管用户修改密码
     * @return
     */
    @PostMapping("/superviseUser/changePwd")
    public R<Integer> changePwd(@RequestBody SysUser user, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 注册用户信息
     *
     * @param sysUser 用户信息
     * @param source 请求来源
     * @return 结果
     */
    @PostMapping("/user/register")
    public R<Boolean> registerUserInfo(@RequestBody SysUser sysUser, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping(value = "/user/info/cas/{username}")
    public R<LoginUser> getUserInfocas(@PathVariable("username") String username);
}
