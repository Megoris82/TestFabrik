package it.fabrick.testFabrick.service.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxRelief {
	@JsonProperty("taxReliefId")
	private String taxReliefId;
	@JsonProperty("isCondoUpgrade")
    private Boolean isCondoUpgrade;
	@JsonProperty("creditorFiscalCode")
    private String creditorFiscalCode;
	@JsonProperty("beneficiaryType")
    private String beneficiaryType;
	@JsonProperty("naturalPersonBeneficiary")
    private NaturalPersonBeneficiary naturalPersonBeneficiary;
	@JsonProperty("legalPersonBeneficiary")
    private LegalPersonBeneficiary legalPersonBeneficiary;
}
