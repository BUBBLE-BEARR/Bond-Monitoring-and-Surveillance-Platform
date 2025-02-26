package com.project.common.core.exception.exportdata;

/**
 *	excel文件读取异常类
 * @author fra.yyc
 *
 */
public class ExcelReadException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcelReadException() {
		super();
	}

	public ExcelReadException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ExcelReadException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ExcelReadException(String arg0) {
		super(arg0);
	}

	public ExcelReadException(Throwable arg0) {
		super(arg0);
	}

}
