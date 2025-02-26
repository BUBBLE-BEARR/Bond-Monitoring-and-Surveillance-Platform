package com.project.common.core.domain.exportdata;

import java.util.List;

/**
* 	- 用于导出Excel文件的数据模型
* 	- 导出Excel文件数据模型的统一上层类
*/
public class DataModel<P, H, D, T> {
	
	/**
	 * 	参数数据对象 后面都是'.'+属性名
	 */
	private P parameter;
	/**
	 * 	行头数据对象 后面都是'.'+属性名
	 */
	private H header;
	/**
	 * 	数据对象     后面都是'.'+属性名  若需要的话分页 可以是com.github.pagehelper.Page
	 */
	private List<D> data; 
	/**
	 * 	行尾数据对象 后面都是'.'+属性名
	 */
	private T tailer;
	
	public DataModel() {
		super();
	}

	public DataModel(P parameter, H header, List<D> data, T tailer) {
		super();
		this.parameter = parameter;
		this.header = header;
		this.data = data;
		this.tailer = tailer;
	}

	public P getParameter() {
		return parameter;
	}

	public void setParameter(P parameter) {
		this.parameter = parameter;
	}

	public H getHeader() {
		return header;
	}

	public void setHeader(H header) {
		this.header = header;
	}

	public List<D> getData() {
		return data;
	}

	public void setData(List<D> data) {
		this.data = data;
	}

	public T getTailer() {
		return tailer;
	}

	public void setTailer(T tailer) {
		this.tailer = tailer;
	}

}