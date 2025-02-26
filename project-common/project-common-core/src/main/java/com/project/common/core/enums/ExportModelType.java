package com.project.common.core.enums;

/**
 * 	Excel导出模式匹配类别
 * 
 * @author yangyc
 */
public enum ExportModelType
{
    /**
     * 	通用模式
     */
	CURRENCY("currency"),
	/**
     * 	序号模式
     */
	ROWNUMBER("rownumber"),
    /**
     * 	数额模式
     */
	AMOUNT("amount"),
	/**
	 * 	占比模式
	 */
	PERCENTAGE("percentage"),
	/**
	 * 	日期模式
	 */
	DATE("date");
    
	private final String value;
	
	ExportModelType(String value){
        this.value = value;
	}

	public String getValue() {
		return value;
	}
}
