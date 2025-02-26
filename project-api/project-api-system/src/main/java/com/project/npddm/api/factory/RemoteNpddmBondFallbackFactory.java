package com.project.npddm.api.factory;

import com.project.common.core.domain.R;
import com.project.common.core.web.page.TableDataInfo;
import com.project.npddm.api.RemoteNpddmBondService;
import com.project.npddm.api.domain.TBondBasicInfo;
import com.project.npddm.api.domain.TComInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统服务降级处理
 *
 * @author project
 */
@Component
public class RemoteNpddmBondFallbackFactory implements FallbackFactory<RemoteNpddmBondService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteNpddmBondFallbackFactory.class);

    @Override
    public RemoteNpddmBondService create(Throwable throwable)
    {
        log.error("系统服务调用失败:{}", throwable.getMessage());
        return new RemoteNpddmBondService()
        {
            @Override
            public R<TComInfo> selectTComInfo(String comUniCode, String source) {
                return R.fail("根据code获取债券发行人信息失败:"+throwable.getMessage());
            }

            @Override
            public R<TableDataInfo> queryTComInfoListByChiName(Integer pageNum, Integer pageSize, String comChiName, String source) {
                return R.fail("查询债券发行人信息列表失败:"+throwable.getMessage());
            }

            @Override
            public R<TComInfo> selectTComInfoByName(String comChiName, String source) {
                return R.fail("根据name获取债券发行人信息失败:"+throwable.getMessage());
            }

            @Override
            public R<List<TBondBasicInfo>> selectBondBasicInfosByShortName(String bondShortName, String source) {
                return R.fail("根据shortName获取债券信息失败:"+throwable.getMessage());
            }

            @Override
            public R<List<TBondBasicInfo>> queryBondBasicInfosListByBondShortName(Integer pageNum, Integer pageSize, String bondShortName, String source) {
                return R.fail("根据简称获取债券信息列表失败:"+throwable.getMessage());
            }
        };
    }
}
