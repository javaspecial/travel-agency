package com.resources;

import java.util.List;

public class Response<E> {
	private String status;
	private Object data;
	private int numRows;
	private int currentRowIndex;
	private int pageSize = 10;
	private List<E> rows;
	private Object model;
	private int startNumber = 0;
	private int endNumber;
	private int totalNumber;
	private boolean hasPrevious;
	private boolean hasNext;
	private String message;

	public Response() {
	}

	public Response(String status) {
		this.status = status;
	}

	public Response(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public Response(String status, Object data) {
		this.status = status;
		this.data = data;
	}

	public Response(String status, Object data, Object model) {
		this.status = status;
		this.data = data;
		this.model = model;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCurrentRowIndex() {
		return currentRowIndex;
	}

	public void setCurrentRowIndex(int currentRowIndex) {
		this.currentRowIndex = currentRowIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getRows() {
		return rows;
	}

	public void setRows(List<E> list) {
		this.rows = list;
	}

	public int getNextPage() {
		if (numRows == 0) {
			return 0;
		}
		return getCurrentRowIndex() + getPageSize();
	}

	public int getPreviousPage() {
		int i = getCurrentRowIndex() - getPageSize();
		if (i < 0) {
			i = 0;
		}
		return i;
	}

	public int getLastPage() {
		if (numRows == 0 || numRows < pageSize) {
			return 0;
		}
		return numRows - pageSize;
	}

	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}

	public int getStartNumber() {
		return startNumber;
	}

	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	public int getEndNumber() {
		return endNumber;
	}

	public void setEndNumber(int endNumber) {
		this.endNumber = endNumber;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public void updateCurrentRowIndex(String actionCommand) {
		if (actionCommand.equals("firstPage") || actionCommand.equals("searchButton")) {
			setCurrentRowIndex(0);
		} else if (actionCommand.equals("prevPage")) {
			setCurrentRowIndex(getPreviousPage());
		} else if (actionCommand.equals("nextPage")) {
			setCurrentRowIndex(getNextPage());
		} else if (actionCommand.equals("lastPage")) {
			setCurrentRowIndex(getLastPage());
		} else {
			setCurrentRowIndex(0);
		}
	}

	public boolean isHasPrevious() {
		return hasPrevious;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
