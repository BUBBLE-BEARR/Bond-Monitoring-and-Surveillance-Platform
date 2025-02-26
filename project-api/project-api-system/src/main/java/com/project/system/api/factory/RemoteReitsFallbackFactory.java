package com.project.system.api.factory;

import com.project.common.core.domain.R;
import com.project.common.core.web.domain.AjaxResult;
import com.project.common.core.web.page.TableDataInfo;
import com.project.system.api.RemoteReitsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Reits服务降级处理
 *
 * @author yangyunlong
 * @version 1.0
 * @date 2023/6/27 10:02
 */
@Component
public class RemoteReitsFallbackFactory implements FallbackFactory<RemoteReitsService> {

    private static final Logger log = LoggerFactory.getLogger(RemoteReitsFallbackFactory.class);

    @Override
    public RemoteReitsService create(Throwable throwable)
    {
        log.error("Reits-主页面-知识库服务调用失败:{}", throwable.getMessage());
        return new RemoteReitsService()
        {
            @Override
            public R<TableDataInfo> getKnowledge(Integer pageNum, Integer pageSize, String label, String source) {
                return null;
            }
            @Override
            public R<TableDataInfo> getPolicy(Integer pageNum, Integer pageSize, String label, String source) {
                return null;
            }
            @Override
            public R<AjaxResult> getKnowledgeInfo(Long id) {
                return null;
            }

            /**
             * 添加政策法规信息
             *
             * @param fileUrl
             * @return
             */
            @Override
            public R<AjaxResult> addPolicyUrl(String fileUrl) {
                return null;
            }

            /**
             * 获取单个政策法规信息
             *
             * @param id
             * @return
             */
            @Override
            public R<AjaxResult> getPolicyById(Long id) {
                return null;
            }
        };
    }
}
