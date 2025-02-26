package com.project.common.core.factory;

import com.project.common.core.factory.strategy.StrategyForList;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 	工厂模式 - 应用于类型转化 抽象为操作
 * 	主要这个模式能够减少if-else 增加代码可读性
 * 	目前操作有 ：
 * 		Excel导出模式匹配的
 * 				
 * @author yangyanchao
 *
 */
public class StrategyForListFactory {

    private static final StrategyForListFactory INSTANCE = new StrategyForListFactory();

    private StrategyForListFactory() {};

    /**
     * 	单例实例
     * @return
     */
    public static StrategyForListFactory getInstance() {
        return INSTANCE;
    }

    /**
	 * 	存放 返回值为list 入参值为Integer的策略Map
	 */
	private static Map<String, StrategyForList<?, ?>> strategyForListMap = new HashMap<>();
	
	/**
     * 	通过Key值获取操作类
     * @param key
     * @return
     */
	public static Optional<StrategyForList<?, ?>> getStrategyForListMapByKey(String key) {
    	// operation 非空时返回
        return Optional.ofNullable(strategyForListMap.get(key));
    }
	
	@SuppressWarnings("static-access")
	public static StrategyForListFactory addStrategyForListMap(String key, StrategyForList<?, ?> strategyForList) {
		getInstance().strategyForListMap.put(key, strategyForList);
    	return getInstance();
    }
}
