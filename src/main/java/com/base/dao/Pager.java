package com.base.dao;

import java.util.List;

public class Pager<T> {
	private int page; // current page
	private Long total; // total pages
	private int records; // total records
	private List<T> rows;

	public Pager(Long total, Integer page, Integer records, List<T> list) {
		// TODO Auto-generated constructor stub
		this.page = page;
		this.total = total;
		this.records = records;
		this.rows = list;
	}

	public Pager() {

	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
