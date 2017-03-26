package com.website.mybarter.manager.pagemodel;

import java.util.List;

@SuppressWarnings("rawtypes")
public class DataGrid {

	private Long total = 0L;
	private List rows;

	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

	/**
	 * @return the rows
	 */
	public List getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(List rows) {
		this.rows = rows;
	}

}
