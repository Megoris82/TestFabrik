package it.fabrick.testFabrick.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class GenericApplicationProperties {
	
	@Value("${baseUrl}")
	private String baseUrl;
	@Value("${authSchema}")
	private String authSchema;
	@Value("${apiKey}")
	private String apiKey;
	public String getBaseUrl() {
		return baseUrl;
	}
	public String getAuthSchema() {
		return authSchema;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public void setAuthSchema(String authSchema) {
		this.authSchema = authSchema;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
}
