package com.project.common.core.factory.strategy.exportdata;

import com.project.common.core.domain.exportdata.ExportConfig;
import com.project.common.core.enums.ExportConfigType;
import com.project.common.core.factory.strategy.Strategy;

/**
 * 	模式匹配-序号模式
 * @author User
 *
 */
public class RowNumberStrategy implements Strategy<Void, ExportConfig>{

	/**
	 *	执行该策略的具体实施
	 */
	@Override
	public Void apply(ExportConfig target) {
		target.setCellType(ExportConfig.ColumnType.NUMERIC.value());
		target.setRowNumber(ExportConfig.RowNumber.ENABLE);
		target.setExportConfigType(ExportConfigType.DATA);
		return null;
	}

}
