package com.project.common.core.utils.poi;

import com.project.common.core.exception.exportdata.ExportExcelException;
import com.project.common.core.utils.poi.abstractpg.AbstractExportExcelUtil;
import com.project.common.core.web.domain.AjaxResult;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Collectors;

/**
 * ExprotFromTemplateUtil   单线程生成sheet页  并不支持分批次获取数据
 * 	用于从模板文件读取模板配置信息及表头信息，
 * 	若是数据超过sheet最大行数则扩展sheet页并复制模板配置信息及表头信息，
 * 	最后进行数据填充                                    
 * 
 * @author yyc
 */
public class ExprotFromTemplateUtil<P, H, D, T> extends AbstractExportExcelUtil<P, H, D, T>
{
	private static final Logger log = LoggerFactory.getLogger(ExprotFromTemplateUtil.class);
    public ExprotFromTemplateUtil()
    {
    	super();
    }
    
    @Override
    public AjaxResult exportExcel() 
    {
        OutputStream out = null;
        try
        {
        	if(dataModel.getData().size() > 0) {
        		this.dataFields = this.dataFields.stream().sorted((x, y) -> x.getColumnNo() - y.getColumnNo()).collect(Collectors.toList());
        	}
            // 取出一共有多少个sheet.
            double sheetNo = Math.ceil(dataModel.getData().size() / sheetSize);
            int offsetRows = this.tdr.getEndRowOther() - this.tdr.getStartRowOther() + 1;
            for (int index = 0; index <= sheetNo; index++)
            {
                createSheet(sheetNo, index);
            	
                // 填充参数、头部
                Row row = fillExcelByTdrCells();
                // 填充数据
                fillExcelData(index, row, offsetRows);
//                addStatisticsRow();
            }
            String filename = encodingFilename(sheetName);
            out = new FileOutputStream(getAbsoluteFile(filename));
            wb.write(out);
            return AjaxResult.success(filename);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
            log.error("导出Excel异常{}", e);
            throw new ExportExcelException("导出Excel失败，请联系网站管理员！");
        }
        finally
        {
            if (wb != null)
            {
                try
                {
                    wb.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
            if (out != null)
            {
                try
                {
                    out.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
        }
    }
}