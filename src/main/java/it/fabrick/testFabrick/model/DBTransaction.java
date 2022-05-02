package it.fabrick.testFabrick.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

import it.fabrick.testFabrick.converter.ObjectToStringConverter;
import it.fabrick.testFabrick.service.entity.Type;

@Entity
@Table(name = "transaction")
public class DBTransaction {
	
	@Id
	@Column(name = "transactionId")	
	private Long transactionId;
	@Column(name = "operationId")
    private String operationId;
	@Column(name = "accountingDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date accountingDate;
	@Column(name = "valueDate")
    private Date valueDate;
	@Column(name = "type", length = 200)
	@Convert(converter = ObjectToStringConverter.class)
    private Type type; 
	@Column(name = "amount")
    private Double amount;
	@Column(name = "currency")
    private String currency;
	@Column(name = "description")
    private String description;
	
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
