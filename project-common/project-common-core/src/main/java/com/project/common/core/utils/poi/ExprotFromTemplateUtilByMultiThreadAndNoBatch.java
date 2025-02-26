package com.project.common.core.utils.poi;

import com.project.common.core.domain.exportdata.ExportConfig;
import com.project.common.core.exception.exportdata.ExportExcelException;
import com.project.common.core.utils.poi.abstractpg.AbstractExportExcelUtil;
import com.project.common.core.web.domain.AjaxResult;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

/**
 * ExprotFromTemplateUtil   多单线程生成sheet页  并不支持分批次获取数据
 * 	用于从模板文件读取模板配置信息及表头信息，
 * 	若是数据超过sheet最大行数则扩展sheet页并复制模板配置信息及表头信息，
 * 	最后进行数据填充                                    
 * 
 * @author yyc
 */
public class ExprotFromTemplateUtilByMultiThreadAndNoBatch<P, H, D, T> extends AbstractExportExcelUtil<P, H, D, T>
{
	private static final Logger log = LoggerFactory.getLogger(ExprotFromTemplateUtilByMultiThreadAndNoBatch.class);
    
	/**
     * 	每个sheetNo的存入最后一行的引用
     */
    private Map<Integer, Row> sheetNoRowMap;
    
    /**
     * 	偏移行
     */
    private int offsetRows;
	
	public ExprotFromTemplateUtilByMultiThreadAndNoBatch()
    {
    	super();
    	sheetNoRowMap = new HashedMap<>();
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
        	Double sheetNo = Math.ceil(dataModel.getData().size() / sheetSize);
            this.offsetRows = this.tdr.getEndRowOther() - this.tdr.getStartRowOther() + 1;
            for (int index = 0; index <= sheetNo.intValue(); index++)
            {
                createSheet(sheetNo, index);
            	
                // 填充参数、头部
                Row row = fillExcelByTdrCells();
                sheetNoRowMap.put(index, row);
            }
            AddTaskRetMe task = new AddTaskRetMe(0, sheetNo.intValue(), this);
            ForkJoinPool fjp = new ForkJoinPool();
            // 开始运行任务- 填充数据
    		fjp.execute(task);
    		long result = task.join();
    		log.info("ForkJoinPool:result-->>" + result + "sheetCount:" + (sheetNo.longValue() + 1));
    		if(result != (sheetNo.longValue() + 1)) {
    			throw new ExportExcelException("ForkJoinPool：任务执行数量有误。");
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
    
    @Override
    public void fillExcelData(int index, Row row, int offsetRows) throws Exception
    {
        int startNo = index * sheetSize;
        List<D> list = dataModel.getData();
        int endNo = Math.min(startNo + sheetSize, dataModel.getData().size());
        for (int i = startNo; i < endNo; i++)
        {
            row = wb.getSheetAt(index).createRow(i + offsetRows - startNo);
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
     * 	工作任务类
     * 	主要填充sheet的数据部分 最后汇总
     * @author User
     *
     */
    class AddTaskRetMe extends RecursiveTask<Long> {
    	private final Logger log = LoggerFactory.getLogger(AddTaskRetMe.class);
		private static final long serialVersionUID = 1L;
		private int start;
		private int end;
		private ExprotFromTemplateUtilByMultiThreadAndNoBatch<P, H, D, T> eru;
		
		AddTaskRetMe(int start, int end, ExprotFromTemplateUtilByMultiThreadAndNoBatch<P, H, D, T> eru) {
			this.start = start;
			this.end = end;
			this.eru = eru;
		}

		@Override
		protected Long compute() {
			
			if(end == start) {
				// 执行任务
				try {
					eru.fillExcelData(start, eru.sheetNoRowMap.get(start), eru.offsetRows);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("执行任务AddTaskRetMe-"+start+"失败");
				}
				return 1l;
			} 
			
			int middle = start + (end-start)/2;
			
			AddTaskRetMe subTask1 = new AddTaskRetMe(start, middle, eru);
			AddTaskRetMe subTask2 = new AddTaskRetMe(middle + 1, end, eru);
			subTask1.fork();
			subTask2.fork();
			
			return subTask1.join() + subTask2.join();
		}
		
	}
}