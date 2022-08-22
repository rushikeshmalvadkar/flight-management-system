package com.fms.dto;

public class FmsResponseBody<T> {

	private T data;

	private Integer status;
	private String error;

	public FmsResponseBody(T data, Integer status) {
		this.data = data;
		this.status = status;
	}

	public FmsResponseBody(String error, Integer status) {
		this.error = error;
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
