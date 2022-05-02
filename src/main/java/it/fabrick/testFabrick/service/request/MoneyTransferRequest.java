package it.fabrick.testFabrick.service.request;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.fabrick.testFabrick.service.entity.Creditor;
import it.fabrick.testFabrick.service.entity.TaxRelief;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoneyTransferRequest {
	@JsonProperty("creditor")
	private Creditor creditor;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date executionDate; 
	@JsonProperty("uri")
	private String uri;
	@JsonProperty("description")
	private String description;
	@JsonProperty("amount")
	private Double amount; 
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("isUrgent")
	private Boolean isUrgent;
	@JsonProperty("isInstant")
	private Boolean isInstant;
	@JsonProperty("feeType")
	private String feeType;
	@JsonProperty("feeAccountId")
	private Long feeAccountId;
	@JsonProperty("taxRelief")
	private TaxRelief taxRelief;

}
