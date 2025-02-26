package com.project.system.api;

import com.project.common.core.constant.SecurityConstants;
import com.project.common.core.constant.ServiceNameConstants;
import com.project.common.core.domain.R;
import com.project.system.api.domain.SysDictData;
import com.project.system.api.factory.RemoteDictFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 文件服务
 *
 * @author project
 */
@FeignClient(contextId = "remoteDictService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteDictFallbackFactory.class)
public interface RemoteDictService
{
    /**
     * 通过字典dictType获取字典表信息
     */
    @GetMapping("/dict/data/npType/{dictType}")
    public R<List<SysDictData>> npType(@PathVariable("dictType") String dictType, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 字典联动接口
     * @param dictType
     * @param remark
     * @param source
     * @return
     */
    @GetMapping("/dict/data/dictLinkage")
    R<List<SysDictData>> selectDictLinkageList(@RequestParam(value = "dictType")String dictType,
                                               @RequestParam(value = "remark") String remark,
                                               @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
