package it.fabrick.testFabrick.service.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NaturalPersonBeneficiary {
	@JsonProperty("fiscalCode1")
	private String fiscalCode1; 
	@JsonProperty("fiscalCode2")
	private String fiscalCode2;
	@JsonProperty("fiscalCode3")
	private String fiscalCode3;
	@JsonProperty("fiscalCode4")
	private String fiscalCode4;
	@JsonProperty("fiscalCode5")
	private String fiscalCode5;

}
