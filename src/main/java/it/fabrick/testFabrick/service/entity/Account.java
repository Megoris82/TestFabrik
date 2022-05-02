package it.fabrick.testFabrick.service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
	@JsonProperty("accountCode")
	private String accountCode;
	@JsonProperty("bicCode")
    private String bicCode;

}
