package it.fabrick.testFabrick.service.response;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.fabrick.testFabrick.service.entity.Amount;
import it.fabrick.testFabrick.service.entity.Creditor;
import it.fabrick.testFabrick.service.entity.Debtor;
import it.fabrick.testFabrick.service.entity.Fee;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoneyTransfer {
	
	private BigInteger moneyTransferId;
	private String status;
	private String direction;
	private Creditor creditor;
	private Debtor debtor;
	private String cro;
	private String uri;
	private String trn;
	private String description;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
	private Date createdDatetime;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
	private Date accountedDatetime;  //": "2019-04-10T10:38:56.000+0200",
	private Date debtorValueDate; //": "2019-04-10",
	private Date creditorValueDate; // ": "2019-04-10",
	private Amount amount;
	private Boolean isUrgent;
	private Boolean isInstant;
	private String feeType;
	private BigInteger feeAccountId;
	private List<Fee> fees;
	private Boolean hasTaxRelief;

}
