package com.project.common.dict.apect;

import java.lang.annotation.*;

/**
 * @author : anlu
 * @className : SysPointcut
 * @package: com.project.imgt.test
 * 数据字典注解
 * @date : 2023/7/18 11:15
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Dict {

    /**
     * 字典编码
     */
    String dictName();

}
