package com.onik.CRUDapi.model;



public class ApiResponse<T> {
	
	private T data;
	private String msg;
	private int status;
	
	public ApiResponse() {
		
	}
	public ApiResponse(T data, String msg, int status) {
		super();
		this.data = data;
		this.msg = msg;
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
