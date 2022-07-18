package com.mindweaver.dto;

import java.util.Objects;

public class ResponseDto {

	private String status;
	private String message;
	
	public ResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public ResponseDto(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseDto [status=" + status + ", message=" + message + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseDto other = (ResponseDto) obj;
		return Objects.equals(message, other.message) && Objects.equals(status, other.status);
	}
	
	
}
