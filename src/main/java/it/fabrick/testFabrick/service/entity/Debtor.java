package it.fabrick.testFabrick.service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Debtor {
	@JsonProperty("name")
	private String name;
	@JsonProperty("account")
	private Account account;

}
