package it.fabrick.testFabrick.service.response;

import java.util.List;

public class TransactionListResponse {
	private String status;
	private List<Error> error;
	private TransactionList payload;
	public String getStatus() {
		return status;
	}
	public List<Error> getError() {
		return error;
	}
	public TransactionList getPayload() {
		return payload;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setError(List<Error> error) {
		this.error = error;
	}
	public void setPayload(TransactionList payload) {
		this.payload = payload;
	}
	
	

}
