package com.project.common.datasource.annotation;

import com.baomidou.dynamic.datasource.annotation.DS;

import java.lang.annotation.*;

/**
 * @author : anlu
 * @className : SlaveSecond
 * @package: com.project.common.datasource.annotation
 * @date : 2023/6/16 15:15
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DS("slavereply")
public @interface SlaveReply {
}
