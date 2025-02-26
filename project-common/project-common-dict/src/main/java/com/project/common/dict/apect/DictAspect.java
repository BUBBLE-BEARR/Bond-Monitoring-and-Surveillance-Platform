package com.project.common.dict.apect;

import com.project.common.dict.utils.DictUtils;
import com.project.system.api.domain.SysDictData;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author:zjm
 * @Date:2023/4/149:53
 * @Description: 配置切面，为各个查询方法调用时
 */
@Aspect
@Component
public class DictAspect {

    private static final Logger log = LoggerFactory.getLogger(DictAspect.class);

    @AfterReturning(pointcut = "@annotation(EnableDict)", returning = "result")
    public void doAfterReturning(JoinPoint pjp, Object result) {
        try {
            this.convert(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void convert(Object target) {
        try {
            if (target instanceof List) {
                List<?> objectList = ((List<?>) target);
                if (CollectionUtils.isNotEmpty(objectList)) {
                    List<DictDefinition> dictDefinitions = getMetadata(objectList.get(0));
                    if (CollectionUtils.isEmpty(dictDefinitions)) {
                        return;
                    }
                    List<String> dictNames = dictDefinitions.stream().map(d -> d.getDict().dictName()).collect(Collectors.toList());
                    Map<String, Map<String, String>> dictMapMap = getDictMap(dictNames);
                    objectList.forEach(t -> doConvertDict(t, dictDefinitions, dictMapMap));
                }
            } else {
                List<DictDefinition> dictDefinitions = getMetadata(target);
                if (CollectionUtils.isEmpty(dictDefinitions)) {
                    return;
                }
                List<String> dictNames = dictDefinitions.stream().map(d -> d.getDict().dictName()).collect(Collectors.toList());
                Map<String, Map<String, String>> dictMapMap = getDictMap(dictNames);
                doConvertDict(target, dictDefinitions, dictMapMap);
            }
        } catch (Exception e) {
            log.error("数据字典转换失败：", e);
        }
    }

    /**
     * 仅获取一次Dict元数据，降低多次反射造成的性能消耗
     *
     * @param target 目标实体类
     * @return Dict元数据
     */
    private List<DictDefinition> getMetadata(Object target) {
        List<DictDefinition> dictDefinitions = new ArrayList<>();
        try {
            if (ClassUtils.isPrimitiveOrWrapper(target.getClass()) || target instanceof Map || target instanceof String) {
                return dictDefinitions;
            }
            List<Field> fields = FieldUtils.getAllFieldsList(target.getClass());
            for (Field field : fields) {
                Dict dict = AnnotationUtils.getAnnotation(field, Dict.class);
                if (dict != null) {
                    DictDefinition dictDefinition = new DictDefinition();
                    dictDefinition.setDict(dict);
                    dictDefinition.setField(field);
                    dictDefinitions.add(dictDefinition);
                }
            }
        } catch (Exception e) {
            log.error("获取属性失败：", e);
        } finally {
            return dictDefinitions;
        }
    }


    private Map<String, Map<String, String>> getDictMap(List<String> dictNames) {
        List<SysDictData> dictList = new ArrayList<SysDictData>();
        for (String type : dictNames) {
            List<SysDictData> list = DictUtils.getDictCache(type);
            if (list != null) {
                dictList.addAll(list);
            }
        }
        return dictList.stream().collect(Collectors.groupingBy(
                SysDictData::getDictType, Collectors.toMap(SysDictData::getDictValue, SysDictData::getDictLabel, (v1, v2) -> v2)));
    }


    private void doConvertDict(Object target, List<DictDefinition> dictDefinitions, Map<String, Map<String, String>> dictMapMap) {
        try {
            for (DictDefinition dictDefinition : dictDefinitions) {
                Dict dict = dictDefinition.getDict();
                Field field = dictDefinition.getField();
                Map<String, String> dictMap = dictMapMap.get(dict.dictName());
                String dictCode = String.valueOf(FieldUtils.readField(target, field.getName(), true));
                String dictField = field.getName();
                FieldUtils.writeField(target, dictField, dictMap.get(dictCode), true);
            }
        } catch (Exception e) {
            log.error("根据字段名写入字典值失败：", e);
        }
    }

}
