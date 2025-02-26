package com.project.csits.api.factory;


import com.project.common.core.domain.R;
import com.project.csits.api.CasClientService;
import com.project.csits.api.domain.AllUserInfoResult;
import com.project.csits.api.domain.OrgUnitResult;
import com.project.csits.api.domain.CsitsJm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

/**
 * 中证信息cas接口处理
 *
 * @author project
 */
@Component
public class RemoteCasFallbackFactory implements FallbackFactory<CasClientService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteCasFallbackFactory.class);

    @Override
    public CasClientService create(Throwable throwable)
    {
         log.error("cas服务调用失败:{}", throwable.getMessage());
         return  new CasClientService(){



           @Override
           public R<?> getUserIdByAcctNbr(URI host, String acctNbr, String sysCode) {
             return R.fail("获取根据用户账号获取用户ID信息:" + throwable.getMessage());
           }

           @Override
           public R<?> getDecryptSM4Msg(URI host, CsitsJm CsitsJm) {
             return R.fail("获取解密信息:" + throwable.getMessage());
           }


           @Override
           public R<?> getUserInfo(URI host, String acctNbr, String userId) {
             return R.fail("获取用户信息失败:" + throwable.getMessage());
           }

           @Override
           public R<?> roleAllByUserId(URI host, String sysCode, String userId, Boolean isybcxjsz, String orgId) {
             return R.fail("获取根据用户Id获取所有角色信息（包含角色组）信息:" + throwable.getMessage());
           }


           @Override
           public R<?> getMasterOrgIdByUserId(URI host, String sysCode, String userId) {
             return R.fail("获取用户Id获取用户的所属主组织失败:" + throwable.getMessage());
           }

           @Override
           public  R<List<OrgUnitResult>> orgUnit(URI host, String acctNbr, String userId){
             return R.fail("获取全量获取组织信息失败:" + throwable.getMessage());
           }

           @Override
           public R<List<AllUserInfoResult>> allUserOrgUnitPosiInfo(URI host, String acctNbr, String userId, String sysCode){
             return R.fail("获取全量获取用户的组织和职务信息失败:" + throwable.getMessage());
           }

         };

    }
}
