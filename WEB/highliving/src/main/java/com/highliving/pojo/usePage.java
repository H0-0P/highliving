package com.highliving.pojo;


public class usePage {
	private Integer countPage;
	private Integer size;
	private Integer currentPage;
	
	
	public usePage() {
	}
	public usePage(Integer countPage, Integer size, Integer currentPage) {
		super();
		this.countPage = countPage;
		this.size = size;
		this.currentPage = currentPage;
	}
	public Integer getCountPage() {
		return countPage;
	}
	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "Page [countPage=" + countPage + ", size=" + size + ", currentPage=" + currentPage + "]";
	}
	
}
