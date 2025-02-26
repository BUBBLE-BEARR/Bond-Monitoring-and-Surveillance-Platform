package com.project.common.core.exception.exportdata;

/**
 *	excel文件写入异常类
 *
 */
public class ExcelWriteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcelWriteException() {
		super();
	}

	public ExcelWriteException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ExcelWriteException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ExcelWriteException(String arg0) {
		super(arg0);
	}

	public ExcelWriteException(Throwable arg0) {
		super(arg0);
	}

}
