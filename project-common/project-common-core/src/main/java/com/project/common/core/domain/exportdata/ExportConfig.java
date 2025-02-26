package com.project.common.core.domain.exportdata;

import com.project.common.core.enums.ExportConfigType;
import com.project.common.core.enums.ExportModelType;
import com.project.common.core.exception.exportdata.ExcelReadException;
import com.project.common.core.factory.StrategyFactory;
import com.project.common.core.factory.strategy.Strategy;
import com.project.common.core.text.Convert;
import com.project.common.core.utils.DateUtils;
import com.project.common.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 	属性配置数据对象
 * 	- 表达式例子：${targetAttr(t6)|cellType(0)|scale(2)|isStatistics(true)}
 * 	- 通过表达式应用正则表达式完成赋值操作
 * 
 * @author yyc
 */
public class ExportConfig
{
	private static final Logger log = LoggerFactory.getLogger(ExportConfig.class);
	
	/**
	 * 	默认不开启自增
	 */
	private RowNumber rowNumber = RowNumber.DISABLE;
	
	public enum RowNumber
    {
    	ENABLE, DISABLE;
    }
	
	/**
     * 	模板文件中单元格的内容  从模板文件中获取 表达式中一般不涉及到
     */
	private String name = "";

	/**
	 * 	另一个类中的属性名称,支持多级获取,以小数点隔开
	 */
	private String targetAttr = "";
	
    /**
     * 	日期格式, 如: yyyy-MM-dd
     */
    private String dateFormat = "";

    /**
     * 	如果是字典类型，请设置字典的type值 (如: sys_user_sex)
     */
    private String dictType = "";

    /**
     * 	读取内容转表达式 (如: 0=男,1=女,2=未知)
     */
    private String readConverterExp = "";

    /**
     * 	分隔符，读取字符串组内容
     */
    private String separator = ",";

    /**
     * BigDecimal 精度 默认:-1(默认不开启BigDecimal格式化)
     */
    private int scale = -1;

    /**
     * BigDecimal 舍入规则 默认:BigDecimal.ROUND_HALF_EVEN
     */
    private int roundingMode = BigDecimal.ROUND_HALF_EVEN;

    /**
     * 	单元格类型类型（0数字 1字符串）
     */
    private int cellType = ColumnType.STRING.value();

    /**
     * 	单元格列高 单位为字符
     */
    private double height = 14;

    /**
     * 	单元格列宽 单位为字符
     */
    private double width = 16;

    /**
     * 	文字后缀,如% 90 变成90%
     */
    private String suffix = "";

    /**
     * 	当值为空时,字段的默认值
     */
    private String defaultValue = "";
    
    /**
     * 	提示信息
     */
    private String prompt = "";

    /**
     * 	设置只能选择不能输入的列内容.
     */
    private String[] combo = {};
    
    /**
     * 	是否导出数据,应对需求:有时我们需要导出一份模板,这是标题需要但内容需要用户手工填写.
     */
    private boolean isExport = true;

    /**
     * 	是否自动统计数据,在最后追加一行统计数据总和
     */
    private boolean isStatistics = false;
    
    /**
     * 	单元格对齐方式（0：默认；1：靠左；2：居中；3：靠右）
     */
    private int align = 0;

    public enum Align
    {
        AUTO(0), LEFT(1), CENTER(2), RIGHT(3);
        private final int value;

        Align(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    public enum ColumnType
    {
        NUMERIC(0), STRING(1), IMAGE(2);
    	public final int value;

        ColumnType(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }
    
    /**
     * 	原本的值
     */
    private String original;
    
    /**
     * 	导出配置类别
     */
    private ExportConfigType exportConfigType = ExportConfigType.NONE;
    
    /**
     * 	属性值
     */
    private String attr = "";
    
    /**
     * 	行号
     */
    private int rowNo;
    
    /**
     *	列号
     */
    private int columnNo;
    
    /**
     * 	amount:数额 percentage:占比
     */
    private String modelName;

    public ExportConfig() {
		super();
	}
    
    public ExportConfig(String original) {
		super();
		this.original = original;
	}
    
	public RowNumber getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(RowNumber rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTargetAttr() {
		return targetAttr;
	}

	public void setTargetAttr(String targetAttr) {
		this.targetAttr = targetAttr;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getReadConverterExp() {
		return readConverterExp;
	}

	public void setReadConverterExp(String readConverterExp) {
		this.readConverterExp = readConverterExp;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getRoundingMode() {
		return roundingMode;
	}

	public void setRoundingMode(int roundingMode) {
		this.roundingMode = roundingMode;
	}

	public int getCellType() {
		return cellType;
	}

	public void setCellType(int cellType) {
		this.cellType = cellType;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String[] getCombo() {
		return combo;
	}

	public void setCombo(String[] combo) {
		this.combo = combo;
	}

	public boolean isExport() {
		return isExport;
	}

	public void setExport(boolean isExport) {
		this.isExport = isExport;
	}

	public int getAlign() {
		return align;
	}

	public void setAlign(int align) {
		this.align = align;
	}

	public boolean isStatistics() {
		return isStatistics;
	}

	public void setStatistics(boolean isStatistics) {
		this.isStatistics = isStatistics;
	}
	
	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public ExportConfigType getExportConfigType() {
		return exportConfigType;
	}

	public void setExportConfigType(ExportConfigType exportConfigType) {
		this.exportConfigType = exportConfigType;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}
	
	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public int getColumnNo() {
		return columnNo;
	}

	public void setColumnNo(int columnNo) {
		this.columnNo = columnNo;
	}

	/**
	 * 	应用"${group(1)}"这种正则表达式
	 */
	private final static String EXP_FIRST_COMM = "\\${1}\\{{1}((\\[{1}(\\S*)\\]{1}){0,1}(\\S*))\\}{1}";
	/**
	 * 	应用"group(2)(group(3))|"这种正则表达式
	 */
	private final static String EXP_SECOND_COMM = "((\\S+)\\({1}(\\S+)\\){1}\\|{0,1})+";
	
	/**
	 * 	应用"header.t0.t1.t100"这种正则表达式
	 * 	header -->> group(1)
	 * 	t0.t1.t100 -->> group(2)
	 * 	或者"header" -->> group(3)
	 */
	private final static String EXP_THIRD_COMM = "(\\S+)\\.{1}(\\S+)|(\\S+)";
	
	/**
	 * 	通过表达式转化为ExportConfig对象
	 * @param expression 自定义的表达式
	 * @return
	 */
	public static ExportConfig convertExportConfigByExp(String expression) throws ExcelReadException {
		ExportConfig excfg = null;
		Pattern pattern = Pattern.compile(EXP_FIRST_COMM);
		Matcher matcher = pattern.matcher(expression);
		try {
			excfg = new ExportConfig(expression);
			if(matcher.find()) {
//				String allResult = matcher.group(1);
//				String modelNameAll = matcher.group(2);
				String modelName = matcher.group(3);
				if(StringUtils.isEmpty(modelName)) {
					// 为空时 默认是通用模式
					modelName = ExportModelType.CURRENCY.getValue();
				}
				excfg.setModelName(modelName);
				Strategy<Void, ExportConfig> strategy = StrategyFactory
						.getStrategyForExport(modelName)
						.orElseThrow(() -> new IllegalArgumentException("Invalid Operator -> 失效的操作"));
				// 执行模式匹配的逻辑
				strategy.apply(excfg);
				String firstResult = matcher.group(4);
				if(StringUtils.isNotEmpty(firstResult)) {
					String[] strs = new String[] { firstResult };
					if(StringUtils.contains(firstResult, "|")) {
						strs = firstResult.split("\\|");
					}
					for (String target : strs)
					{
						pattern = Pattern.compile(EXP_SECOND_COMM);
						matcher = pattern.matcher(target);
						if(matcher.find()) {
							assignmentAndConvert(excfg, matcher.group(2), matcher.group(3));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Fail:", e);
			throw new ExcelReadException("通过表达式转化为ExportConfig对象失败。", e);
		}
		return excfg;
	}
	/**
	 * @param excfg        要赋值的对象
	 * @param fieldName	        属性名称
	 * @param fieldVal     属性值  经过转化
	 */
	private static void assignmentAndConvert(ExportConfig excfg, String fieldName, String fieldVal) throws Exception {
		Class<?> clazz = excfg.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        Class<?> fieldType = field.getType();
		
		if (String.class == fieldType)
        {
            field.set(excfg, Convert.toStr(fieldVal));
        }
        else if ((Integer.TYPE == fieldType || Integer.class == fieldType) && StringUtils.isNumeric(Convert.toStr(fieldVal)))
        {
        	field.set(excfg, Convert.toInt(fieldVal));
        }
        else if (Long.TYPE == fieldType || Long.class == fieldType)
        {
        	field.set(excfg, Convert.toLong(fieldVal));
        }
        else if (Double.TYPE == fieldType || Double.class == fieldType)
        {
        	field.set(excfg, Convert.toDouble(fieldVal));
        }
        else if (Float.TYPE == fieldType || Float.class == fieldType)
        {
        	field.set(excfg, Convert.toFloat(fieldVal));
        }
        else if (BigDecimal.class == fieldType)
        {
        	field.set(excfg, Convert.toBigDecimal(fieldVal));
        }
        else if (Date.class == fieldType)
        {
        	field.set(excfg, DateUtils.parseDate(fieldVal));
        }
        else if (Boolean.TYPE == fieldType || Boolean.class == fieldType)
        {
        	field.set(excfg, Convert.toBool(fieldVal, false));
        }
        else if (String[].class == fieldType)
        {
        	String temp = Convert.toStr(fieldVal, "");
        	field.set(excfg, temp.split(","));
        }
		// 通过targetAttr 获取类别及attr 并赋值
		convertTypeAndAttrByTargetAttr(excfg);
	}

	/**
	 * 	通过targetAttr 获取类别及attr 并赋值
	 * @param excfg
	 */
	private static void convertTypeAndAttrByTargetAttr(ExportConfig excfg) {
		Pattern pattern = Pattern.compile(EXP_THIRD_COMM);
		Matcher matcher = pattern.matcher(excfg.getTargetAttr());
		if(matcher.find()) {
			if(null == matcher.group(3)) {
				excfg.setExportConfigType(ExportConfigType.getEnumsByCode(matcher.group(1)));
				excfg.setAttr(matcher.group(2));
			} else {
				// 没有.的默认是数据类别的
				excfg.setExportConfigType(ExportConfigType.DATA);
				excfg.setAttr(matcher.group(3));
			}
		}
	}
	
	/**
	 * 	将匹配到的字符 替换为val
	 * @param original
	 * @param val
	 * @return
	 */
	public static String mergeByOriginalAndVal(String original, String val) {
		return original.replaceAll(EXP_FIRST_COMM, val);
	}

	@Override
	public String toString() {
		return "ExportConfig [name=" + name + ", targetAttr=" + targetAttr + ", dateFormat=" + dateFormat
				+ ", dictType=" + dictType + ", readConverterExp=" + readConverterExp + ", separator=" + separator
				+ ", scale=" + scale + ", roundingMode=" + roundingMode + ", cellType=" + cellType + ", height="
				+ height + ", width=" + width + ", suffix=" + suffix + ", defaultValue=" + defaultValue + ", prompt="
				+ prompt + ", combo=" + Arrays.toString(combo) + ", isExport=" + isExport + ", isStatistics="
				+ isStatistics + ", align=" + align + ", original=" + original + ", exportConfigType="
				+ exportConfigType + ", attr=" + attr + ", rowNo=" + rowNo + ", columnNo=" + columnNo + "]";
	}
}