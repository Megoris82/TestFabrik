package it.fabrick.testFabrick.service.response;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceDetail  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;
	@JsonProperty("balance")
	private Double balance; 
	@JsonProperty("availableBalance")
	private Double availableBalance;
	@JsonProperty("currency")
	private String currency;
	public Date getDate() {
		return date;
	}
	public Double getBalance() {
		return balance;
	}
	public Double getAvailableBalance() {
		return availableBalance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	

}
