package com.project.common.core.utils;

import java.math.BigDecimal;

/**
 * - 数额精度转化类
 * 
 * @author project
 */
public class BigDecimalUtils {
	
	/**
	 * - 保留小数精度
	 */
	public static final int SCALE = 2;
	
	/**
	 * - 将万元转化为亿元 并四舍五入保留2位小数
	 * @param target
	 * @return
	 */
	public static String converToString(BigDecimal target)
    {
		if(null == target) {
			return "";
		}
        return converToString(target, SCALE);
    }
	
	/**
	 * - 将万元转化为亿元 并四舍五入保留2位小数
	 * @param target
	 * @return
	 */
	public static String converToString(BigDecimal target, int scale)
    {
		if(null == target) {
			return "0.00";
		}
		BigDecimal num1 = new BigDecimal("10000");
		BigDecimal result = target.divide(num1, scale, BigDecimal.ROUND_HALF_UP);
        return result.toPlainString();
    }
}
