package com.mindweaver.dto.user;

import java.util.Objects;

public class SignInResponseDto {

	private String status;
	private String token;
	
	public SignInResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public SignInResponseDto(String status, String token) {
		super();
		this.status = status;
		this.token = token;
	}

	@Override
	public String toString() {
		return "SignInResponseDto [status=" + status + ", token=" + token + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public int hashCode() {
		return Objects.hash(status, token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignInResponseDto other = (SignInResponseDto) obj;
		return Objects.equals(status, other.status) && Objects.equals(token, other.token);
	}
	
	
	
}
