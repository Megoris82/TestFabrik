package it.fabrick.testFabrick.service.response;

import java.util.List;

public class BalanceDetailResponse {
	private String status;
	private List<Error> error;
	private BalanceDetail payload;
	public String getStatus() {
		return status;
	}
	public List<Error> getError() {
		return error;
	}
	public BalanceDetail getPayload() {
		return payload;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setError(List<Error> error) {
		this.error = error;
	}
	public void setPayload(BalanceDetail payload) {
		this.payload = payload;
	}
	
	

}
