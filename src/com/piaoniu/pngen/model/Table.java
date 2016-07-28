package com.piaoniu.pngen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author code4crafter@gmail.com
 *         Date: 16/7/28
 *         Time: 下午5:28
 */
public class Table {

	private List<Column> columns = new ArrayList<Column>();

	private String name;

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
