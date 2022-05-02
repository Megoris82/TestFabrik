package it.fabrick.testFabrick.service.response;

import java.util.List;

public class MoneyTransferResponse {
	private String status;
	private List<Error> error;
	private MoneyTransfer payload;
	public String getStatus() {
		return status;
	}
	public List<Error> getError() {
		return error;
	}
	public MoneyTransfer getPayload() {
		return payload;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setError(List<Error> error) {
		this.error = error;
	}
	public void setPayload(MoneyTransfer payload) {
		this.payload = payload;
	}
}
