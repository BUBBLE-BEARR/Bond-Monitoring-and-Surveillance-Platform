package com.project.common.core.enums;

/**
 * 	导出配置类别
 * 
 * @author yangyc
 */
public enum ExportConfigType
{
    NONE(null),
	/**
     * 	参数数据配置类别
     */
	PARAMETER("parameter"),

    /**
     * 	行头数据配置类别
     */
	HEADER("header"),
	/**
     * 	数据行配置类别
     */
	DATA("data"),
	/**
     * 	行尾数据配置类别
     */
	TAILER("tailer");
    
	private final String value;
	
	ExportConfigType(String value){
        this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	/**
	 * 	根据code值返回枚举类 若没有该code值则返回无参枚举
	 * @param code
	 * @return
	 */
	public static ExportConfigType getEnumsByCode(String value){
		for(ExportConfigType enums : ExportConfigType.values()){
			if(value.equals(enums.getValue())){
				return enums;
			}
		}
		return NONE;
	}
}
