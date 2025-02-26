package com.project.common.core.factory.strategy.exportdata;

import com.project.common.core.domain.exportdata.ExportConfig;
import com.project.common.core.factory.strategy.Strategy;

/**
 * 	模式匹配-日期模式
 * @author User
 *
 */
public class DateStrategy implements Strategy<Void, ExportConfig>{

	/**
	 *	执行该策略的具体实施
	 */
	@Override
	public Void apply(ExportConfig target) {
		target.setCellType(ExportConfig.ColumnType.STRING.value());
		target.setDateFormat("yyyy-MM-dd");
		return null;
	}

}
