package com.mindweaver.dto.checkout;

public class StripeResponse {
	private String sessionId;
	
public StripeResponse() {
	// TODO Auto-generated constructor stub
}

public StripeResponse(String sessionId) {
	super();
	this.sessionId = sessionId;
}

public String getSessionId() {
	return sessionId;
}

public void setSessionId(String sessionId) {
	this.sessionId = sessionId;
}

@Override
public String toString() {
	return "StripeResponse [sessionId=" + sessionId + "]";
}

}
