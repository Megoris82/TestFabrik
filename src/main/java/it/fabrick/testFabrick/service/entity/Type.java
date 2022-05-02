package it.fabrick.testFabrick.service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Type {
	@JsonProperty("enumeration")
	private String enumeration;
	@JsonProperty("value")
	private String value;

}
