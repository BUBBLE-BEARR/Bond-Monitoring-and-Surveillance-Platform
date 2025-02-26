package com.project.common.core.factory;

import com.project.common.core.domain.exportdata.ExportConfig;
import com.project.common.core.enums.ExportModelType;
import com.project.common.core.factory.strategy.Strategy;
import com.project.common.core.factory.strategy.exportdata.*;

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
public class StrategyFactory {
	
	private static final StrategyFactory INSTANCE = new StrategyFactory();

    private StrategyFactory() {};

    /**
     * 	单例实例
     * @return
     */
    public static StrategyFactory getInstance() {
        return INSTANCE;
    }
    
	
	/**
	 * 	存放导出相关对应的操作类 
	 */
	private static Map<String, Strategy<Void, ExportConfig>> strategyMapForExport = new HashMap<>();
	static {
		strategyMapForExport.put(ExportModelType.CURRENCY.getValue(), new CurrencyStrategy());
		strategyMapForExport.put(ExportModelType.ROWNUMBER.getValue(), new RowNumberStrategy());
		strategyMapForExport.put(ExportModelType.AMOUNT.getValue(), new AmountStrategy());
		strategyMapForExport.put(ExportModelType.PERCENTAGE.getValue(), new PercentageStrategy());
		strategyMapForExport.put(ExportModelType.DATE.getValue(), new DateStrategy());
	}
	
	/**
     * 	通过导出相关的操作指令获取操作类
     * @param strategy
     * @return
     */
	public static Optional<Strategy<Void, ExportConfig>> getStrategyForExport(String strategy) {
    	// operation 非空时返回
        return Optional.ofNullable(strategyMapForExport.get(strategy));
    }
	
    /**
     * 	添加导出相关的操作指令
     * @param key
     * @param strategy
     * @return
     */
    @SuppressWarnings("static-access")
	public static StrategyFactory addStrategyMapForExport(String key, Strategy<Void, ExportConfig> strategy) {
    	getInstance().strategyMapForExport.put(key, strategy);
    	return getInstance();
    }
}
