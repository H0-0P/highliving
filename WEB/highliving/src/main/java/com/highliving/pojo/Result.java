package com.highliving.pojo;

public class Result {
	
	private Integer status; //返回状态
	
	private String message; //返回消息
	
	private Object data;
	
	private Object page;

	public Result(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public Result(Integer status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	public Result(Integer status, String message, Object data, Object page) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.page = page;
	}

	public Object getPage() {
		return page;
	}

	public void setPage(Object page) {
		this.page = page;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
