package com.project.common.dict.apect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : anlu
 * @className : SysPointcut
 * @package: com.project.imgt.test
 * 数据字典注解
 * @date : 2023/7/18 11:15
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableDict {


}
