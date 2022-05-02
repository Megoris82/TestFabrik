package it.fabrick.testFabrick.service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Creditor extends Debtor{
	@JsonProperty("address")
	private Address address;

}
