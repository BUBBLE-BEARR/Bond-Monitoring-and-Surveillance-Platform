package com.project.system.api;

import com.project.common.core.constant.SecurityConstants;
import com.project.common.core.constant.ServiceNameConstants;
import com.project.common.core.domain.R;
import com.project.common.core.web.page.TableDataInfo;
import com.project.system.api.factory.RemoteBondFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * bond服务
 *
 * @author project
 */
@FeignClient(contextId = "remoteBondService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteBondFallbackFactory.class)
public interface RemoteBondService
{
    /**
     * 查询非公债备案数量及规模趋势列表-周
     */
    @GetMapping("/bondFiling/echartsWeekList")
    public R<List<Map<String, Object>>> echartsWeekList(@RequestParam(name = "pageNum") Integer pageNum,
                                               @RequestParam(name = "pageSize") Integer pageSize,
                                               @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 查询非公债备案数量及规模趋势列表-月
     */
    @GetMapping("/bondFiling/echartsMonthList")
    public R<List<Map<String, Object>>> echartsMonthList(@RequestParam(name = "pageNum") Integer pageNum,
                                                         @RequestParam(name = "pageSize") Integer pageSize,
                                                         @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 查询取消发行或推迟发行列表
     */
    @GetMapping("/bondCancellationofissue/querylist")
    R<TableDataInfo> queryBondCancellationofissueList(@RequestParam(name = "pageNum") Integer pageNum,
                                                      @RequestParam(name = "pageSize") Integer pageSize,
                                                      @RequestParam(name = "mixedName") String mixedName,
                                                      @RequestParam(name = "jurisdictionIds") int jurisdictionIds,
                                                      @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );

    /**
     * 查询主体评级下调及展望负面列表
     */
    @GetMapping("/subjectDowngrade/querylist")
    R<TableDataInfo> queryBondSubjectDowngradeList(@RequestParam(name = "pageNum") Integer pageNum,
                                                   @RequestParam(name = "pageSize") Integer pageSize,
                                                   @RequestParam(name = "comUniName") String comUniName,
                                                   @RequestParam(name = "jurisdictionIds") int jurisdictionIds,
                                                   @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );

    /**
     * 查询负面舆情列表
     */
    @GetMapping("/bondNegativePublicOpinion/querylist")
    R<TableDataInfo> queryBondNegativePublicOpinionList(@RequestParam(name = "pageNum") Integer pageNum,
                                                        @RequestParam(name = "pageSize") Integer pageSize,
                                                        @RequestParam(name = "issName") String issName,
                                                        @RequestParam(name = "jurisdictionIds") int jurisdictionIds,
                                                        @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );

    /**
     * 查询非公债主承销商承销排名列表
     */
    @GetMapping("/bondLeadUnderwriterRanking/querylist")
    R<TableDataInfo> queryBondLeadUnderwriterRankingList(@RequestParam(name = "pageNum") Integer pageNum,
                                                         @RequestParam(name = "pageSize") Integer pageSize,
                                                         @RequestParam(name = "orderByColumn") String orderByColumn,
                                                         @RequestParam(name = "isAsc") String isAsc,
                                                         @RequestParam(name = "leadUnderwriterName") String leadUnderwriterName,
                                                         @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );

    /**
     * 查询非公债首次备案发行人列表
     */
    @GetMapping("/bondFilingIssuer/querylist")
    R<TableDataInfo> queryBondFilingIssuerList(
            @RequestParam(name = "pageNum") Integer pageNum,
            @RequestParam(name = "pageSize") Integer pageSize,
            @RequestParam(name = "issName") String issName,
            @RequestParam(name = "jurisdictionIds") int jurisdictionIds,
            @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );

    /**
     * 查询非公债首次备案发行人列表
     */
    @GetMapping("/comInfo/querylist")
    R<TableDataInfo> queryTZzbjComInfoList(
            @RequestParam(name = "pageNum") Integer pageNum,
            @RequestParam(name = "pageSize") Integer pageSize,
            @RequestParam(name = "jurisdictionIds")int jurisdictionIds,
            @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );

    /**
     * 查询报备债券信息列表
     */
    @GetMapping("/reportBondInfo/queryList")
    R<TableDataInfo> queryReportBondInfoList(
            @RequestParam(name = "pageNum") Integer pageNum,
            @RequestParam(name = "pageSize") Integer pageSize,
            @RequestParam(name = "issueScale") String issueScale,
            @RequestParam(name = "bondMatu") String bondMatu,
            @RequestParam(name = "issRegAddr") String issRegAddr,
            @RequestParam(name = "issIndustryType") String issIndustryType,
            @RequestParam(name = "comOrBondName") String comOrBondName,
            @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );

    /**
     * 报备数量及规模趋势
     */
    @GetMapping("/reportQuantityScale/queryList")
    R<TableDataInfo> queryReportQuantityScaleList(
            @RequestParam(name = "reportPeriodType") String reportPeriodType,
            @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );

    /**
     * 发行区域占比
     */
    @GetMapping("/issueAreaRatio/queryList")
    R<TableDataInfo> queryIssueAreaRatioList(
            @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );
}
