package it.fabrick.testFabrick.service.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LegalPersonBeneficiary {
	@JsonProperty("fiscalCode")
	private String fiscalCode;
	@JsonProperty("legalRepresentativeFiscalCode")
    private String legalRepresentativeFiscalCode;

}
