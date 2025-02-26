package com.project.common.core.utils.poi.abstractpg;

import com.project.common.core.annotation.Excel.ColumnType;
import com.project.common.core.domain.exportdata.DataModel;
import com.project.common.core.domain.exportdata.ExportConfig;
import com.project.common.core.domain.exportdata.ExportConfig.RowNumber;
import com.project.common.core.domain.exportdata.TemplateDataRegion;
import com.project.common.core.enums.ExportModelType;
import com.project.common.core.exception.exportdata.ExcelReadException;
import com.project.common.core.exception.exportdata.ExportExcelException;
import com.project.common.core.text.Convert;
import com.project.common.core.utils.DateUtils;
import com.project.common.core.utils.StringUtils;
import com.project.common.core.utils.file.FileTypeUtils;
import com.project.common.core.utils.file.ImageUtils;
import com.project.common.core.web.domain.AjaxResult;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * 	导出工具类的抽象封装
 * @author User
 *
 * @param <P>
 * @param <H>
 * @param <D>
 * @param <T>
 */
public abstract class AbstractExportExcelUtil<P, H, D, T> {
	private static final Logger log = LoggerFactory.getLogger(AbstractExportExcelUtil.class);
    
    /**
     * Excel sheet最大行数，默认65536
     */
    public static final int sheetSize = 65536;

    /**
     * 	Excel 模板文件绝对路径
     */
    protected String templatePath;
    
    /**
     * 	工作表名称
     */
    protected String sheetName;

    /**
     * 	工作薄对象
     */
    protected Workbook wb;
    
    /**
     * Excel模板文件的数据区域
     */
    protected TemplateDataRegion tdr;

    /**
     * 	工作表对象
     */
    protected Sheet sheet;
    
    /**
     * 	样式列表
     */
    protected Map<String, CellStyle> styles;

    /**
     * 	导出数据模型
     */
    protected DataModel<P, H, D, T> dataModel;

    /**
     * 	DATA模板配置属性List
     */
    protected List<ExportConfig> dataFields;
    
    /**
     * 	DATA模板配置属性List
     */
    protected List<ExportConfig> otherFields;
    
    /**
     * 	辅助处理翻译与反翻译字典的数据
     */
//    public Map<String, List<SysDictData>> helpDictConvertMap = new HashMap<>();

    /**
     * 	最大高度
     */
    private short maxHeight;

    /**
     * 	统计列表
     */
    private Map<Integer, Double> statistics = new HashMap<Integer, Double>();
    
    /**
     * 	数字格式
     */
    private static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("######0.00");
    
    public AbstractExportExcelUtil()
    {
    	super();
    }
    
    /**
     * 	读取模板文件配置并填充数据 导出到excel表单
     * 
     * @param templatePath  Excel模板文件绝对路径
     * @param tdr           Excel模板文件数据区域
     * @param dataModel     填充Excel文件的所需的数据模型
     * @return
     */
    public AjaxResult exportExcel(String templatePath, TemplateDataRegion tdr, DataModel<P, H, D, T> dataModel)
    {
        this.init(templatePath, tdr, dataModel);
        return exportExcel();
    }

    /**
     * 	进行初始化操作
     * 	1、指定模板文件
     * 	2、指定模板文件数据区域
     * 	3、通过模板文件获取属性配置信息 Map<String, ExportConfig> fields
     * 	4、通过读取模板文件流 指定工作薄对象wb
     * @param templatePath  Excel模板文件绝对路径
     * @param tdr           Excel模板文件数据区域
     * @param dataModel     填充Excel文件的所需的数据模型
     */
    protected void init(String templatePath, TemplateDataRegion tdr, DataModel<P, H, D, T> dataModel)
    {
    	this.templatePath = templatePath;
    	this.tdr = tdr;
        if (dataModel == null)
        {
        	dataModel = new DataModel<P, H, D, T>();
        }
        this.dataModel = dataModel;
        readWorkbookForExpConf();
        createWorkbook();
    }
    
    /**
     * 	对list数据源将其里面的数据导入到excel表单
     * 
     * @return 结果
     */
    protected AjaxResult exportExcel() throws ExportExcelException {
    	throw new ExportExcelException("exportExcel() 没有实现的子类。");
    }
    

    /**
     * 	通过Tdr.cells获取参数及头部 进行填充
     * @throws Exception 
     */
    protected Row fillExcelByTdrCells() throws Exception {
    	Row row = null;
    	this.dataModel.getHeader();
    	this.dataModel.getParameter();
    	for(int rowNo = this.tdr.getStartRowOther(); rowNo <= this.tdr.getEndRowOther(); rowNo++) {
    		row = sheet.createRow(rowNo);
    		for(int columnNo = this.tdr.getStartColumnOther(); columnNo <= this.tdr.getEndColumnOther(); columnNo++) {
    			for (ExportConfig exportConfig : this.otherFields)
    	        {
    	        	if(rowNo == exportConfig.getRowNo() && columnNo == exportConfig.getColumnNo()) {
    	        		switch (exportConfig.getExportConfigType()) {
	    	    			case HEADER:
	    	    				row.setHeight((short)1000);
	    	    				break;
	    	    			default:
	    	    				break;
	    	    		}
    	        		this.createCell(exportConfig, row, columnNo);
    	        		break;
    	        	}
    	        }
    		}
    	}
        return row;
	}

    /**
     * 	填充excel数据
     * @param index      序号
     * @param row        单元格行
     * @param offset     偏移行(参数、头部所占行数)
     * @throws Exception
     */
    protected void fillExcelData(int index, Row row, int offsetRows) throws Exception
    {
        int startNo = index * sheetSize;
        List<D> list = dataModel.getData();
        int endNo = Math.min(startNo + sheetSize, dataModel.getData().size());
        for (int i = startNo; i < endNo; i++)
        {
            row = sheet.createRow(i + offsetRows - startNo);
            // 得到导出对象.
            D vo = list.get(i);
            int column = 0;
            for (ExportConfig exportConfig : this.dataFields)
            {
                this.addCell(exportConfig, row, vo, column++);
            }
        }
    }
    
    /**
     * 	创建表格样式
     * 
     * @param wb 工作薄对象
     * @return 样式列表
     */
    private Map<String, CellStyle> createStyles(Workbook wb)
    {
        // 写入各条记录,每条记录对应excel表中的一行
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        Font dataFont = wb.createFont();
        dataFont.setFontName("Arial");
        dataFont.setFontHeightInPoints((short) 10);
        style.setFont(dataFont);
        styles.put("data", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Font headerFont = wb.createFont();
        headerFont.setFontName("Arial");
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(headerFont);
        styles.put("header", style);
        
        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("header"));
        Font parameterFont = wb.createFont();
        parameterFont.setFontName("Arial");
        parameterFont.setFontHeightInPoints((short) 10);
        parameterFont.setBold(true);
        parameterFont.setColor(IndexedColors.ORANGE.getIndex());
        style.setFont(parameterFont);
        style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
        styles.put("parameter", style);
        
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        Font totalFont = wb.createFont();
        totalFont.setFontName("Arial");
        totalFont.setFontHeightInPoints((short) 10);
        style.setFont(totalFont);
        styles.put("total", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.LEFT);
        styles.put("data1", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.CENTER);
        styles.put("data2", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.RIGHT);
        styles.put("data3", style);

        return styles;
    }

    /**
     * 	创建单元格 
     * 	将参数、头部数据对象填充到参数及头部区域
     * @throws Exception 
     */
    private Cell createCell(ExportConfig exportConfig, Row row, int column) throws Exception
    {
        // 创建列
        Cell cell = row.createCell(column);
        String val = null;
        switch (exportConfig.getExportConfigType()) {
			case PARAMETER:
				val = (String)this.getValue(this.dataModel.getParameter(), exportConfig.getAttr());
				val = ExportConfig.mergeByOriginalAndVal(exportConfig.getOriginal(), val);
				cell.setCellStyle(styles.get("parameter"));
				break;
			case HEADER:
				val = (String)this.getValue(this.dataModel.getHeader(), exportConfig.getAttr());
				val = ExportConfig.mergeByOriginalAndVal(exportConfig.getOriginal(), val);
				cell.setCellStyle(styles.get("header"));
				break;
			default:
				// 写入列信息
				val = exportConfig.getOriginal();
				cell.setCellStyle(styles.get("header"));
				break;
		}
        // 从配置信息中转化单元格的格式类型
        cellValueOrType(val, exportConfig, cell);
        setDataValidation(exportConfig, row, column);
        return cell;
    }

    /**
     * 	设置单元格信息
     * 
     * @param value 单元格值
     * @param attr 注解相关
     * @param cell 单元格信息
     */
    private void setCellVo(Object value, ExportConfig exportConfig, Cell cell)
    {
        if (ColumnType.STRING.value() == exportConfig.getCellType())
        {
            cell.setCellValue(StringUtils.isNull(value) ? exportConfig.getDefaultValue() : (value.equals("--") ? "--" : value + exportConfig.getSuffix()) );
        }
        else if (ColumnType.NUMERIC.value() == exportConfig.getCellType())
        {
            cell.setCellValue(StringUtils.contains(Convert.toStr(value), ".") ? Convert.toDouble(value) : Convert.toInt(value));
        }
        else if (ColumnType.IMAGE.value() == exportConfig.getCellType())
        {
            ClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, (short) cell.getColumnIndex(), cell.getRow().getRowNum(), (short) (cell.getColumnIndex() + 1),
                    cell.getRow().getRowNum() + 1);
            String imagePath = Convert.toStr(value);
            if (StringUtils.isNotEmpty(imagePath))
            {
                byte[] data = ImageUtils.getImage(imagePath);
                getDrawingPatriarch(cell.getSheet()).createPicture(anchor,
                        cell.getSheet().getWorkbook().addPicture(data, getImageType(data)));
            }
        }
    }
    
    /**
     * 	获取画布
     */
    private static Drawing<?> getDrawingPatriarch(Sheet sheet)
    {
        if (sheet.getDrawingPatriarch() == null)
        {
            sheet.createDrawingPatriarch();
        }
        return sheet.getDrawingPatriarch();
    }

    /**
     * 	获取图片类型,设置图片插入类型
     */
    private int getImageType(byte[] value)
    {
        String type = FileTypeUtils.getFileExtendName(value);
        if ("JPG".equalsIgnoreCase(type))
        {
            return Workbook.PICTURE_TYPE_JPEG;
        }
        else if ("PNG".equalsIgnoreCase(type))
        {
            return Workbook.PICTURE_TYPE_PNG;
        }
        return Workbook.PICTURE_TYPE_JPEG;
    }

    /**
     * 	创建表格样式
     */
    private void setDataValidation(ExportConfig exportConfig, Row row, int column)
    {
        if (exportConfig.getName().indexOf("注：") >= 0)
        {
            sheet.setColumnWidth(column, 6000);
        }
        else
        {
            // 设置列宽
            sheet.setColumnWidth(column, (int) ((exportConfig.getWidth() + 0.72) * 256));
        }
        // 如果设置了提示信息则鼠标放上去提示.
        if (StringUtils.isNotEmpty(exportConfig.getPrompt()))
        {
            // 这里默认设了2-101列提示.
            setXSSFPrompt(sheet, "", exportConfig.getPrompt(), 1, 100, column, column);
        }
        // 如果设置了combo属性则本列只能选择不能输入
        if (exportConfig.getCombo().length > 0)
        {
            // 这里默认设了2-101列只能选择不能输入.
            setXSSFValidation(sheet, exportConfig.getCombo(), 1, 100, column, column);
        }
    }

    /**
     * 	添加单元格
     */
    protected Cell addCell(ExportConfig exportConfig, Row row, D vo, int column)
    {
        Cell cell = null;
        try
        {
            // 设置行高
            row.setHeight(maxHeight);
            // 根据Excel中设置情况决定是否导出,有些情况需要保持为空,希望用户填写这一列.
            if (exportConfig.isExport())
            {
            	// 创建cell
            	cell = row.createCell(column);
                int align = exportConfig.getAlign();
                cell.setCellStyle(styles.get("data" + (align >= 1 && align <= 3 ? align : "")));
                
             // 用于读取对象中的属性
                Object value = null;
                if(RowNumber.ENABLE == exportConfig.getRowNumber()) {
                	value = row.getRowNum() - this.tdr.getEndRowOther();
                } else {
                	value = getTargetValue(vo, this.getFieldOrSuperField(vo, exportConfig.getAttr()), exportConfig);
                }
                // 从配置信息中转化单元格的格式类型
                cellValueOrType(value, exportConfig, cell);
//                addStatisticsData(column, Convert.toStr(value), exportConfig);
            }
        }
        catch (Exception e)
        {
            log.error("导出Excel失败{}", e);
        }
        return cell;
    }

    /**
     * 	从配置信息中转化单元格的格式类型
     * @param value
     * @param exportConfig
     * @param cell
     */
    private void cellValueOrType(Object value, ExportConfig exportConfig, Cell cell) {
    	String dateFormat = exportConfig.getDateFormat();
        String readConverterExp = exportConfig.getReadConverterExp();
        String separator = exportConfig.getSeparator();
        String dictType = exportConfig.getDictType();
        if (StringUtils.isNotEmpty(dateFormat) && StringUtils.isNotNull(value))
        {
            cell.setCellValue(DateUtils.parseDateToStr(dateFormat, (Date) value));
        }
        else if (StringUtils.isNotEmpty(readConverterExp) && StringUtils.isNotNull(value))
        {
            cell.setCellValue(convertByExp(Convert.toStr(value), readConverterExp, separator));
        }
        else if (StringUtils.isNotEmpty(dictType) && StringUtils.isNotNull(value))
        {
//        	if(value.equals("合计")) {
//        		cell.setCellValue("合计");
//        	} else {
//        		cell.setCellValue(convertDictByExp(Convert.toStr(value), dictType, separator, this));
//        	}
        }
        else if (value instanceof BigDecimal && -1 != exportConfig.getScale())
        {
        	if(ExportModelType.PERCENTAGE.getValue().equals(exportConfig.getModelName())) {
        		cell.setCellValue((((BigDecimal) value).setScale(exportConfig.getScale(), exportConfig.getRoundingMode())).toString() + exportConfig.getSuffix());
        	} else {
        		cell.setCellValue((((BigDecimal) value).setScale(exportConfig.getScale(), exportConfig.getRoundingMode())).toString());
        	}
        }
        else if(null != value)
        {
            // 设置列类型
            setCellVo(value, exportConfig, cell);
        }
        else {
        	cell.setCellValue("");
        }
	}

	/**
     * 	设置 POI XSSFSheet 单元格提示
     * 
     * @param sheet 表单
     * @param promptTitle 提示标题
     * @param promptContent 提示内容
     * @param firstRow 开始行
     * @param endRow 结束行
     * @param firstCol 开始列
     * @param endCol 结束列
     */
    private void setXSSFPrompt(Sheet sheet, String promptTitle, String promptContent, int firstRow, int endRow,
            int firstCol, int endCol)
    {
        DataValidationHelper helper = sheet.getDataValidationHelper();
        DataValidationConstraint constraint = helper.createCustomConstraint("DD1");
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        DataValidation dataValidation = helper.createValidation(constraint, regions);
        dataValidation.createPromptBox(promptTitle, promptContent);
        dataValidation.setShowPromptBox(true);
        sheet.addValidationData(dataValidation);
    }

    /**
     * 	设置某些列的值只能输入预制的数据,显示下拉框.
     * 
     * @param sheet 要设置的sheet.
     * @param textlist 下拉框显示的内容
     * @param firstRow 开始行
     * @param endRow 结束行
     * @param firstCol 开始列
     * @param endCol 结束列
     * @return 设置好的sheet.
     */
    private void setXSSFValidation(Sheet sheet, String[] textlist, int firstRow, int endRow, int firstCol, int endCol)
    {
        DataValidationHelper helper = sheet.getDataValidationHelper();
        // 加载下拉列表内容
        DataValidationConstraint constraint = helper.createExplicitListConstraint(textlist);
        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        // 数据有效性对象
        DataValidation dataValidation = helper.createValidation(constraint, regions);
        // 处理Excel兼容性问题
        if (dataValidation instanceof XSSFDataValidation)
        {
            dataValidation.setSuppressDropDownArrow(true);
            dataValidation.setShowErrorBox(true);
        }
        else
        {
            dataValidation.setSuppressDropDownArrow(false);
        }

        sheet.addValidationData(dataValidation);
    }

    /**
     * 	解析导出值 0=男,1=女,2=未知
     * 
     * @param propertyValue 参数值
     * @param converterExp 翻译注解
     * @param separator 分隔符
     * @return 解析后值
     */
    protected static String convertByExp(String propertyValue, String converterExp, String separator)
    {
        StringBuilder propertyString = new StringBuilder();
        String[] convertSource = converterExp.split(",");
        for (String item : convertSource)
        {
            String[] itemArray = item.split("=");
            if (StringUtils.containsAny(separator, propertyValue))
            {
                for (String value : propertyValue.split(separator))
                {
                    if (itemArray[0].equals(value))
                    {
                        propertyString.append(itemArray[1] + separator);
                        break;
                    }
                }
            }
            else
            {
                if (itemArray[0].equals(propertyValue))
                {
                    return itemArray[1];
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }

    /**
     * 	反向解析值 男=0,女=1,未知=2
     * 
     * @param propertyValue 参数值
     * @param converterExp 翻译注解
     * @param separator 分隔符
     * @return 解析后值
     */
    protected static String reverseByExp(String propertyValue, String converterExp, String separator)
    {
        StringBuilder propertyString = new StringBuilder();
        String[] convertSource = converterExp.split(",");
        for (String item : convertSource)
        {
            String[] itemArray = item.split("=");
            if (StringUtils.containsAny(separator, propertyValue))
            {
                for (String value : propertyValue.split(separator))
                {
                    if (itemArray[1].equals(value))
                    {
                        propertyString.append(itemArray[0] + separator);
                        break;
                    }
                }
            }
            else
            {
                if (itemArray[1].equals(propertyValue))
                {
                    return itemArray[0];
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }
    
    /**
     * 	解析字典值
     * 
     * @param dictValue 字典值
     * @param dictType 字典类型
     * @param separator 分隔符
     * @return 字典标签
     */
//    protected static String convertDictByExp(String dictValue, String dictType, String separator, AbstractExportExcelUtil<?,?,?,?> etu)
//    {
//        return DictUtils.getDictLabelForMe(dictType, dictValue, separator, etu);
//    }

    /**
     * 	反向解析值字典值
     * 
     * @param dictLabel 字典标签
     * @param dictType 字典类型
     * @param separator 分隔符
     * @return 字典值
     */
//    protected static String reverseDictByExp(String dictLabel, String dictType, String separator)
//    {
//        return DictUtils.getDictValue(dictType, dictLabel, separator);
//    }
    
    /**
     * 	合计统计信息
     */
    protected void addStatisticsData(Integer index, String text, ExportConfig exportConfig)
    {
        if (exportConfig != null && exportConfig.isStatistics())
        {
            Double temp = 0D;
            if (!statistics.containsKey(index))
            {
                statistics.put(index, temp);
            }
            try
            {
                temp = Double.valueOf(text);
            }
            catch (NumberFormatException e)
            {
            }
            statistics.put(index, statistics.get(index) + temp);
        }
    }

    /**
     * 	创建统计行
     */
    protected void addStatisticsRow()
    {
        if (statistics.size() > 0)
        {
            Cell cell = null;
            Row row = sheet.createRow(sheet.getLastRowNum() + 1);
            Set<Integer> keys = statistics.keySet();
            cell = row.createCell(0);
            cell.setCellStyle(styles.get("total"));
            cell.setCellValue("合计");
            
            for (Integer key : keys)
            {
                cell = row.createCell(key);
                cell.setCellStyle(styles.get("total"));
                cell.setCellValue(DOUBLE_FORMAT.format(statistics.get(key)));
            }
            statistics.clear();
        }
    }

    /**
     * 	获取bean中的属性值
     * 
     * @param vo 实体对象
     * @param field 字段
     * @param excel 注解
     * @return 最终的属性值
     * @throws Exception
     */
    private Object getTargetValue(D vo, Field field, ExportConfig exportConfig) throws Exception
    {
        Object o = field.get(vo);
        if (StringUtils.isNotEmpty(exportConfig.getAttr()))
        {
            String target = exportConfig.getAttr();
            if (target.indexOf(".") > -1)
            {
                String[] targets = target.split("[.]");
                for (String name : targets)
                {
                    o = getValue(o, name);
                }
            }
        }
        return o;
    }

    /**
     * 	以类的属性的get方法方法形式获取值
     * 
     * @param o
     * @param name
     * @return value
     * @throws Exception
     */
    private Object getValue(Object o, String name) throws Exception
    {
        if (StringUtils.isNotNull(o) && StringUtils.isNotEmpty(name))
        {
            Field field = this.getFieldOrSuperField(o, name);
            o = field.get(o);
        }
        return o;
    }
    
    /**
     * 	若是该类没有找到属性则再往父类查找
     * @param o
     * @param name
     * @return
     * @throws Exception
     */
    protected Field getFieldOrSuperField(Object o, String name) throws Exception {
    	Class<?> clazz = o.getClass();
        Field field = null;
		try {
			field = clazz.getDeclaredField(name);
		} catch (NoSuchFieldException e) {
			field = clazz.getSuperclass().getDeclaredField(name);
		} finally {
			if(field != null) {
				field.setAccessible(true);
			}
		}
        return field;
    }

    /**
     * 	根据配置属性信息获取最大行高
     */
    private short getRowHeight()
    {
        double maxHeight = 0;
        for (ExportConfig exportConfig : this.dataFields)
        {
        	maxHeight = maxHeight > exportConfig.getHeight() ? maxHeight : exportConfig.getHeight();
        }
        return (short) (maxHeight * 20);
    }

    /**
     * 	读取模板文件并赋值Map<String, ExportConfig> fields
     * 	通过模板文件数据区域读取所有配置属性信息
     * 	完成了fields与cells的赋值
     */
    private void readWorkbookForExpConf()
    {
    	String path = this.templatePath;
    	log.info("Processing..." + path);
    	InputStream is = null;
    	try {
			is = new FileInputStream(this.templatePath);
			Workbook templateWb = WorkbookFactory.create(is);
			Sheet templateSheet = templateWb.getSheetAt(0);
			// 从模板文件获取了所有的配置信息
			// 完成了fields与cells的赋值
			converTdrToFieldsBySheet(templateSheet);
	        this.maxHeight = getRowHeight();
		} catch (IOException e) {
			log.error("Fail:", e);
			throw new ExcelReadException("读取模板文件失败：获取workbook失败。", e);
		}
    }
    
    /**
     * 	通过Sheet页面 遍历Excel模板文件的数据区域
     * 	转化为属性配置映射集合
     * @param templateSheet
     */
    private void converTdrToFieldsBySheet(Sheet templateSheet) {
		// 从模板文件获取了所有的配置信息
    	this.tdr.converThisBySheet(templateSheet, this);
	}

	/**
     * 	创建一个工作簿
     */
    private void createWorkbook()
    {
        this.wb = new SXSSFWorkbook(500);
    }

    /**
     * 	创建工作表
     * 
     * @param sheetNo sheet数量
     * @param index 序号
     */
    protected void createSheet(double sheetNo, int index)
    {
        this.sheet = wb.createSheet();
        this.styles = createStyles(wb);
        // 设置工作表的名称.
        if (sheetNo == 0)
        {
            wb.setSheetName(index, sheetName);
        }
        else
        {
            wb.setSheetName(index, sheetName + index);
        }
    }

	/**
	 * 	设置数据对象与其他对象属性集合
	 * @param dataFields
	 * @param otherFields
	 */
    public void setFields(List<ExportConfig> dataFields, List<ExportConfig> otherFields) {
		this.dataFields = dataFields;
		this.otherFields = otherFields;
	}

	/**
	 * 	设置sheet页名称
	 * @param sheetName
	 */
    public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	
	/**
     * 	获取单元格值
     * 
     * @param row 获取的行
     * @param column 获取单元格列号
     * @return 单元格值
     */
	public Object getCellValue(Row row, int column)
    {
        if (row == null)
        {
            return row;
        }
        Object val = "";
        try
        {
            Cell cell = row.getCell(column);
            if (StringUtils.isNotNull(cell))
            {
                if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA)
                {
                    val = cell.getNumericCellValue();
                    if (DateUtil.isCellDateFormatted(cell))
                    {
                        val = DateUtil.getJavaDate((Double) val); // POI Excel 日期格式转换
                    }
                    else
                    {
                        if ((Double) val % 1 != 0)
                        {
                            val = new BigDecimal(val.toString());
                        }
                        else
                        {
                            val = new DecimalFormat("0").format(val);
                        }
                    }
                }
                else if (cell.getCellType() == CellType.STRING)
                {
                    val = cell.getStringCellValue();
                }
                else if (cell.getCellType() == CellType.BOOLEAN)
                {
                    val = cell.getBooleanCellValue();
                }
                else if (cell.getCellType() == CellType.ERROR)
                {
                    val = cell.getErrorCellValue();
                }

            }
        }
        catch (Exception e)
        {
            return val;
        }
        return val;
    }
	
	/**
     * 	编码文件名  导出文件名称命名  子类继承 可重写   
     */
    protected String encodingFilename(String filename)
    {
        filename = UUID.randomUUID().toString() + "_" + filename + ".xlsx";
        return filename;
    }

    /**
     * 	获取下载路径   子类继承 可重写 
     * 
     * @param filename 文件名称
     */
    protected String getAbsoluteFile(String filename)
    {
        String downloadPath = "" + filename;
        File desc = new File(downloadPath);
        if (!desc.getParentFile().exists())
        {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
    }
}
