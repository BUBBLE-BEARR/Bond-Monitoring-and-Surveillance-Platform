package com.project.common.core.domain.exportdata;

import com.project.common.core.enums.ExportConfigType;
import com.project.common.core.utils.poi.abstractpg.AbstractExportExcelUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;

/**
* 	- Excel模板文件的数据区域
* 	- 导出Excel文件数据模型的统一上层类
*/
public class TemplateDataRegion {
	
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
	 * 	起始行-参数、头部
	 */
	private Integer startRowOther = 0;
	/**
	 * 	结束行-参数、头部
	 */
	private Integer endRowOther;
	/**
	 * 	起始列-参数、头部
	 */
	private Integer startColumnOther = 0;
	/**
	 * 	结束列-参数、头部
	 */
	private Integer endColumnOther;
	
	public TemplateDataRegion() {
		super();
	}

	public TemplateDataRegion(Integer startRow, Integer endRow, Integer startColumn, Integer endColumn) {
		super();
		this.startRow = startRow;
		this.endRow = endRow;
		this.startColumn = startColumn;
		this.endColumn = endColumn;
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

	public Integer getStartRowOther() {
		return startRowOther;
	}

	public void setStartRowOther(Integer startRowOther) {
		this.startRowOther = startRowOther;
	}

	public Integer getEndRowOther() {
		return endRowOther;
	}

	public void setEndRowOther(Integer endRowOther) {
		this.endRowOther = endRowOther;
	}

	public Integer getStartColumnOther() {
		return startColumnOther;
	}

	public void setStartColumnOther(Integer startColumnOther) {
		this.startColumnOther = startColumnOther;
	}

	public Integer getEndColumnOther() {
		return endColumnOther;
	}

	public void setEndColumnOther(Integer endColumnOther) {
		this.endColumnOther = endColumnOther;
	}

	/**
     * 	通过Sheet页面 遍历Excel模板文件的数据区域
     * 	转化为属性配置映射集合  获取属性配置 并赋值到etu
     * 	获取sheetName 并赋值到etu
     * @param templateSheet
     * @param etu
     */
	public void converThisBySheet(Sheet templateSheet, AbstractExportExcelUtil<?,?,?,?> etu) {
		List<ExportConfig> dataFields = new ArrayList<ExportConfig>();
		List<ExportConfig> otherFields = new ArrayList<ExportConfig>();
		int startRow = this.getStartRow();
    	int endRow = this.getEndRow();
    	int startColumn = this.getStartColumn();
    	int endColumn = this.getEndColumn();
    	ExportConfig expConf = null;
    	for(int rowNo = startRow; rowNo <= endRow; rowNo++) {
    		Row row = templateSheet.getRow(rowNo);
    		for(int columnNo = startColumn; columnNo <= endColumn; columnNo++) {
    			Object cellValue = etu.getCellValue(row, columnNo);
    			String cellValStr = (String)cellValue;
    			expConf = ExportConfig.convertExportConfigByExp(cellValStr);
    			if(null != expConf) {
    				expConf.setRowNo(rowNo);
    				expConf.setColumnNo(columnNo);
    				if(ExportConfigType.DATA == expConf.getExportConfigType()) {
    					dataFields.add(expConf);
    				} else {
    					otherFields.add(expConf);
    				}
    			}
        	}
    	}
    	this.setStartRowOther(startRow);
    	this.setEndRowOther(Math.max(startRow, endRow - 1));
    	this.setStartColumnOther(startColumn);
    	this.setEndColumnOther(endColumn);
    	etu.setFields(dataFields, otherFields);
    	etu.setSheetName(templateSheet.getSheetName());
	}
}