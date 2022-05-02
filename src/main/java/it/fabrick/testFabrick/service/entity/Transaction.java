package it.fabrick.testFabrick.service.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("transactionId")	
	private Long transactionId;
	@JsonProperty("operationId")
    private String operationId;
	@JsonProperty("accountingDate")//": "00000000273015",
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date accountingDate;
	@JsonProperty("valueDate")// ": "2019-04-01",
    private Date valueDate;// ": "2019-04-01",
	@JsonProperty("type")
    private Type type; 
	@JsonProperty("amount")
    private Double amount;// ": -800,
	@JsonProperty("currency")
    private String currency;// ": "EUR",
	@JsonProperty("description")
    private String description; //": "BA JOHN DOE PAYMENT INVOICE 75/2017"
	public Long getTransactionId() {
		return transactionId;
	}
	public String getOperationId() {
		return operationId;
	}
	public Date getAccountingDate() {
		return accountingDate;
	}
	public Date getValueDate() {
		return valueDate;
	}
	public Type getType() {
		return type;
	}
	public Double getAmount() {
		return amount;
	}
	public String getCurrency() {
		return currency;
	}
	public String getDescription() {
		return description;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	public void setAccountingDate(Date accountingDate) {
		this.accountingDate = accountingDate;
	}
	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
