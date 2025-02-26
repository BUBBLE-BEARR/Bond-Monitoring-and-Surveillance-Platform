package com.project.system.api.factory;

import com.project.common.core.domain.R;
import com.project.system.api.RemoteUserService;
import com.project.system.api.domain.SysUser;
import com.project.system.api.model.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 用户服务降级处理
 * 
 * @author project
 */
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteUserFallbackFactory.class);

    @Override
    public RemoteUserService create(Throwable throwable)
    {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteUserService()
        {
            @Override
            public R<LoginUser> getUserInfo(String username, String source)
            {
                return R.fail("获取用户失败:" + throwable.getMessage());
            }

            @Override
            public R<LoginUser> getNpddmUserInfo(String username, String source) {
                return R.fail("获取用户失败:" + throwable.getMessage());
            }

            @Override
            public R<Integer> changePwd(SysUser user, String source) {
                return R.fail("修改密码失败:" + throwable.getMessage());
            }

            @Override
            public R<Boolean> registerUserInfo(SysUser sysUser, String source)
            {
                return R.fail("注册用户失败:" + throwable.getMessage());
            }

            @Override
            public R<?> getRouters(Long userId, String source) {
                return R.fail("获取路由信息失败:" + throwable.getMessage());
            }

            @Override
            public R<LoginUser> getUserInfocas(String username)
            {
                return R.fail("获取用户失败:" + throwable.getMessage());
            }
        };
    }
}
