package com.project.system.api.factory;

import com.project.common.core.domain.R;
import com.project.common.core.web.page.TableDataInfo;
import com.project.system.api.RemoteBondService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 系统服务降级处理
 *
 * @author project
 */
@Component
public class RemoteBondFallbackFactory implements FallbackFactory<RemoteBondService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteBondFallbackFactory.class);

    @Override
    public RemoteBondService create(Throwable throwable)
    {
        log.error("系统服务调用失败:{}", throwable.getMessage());
        return new RemoteBondService()
        {
            @Override
            public R<List<Map<String, Object>>> echartsWeekList(Integer pageNum, Integer pageSize, String source) {
                return R.fail("获取非公债备案数量及规模趋势列表失败:"+throwable.getMessage());
            }

            @Override
            public R<List<Map<String, Object>>> echartsMonthList(Integer pageNum, Integer pageSize, String source) {
                return R.fail("获取非公债备案数量及规模趋势列表失败:"+throwable.getMessage());
            }

            @Override
            public R<TableDataInfo> queryBondCancellationofissueList(Integer pageNum, Integer pageSize,
                                                                     String mixedName,
                                                                     int jurisdictionIds,
                                                                     String source) {
                return R.fail("获取取消发行或推迟发行列表失败:"+throwable.getMessage());
            }

            @Override
            public R<TableDataInfo> queryBondSubjectDowngradeList(Integer pageNum, Integer pageSize,
                                                                  String comUniName,
                                                                  int jurisdictionIds,
                                                                  String source) {
                return R.fail("获取主体评级下调及展望负面列表失败:"+throwable.getMessage());
            }

            @Override
            public R<TableDataInfo> queryBondNegativePublicOpinionList(Integer pageNum, Integer pageSize,
                                                                       String issName,
                                                                       int jurisdictionIds,
                                                                       String source) {
                return R.fail("获取负面舆情列表失败:"+throwable.getMessage());
            }

            @Override
            public R<TableDataInfo> queryBondLeadUnderwriterRankingList(Integer pageNum, Integer pageSize,
                                                                        String orderByColumn, String isAsc,
                                                                        String leadUnderwriterName,
                                                                        String source) {
                return R.fail("获取非公债主承销商承销排名列表失败:"+throwable.getMessage());
            }

            @Override
            public R<TableDataInfo> queryBondFilingIssuerList(Integer pageNum, Integer pageSize,
                                                              String issName,
                                                              int jurisdictionIds,
                                                              String source) {
                return R.fail("获取非公债首次备案发行人列表失败:"+throwable.getMessage());
            }

            @Override
            public R<TableDataInfo> queryTZzbjComInfoList(Integer pageNum, Integer pageSize, int jurisdictionIds,String source) {
                return R.fail("获取舆情的中证报价近一周关注主体列表失败:"+throwable.getMessage());
            }

            @Override
            public R<TableDataInfo> queryReportBondInfoList(Integer pageNum, Integer pageSize,
                                                            String issueScale,
                                                            String bondMatu,
                                                            String issRegAddr,
                                                            String issIndustryType,
                                                            String comOrBondName,
                                                            String source) {
                return R.fail("获取查询报备债券信息列表失败:"+throwable.getMessage());
            }

            @Override
            public R<TableDataInfo> queryReportQuantityScaleList(
                                                            String reportPeriodType,
                                                            String source) {
                return R.fail("获取查询报备数量及规模趋势失败:"+throwable.getMessage());
            }

            @Override
            public R<TableDataInfo> queryIssueAreaRatioList(
                    String source) {
                return R.fail("获取查询发行区域占比失败:"+throwable.getMessage());
            }
        };
    }
}
