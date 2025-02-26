package com.project.common.security.annotation;

/**
 * 权限注解的验证模式
 * 
 * @author project
 *
 */
public enum Logical
{
    /**
     * 必须具有所有的元素
     */
    AND,

    /**
     * 只需具有其中一个元素
     */
    OR
}
