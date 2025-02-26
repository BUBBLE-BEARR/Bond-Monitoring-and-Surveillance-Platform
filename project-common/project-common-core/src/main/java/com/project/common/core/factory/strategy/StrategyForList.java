package com.project.common.core.factory.strategy;

import java.util.List;

/**
 * 	策略类的接口抽象
 * @author yangyanchao
 *
 * @param <T>  参数类型1 target
 * @param <R>  返回类型
 */
@FunctionalInterface
public interface StrategyForList<R, T> {
	List<R> apply(T target);
}
