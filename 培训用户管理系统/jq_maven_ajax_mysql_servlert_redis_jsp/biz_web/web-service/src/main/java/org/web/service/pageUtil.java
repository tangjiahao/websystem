package org.web.service;

public class pageUtil {
	String option;
	int index;
	int pagenum;
	int pagesize;
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	@Override
	public String toString() {
		return "pageUtil [option=" + option + ", index=" + index + ", pagenum=" + pagenum + ", pagesize=" + pagesize
				+ "]";
	}
	

}
