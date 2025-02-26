package com.project.common.core.utils.poi.generator;

import com.project.common.core.domain.exportdata.DataModel;
import com.project.common.core.domain.exportdata.TemplateDataRegion;
import com.project.common.core.utils.poi.ExprotFromTemplateUtil;
import com.project.common.core.utils.poi.ExprotFromTemplateUtilByMultiThreadAndBatch;
import com.project.common.core.utils.poi.ExprotFromTemplateUtilByMultiThreadAndNoBatch;
import com.project.common.core.utils.poi.abstractpg.AbstractExportExcelUtil;
import com.project.common.core.web.domain.AjaxResult;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.ToLongFunction;

/**
 * 	builder 类负责创建 AbstractExportExcelUtil 对象
 * 	
 * @author User
 *
 */
public class ExprotFromTemplateUtilBuilder<P, H, D, T> {
	
	/**
     * 	Excel 模板文件绝对路径
     */
	private String templatePath;
	
	/**
	 * 	起始行
	 */
	private Integer startRow = 0;
	/**
	 * 	结束行
	 */
	private Integer endRow;
	/**
	 * 	起始列
	 */
	private Integer startColumn = 0;
	/**
	 * 	结束列
	 */
	private Integer endColumn;
	
	/**
     * 	导出数据模型
     */
	private DataModel<P, H, D, T> dataModel;
	
	public ExprotFromTemplateUtilBuilder() {
		super();
	}

	public ExprotFromTemplateUtilBuilder(String templatePath, Integer startRow, Integer endRow, Integer startColumn,
			Integer endColumn, DataModel<P, H, D, T> dataModel) {
		super();
		this.templatePath = templatePath;
		this.startRow = startRow;
		this.endRow = endRow;
		this.startColumn = startColumn;
		this.endColumn = endColumn;
		this.dataModel = dataModel;
	}

	/**
	 * 	单线程处理并且不分批次导出
	 * @return
	 */
	public AjaxResult generatorBySingleThreadAndNoBatch() {
		AbstractExportExcelUtil<P, H, D, T> etu = new ExprotFromTemplateUtil<>();
		TemplateDataRegion tdr = new TemplateDataRegion(startRow, endRow, startColumn, endColumn);
		return etu.exportExcel(templatePath, tdr, dataModel);
	}
	
	/**
	 * 	多单线程处理并且不分批次导出
	 * @return
	 */
	public AjaxResult generatorByMultiThreadAndNoBatch() {
		AbstractExportExcelUtil<P, H, D, T> etu = new ExprotFromTemplateUtilByMultiThreadAndNoBatch<>();
		TemplateDataRegion tdr = new TemplateDataRegion(startRow, endRow, startColumn, endColumn);
		return etu.exportExcel(templatePath, tdr, dataModel);
	}
	
	/**
	 * 	多线程处理并且分批次导出
	 * @return
	 */
	public <M> AjaxResult generatorByMultiThreadAndBatch(M mapper, ToLongFunction<M> getTototalFunc,
			BiFunction<M, Integer, List<D>> getDataListFunc) {
		AbstractExportExcelUtil<P, H, D, T> etu = new ExprotFromTemplateUtilByMultiThreadAndBatch<P, H, D, T, M>(mapper, getTototalFunc, getDataListFunc);
		TemplateDataRegion tdr = new TemplateDataRegion(startRow, endRow, startColumn, endColumn);
		return etu.exportExcel(templatePath, tdr, dataModel);
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}

	public Integer getStartColumn() {
		return startColumn;
	}

	public void setStartColumn(Integer startColumn) {
		this.startColumn = startColumn;
	}

	public Integer getEndColumn() {
		return endColumn;
	}

	public void setEndColumn(Integer endColumn) {
		this.endColumn = endColumn;
	}

	public DataModel<P, H, D, T> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<P, H, D, T> dataModel) {
		this.dataModel = dataModel;
	}
}
