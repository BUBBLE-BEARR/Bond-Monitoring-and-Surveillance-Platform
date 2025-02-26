package com.project.system.api;

import com.project.common.core.constant.SecurityConstants;
import com.project.common.core.constant.ServiceNameConstants;
import com.project.common.core.domain.R;
import com.project.common.core.web.domain.AjaxResult;
import com.project.common.core.web.page.TableDataInfo;
import com.project.system.api.factory.RemoteReitsFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Reits服务
 *
 * @author yangyunlong
 */
@FeignClient(contextId = "remoteReitsService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteReitsFallbackFactory.class)
public interface RemoteReitsService {

    /**
     * 获取知识库信息
     *
     * @param pageNum
     * @param pageSize
     * @param label
     * @return
     */
    @GetMapping("/knowledge/getKnowledge")
    public R<TableDataInfo> getKnowledge(@RequestParam(name = "pageNum") Integer pageNum,
                                         @RequestParam(name = "pageSize") Integer pageSize,
                                         @RequestParam(name = "label") String label,
                                         @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 获取单个知识库信息
     * @param id
     * @return
     */
    @GetMapping("/knowledge/getKnowledgeInfo")
    public R<AjaxResult> getKnowledgeInfo(@RequestParam(name = "id") Long id);

    /**
     * 添加政策法规信息
     * @param fileUrl
     * @return
     */
    @PostMapping("/policy/addPolicyUrl")
    public R<AjaxResult> addPolicyUrl(@RequestParam("fileUrl") String fileUrl);

    /**
     * 获取单个政策法规信息
     * @param id
     * @return
     */
    @GetMapping("/policy/getPolicyById")
    public R<AjaxResult> getPolicyById(@RequestParam(name = "id") Long id);
    /**
     * 获取法规信息列表
     * @param
     * @return
     */
    @GetMapping("/policy/getPolicy")
    public R<TableDataInfo> getPolicy(@RequestParam(name = "pageNum") Integer pageNum,
                                   @RequestParam(name = "pageSize") Integer pageSize,
                                   @RequestParam(name = "label") String label,
                                   @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
