package com.mindweaver.common;

import java.time.LocalDate;
import java.util.Objects;

public class ApiResponse {

	private final boolean success;
	private final String message;
	
	public String getTimeStamp() {
		return LocalDate.now().toString();
	}
	
	public ApiResponse(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	@Override
	public String toString() {
		return "ApiResponse [success=" + success + ", message=" + message + "]";
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, success);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiResponse other = (ApiResponse) obj;
		return Objects.equals(message, other.message) && success == other.success;
	}
	
	
}
