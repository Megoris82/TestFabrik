package it.fabrick.testFabrick.service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
	@JsonProperty("address")
	private String address;
	@JsonProperty("city")
	private String city;
	@JsonProperty("countryCode")
	private String countryCode;

}
