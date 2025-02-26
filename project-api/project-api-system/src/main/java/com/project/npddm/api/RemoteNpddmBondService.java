package com.project.npddm.api;

import java.util.List;

import com.project.common.core.constant.SecurityConstants;
import com.project.common.core.constant.ServiceNameConstants;
import com.project.common.core.domain.R;
import com.project.common.core.web.page.TableDataInfo;
import com.project.npddm.api.domain.TBondBasicInfo;
import com.project.npddm.api.domain.TComInfo;
import com.project.npddm.api.factory.RemoteNpddmBondFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;





/**
 * bond服务
 *
 * @author project
 */
@FeignClient(contextId = "remoteNpddmBondService", value = ServiceNameConstants.NPDDM_SERVICE, fallbackFactory = RemoteNpddmBondFallbackFactory.class)
public interface RemoteNpddmBondService
{
    /**
     * 根据code获取信息
     * @param comUniCode
     * @param source
     * @return
     */
    @GetMapping("/bond/tcomInfo/selectTComInfo")
    public R<TComInfo> selectTComInfo(
                                    @RequestParam(name = "comUniCode") String comUniCode,
                                    @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 根据name获取信息
     * @param comChiName
     * @param source
     * @return
     */
    @GetMapping("/bond/tcomInfo/selectTComInfoByName")
    public R<TComInfo> selectTComInfoByName(
                                    @RequestParam(name = "comChiName") String comChiName,
                                    @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 查询债券发行人信息列表
     * @return
     */
    @GetMapping("/bond/tcomInfo/queryTComInfoListByChiName")
    public R<TableDataInfo> queryTComInfoListByChiName(
            @RequestParam(name = "pageNum") Integer pageNum,
            @RequestParam(name = "pageSize") Integer pageSize,
            @RequestParam(name = "comChiName") String comChiName,
            @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );

    /**
     * 根据简称查询债券
     * @param bondShortName
     * @param source
     * @return
     */
    @GetMapping("/bond/tBondBasicInfo/selectBondBasicInfosByShortName")
    public R<List<TBondBasicInfo>> selectBondBasicInfosByShortName(
                                    @RequestParam(name = "bondShortName") String bondShortName,
                                    @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 查询债券信息列表
     * @return
     */
    @GetMapping("/bond/tBondBasicInfo/queryBondBasicInfosListByBondShortName")
    public R<List<TBondBasicInfo>> queryBondBasicInfosListByBondShortName(
            @RequestParam(name = "pageNum") Integer pageNum,
            @RequestParam(name = "pageSize") Integer pageSize,
            @RequestParam(name = "bondShortName") String bondShortName,
            @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );
}
