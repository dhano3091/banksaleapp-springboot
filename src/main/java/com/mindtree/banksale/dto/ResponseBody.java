package com.mindtree.banksale.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseBody<T> {

	private T data;
	private ErrorDTO errorDTO;
	private boolean status;
	private String message;

	public ResponseBody() {

	}

	public ResponseBody(T data, ErrorDTO errorDTO, boolean status, String message) {
		super();
		this.data = data;
		this.errorDTO = errorDTO;
		this.status = status;
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ErrorDTO getErrorDTO() {
		return errorDTO;
	}

	public void setErrorDTO(ErrorDTO errorDTO) {
		this.errorDTO = errorDTO;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseBody [data=" + data + ", errorDTO=" + errorDTO + ", status=" + status + ", message=" + message
				+ "]";
	}

}
