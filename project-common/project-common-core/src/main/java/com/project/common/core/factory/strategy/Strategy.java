package com.project.common.core.factory.strategy;
/**
 * 	策略类的接口抽象
 * @author yangyanchao
 *
 * @param <T>  返回类型   最终转化的类型
 * @param <V>  参数类型   初始类型
 */
@FunctionalInterface
public interface Strategy<T, V> {
	T apply(V target);
}
