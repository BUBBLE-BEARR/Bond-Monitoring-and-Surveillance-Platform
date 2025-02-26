package com.project.common.core.factory.strategy.exportdata;

import com.project.common.core.domain.exportdata.ExportConfig;
import com.project.common.core.factory.strategy.Strategy;

/**
 * 	模式匹配-通用模式
 * @author User
 *
 */
public class CurrencyStrategy implements Strategy<Void, ExportConfig>{

	/**
	 *	执行该策略的具体实施
	 */
	@Override
	public Void apply(ExportConfig target) {
		// 什么也不用做就行
		return null;
	}

}
