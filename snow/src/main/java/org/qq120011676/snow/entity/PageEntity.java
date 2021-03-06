package org.qq120011676.snow.entity;

import java.util.List;

public class PageEntity<T> {

	private int maxCount;

	private int maxPage;

	private int nowPage;

	private int onePageRows;

	private List<? extends T> results;

	public int getMaxCount() {
		return this.maxCount;
	}

	public void setMaxCount(int paramInt) {
		this.maxCount = paramInt;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getNowPage() {
		return this.nowPage;
	}

	public void setNowPage(int paramInt) {
		this.nowPage = paramInt;
	}

	public int getOnePageRows() {
		return onePageRows;
	}

	public void setOnePageRows(int onePageRows) {
		this.onePageRows = onePageRows;
	}

	public List<? extends T> getResults() {
		return this.results;
	}

	public void setResults(List<? extends T> paramList) {
		this.results = paramList;
	}
}
