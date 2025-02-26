package com.project.system.api.factory;

import com.project.common.core.domain.R;
import com.project.system.api.RemoteDictService;
import com.project.system.api.domain.SysDictData;
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
public class RemoteDictFallbackFactory implements FallbackFactory<RemoteDictService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteDictFallbackFactory.class);

    @Override
    public RemoteDictService create(Throwable throwable)
    {
        log.error("系统服务调用失败:{}", throwable.getMessage());
        return new RemoteDictService()
        {
            @Override
            public R<List<SysDictData>> npType(String dictType, String source)
            {
                return R.fail("获取字典信息失败:"+throwable.getMessage());
            }

            /**
             * 字典联动接口
             *
             * @param dictType
             * @param remark
             * @param source
             * @return
             */
            @Override
            public R<List<SysDictData>> selectDictLinkageList(String dictType, String remark, String source) {
                return R.fail("获取字典信息失败:"+throwable.getMessage());
            }
        };
    }
}
