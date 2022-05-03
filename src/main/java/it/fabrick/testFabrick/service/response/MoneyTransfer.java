package it.fabrick.testFabrick.service.response;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.fabrick.testFabrick.service.entity.Amount;
import it.fabrick.testFabrick.service.entity.Creditor;
import it.fabrick.testFabrick.service.entity.Debtor;
import it.fabrick.testFabrick.service.entity.Fee;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoneyTransfer {
	@JsonProperty("moneyTransferId")	
	private BigInteger moneyTransferId;
	@JsonProperty("status")
	private String status;
	@JsonProperty("direction")
	private String direction;
	@JsonProperty("creditor")
	private Creditor creditor;
	@JsonProperty("debtor")
	private Debtor debtor;
	@JsonProperty("cro")
	private String cro;
	@JsonProperty("uri")
	private String uri;
	@JsonProperty("trn")
	private String trn;
	@JsonProperty("description")
	private String description;
	@JsonProperty("createdDatetime")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
	private Date createdDatetime;
	@JsonProperty("accountedDatetime")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
	private Date accountedDatetime; 
	@JsonProperty("debtorValueDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date debtorValueDate; 
	@JsonProperty("creditorValueDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date creditorValueDate;
	@JsonProperty("amount")
	private Amount amount;
	@JsonProperty("isUrgent")
	private Boolean isUrgent;
	@JsonProperty("isInstant")
	private Boolean isInstant;
	@JsonProperty("feeType")
	private String feeType;
	@JsonProperty("feeAccountId")
	private BigInteger feeAccountId;
	@JsonProperty("fees")
	private List<Fee> fees;
	@JsonProperty("hasTaxRelief")
	private Boolean hasTaxRelief;

}
