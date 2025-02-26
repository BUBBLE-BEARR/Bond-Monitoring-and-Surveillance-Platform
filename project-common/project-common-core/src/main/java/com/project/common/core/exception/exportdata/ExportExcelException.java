package com.project.common.core.exception.exportdata;

/**
 *	导出 excel文件 异常类
 *
 */
public class ExportExcelException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExportExcelException() {
		super();
	}

	public ExportExcelException(String message, Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExportExcelException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExportExcelException(String message) {
		super(message);
	}

	public ExportExcelException(Throwable cause) {
		super(cause);
	}

}
