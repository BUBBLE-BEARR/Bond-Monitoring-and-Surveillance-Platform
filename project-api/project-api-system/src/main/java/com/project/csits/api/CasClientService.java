package com.project.csits.api;


import com.project.common.core.constant.ServiceNameConstants;
import com.project.common.core.domain.R;
import com.project.csits.api.domain.AllUserInfoResult;
import com.project.csits.api.domain.CsitsJm;
import com.project.csits.api.domain.OrgUnitResult;
import com.project.csits.api.factory.RemoteCasFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;
import java.util.List;

@FeignClient(contextId = "casClientService", url = "EMPTY",value = ServiceNameConstants.SYSTEM_SERVICE,fallbackFactory = RemoteCasFallbackFactory.class)
public interface CasClientService {




  /**
   * 请求根据用户账号获取用户ID的接口
   */
  @RequestMapping(value = "urms-api/api/v4/account/accountNbr?accountNbr={acctNbr}&sysCode={sysCode}", method = RequestMethod.GET)
  public R<?> getUserIdByAcctNbr(URI host, @PathVariable("acctNbr") String acctNbr, @PathVariable("sysCode") String sysCode);

  /**
   * 请求根据系统Code测试SM4解密
   */
  @RequestMapping(value = "urms-api/api/v4/demo/getDecryptSM4Msg", method = RequestMethod.POST)
  public R<?> getDecryptSM4Msg(URI host, @RequestBody CsitsJm CsitsJm);
  /**
   * 请求获取用户信息的接口
   */
  @RequestMapping(value = "urms-api/api/v4/userInfo/getUserInfoByUserId?sysCode={sysCode}&userId={userId}", method = RequestMethod.GET)
  public R<?> getUserInfo(URI host, @PathVariable("sysCode") String sysCode, @PathVariable("userId") String userId);

  /**
   * 请求根据用户Id获取所有角色信息（包含角色组）
   */
  @RequestMapping(value = "urms-api/api/v1/role/roleAllByUserId?sysCode={sysCode}&userId={userId}&isybcxjsz={isybcxjsz}&orgId={orgId}", method = RequestMethod.GET)
  public R<?> roleAllByUserId(URI host, @PathVariable("sysCode") String sysCode, @PathVariable("userId") String userId, @PathVariable("isybcxjsz") Boolean isybcxjsz, @PathVariable("orgId") String orgId);
  /**
   * 请求用户Id获取用户的所属主组织
   */
  @RequestMapping(value = "urms-api/api/v4/userInfo/getMasterOrgIdByUserId?sysCode={sysCode}&userId={userId}", method = RequestMethod.GET)
  public R<?> getMasterOrgIdByUserId(URI host, @PathVariable("sysCode") String sysCode, @PathVariable("userId") String userId);

  /**
   * 请求全量获取组织信息
   */
  @RequestMapping(value = "urms-api/api/v1/orgUnit/getAllOrgUnitsInfo?acctNbr={acctNbr}&userId={userId}", method = RequestMethod.GET)
  public  R<List<OrgUnitResult>> orgUnit(URI host, @PathVariable("acctNbr") String acctNbr, @PathVariable("userId") String userId);

  /**
   * 请求全量获取用户的组织和职务信息
   */
  @RequestMapping(value = "urms-api/api/v1/userInfo/getAllUserOrgUnitPosiInfo?acctNbr={acctNbr}&userId={userId}&sysCode={sysCode}", method = RequestMethod.GET)
  public R<List<AllUserInfoResult>> allUserOrgUnitPosiInfo(URI host, @PathVariable("acctNbr") String acctNbr, @PathVariable("userId") String userId, @PathVariable("sysCode") String sysCode);
}
