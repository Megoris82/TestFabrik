package it.fabrick.testFabrick.config;


import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@PropertySource(value = {"classpath:http_clients.properties"})
@Configuration
public class RestTemplateConfig {

    private static final Logger logger = LoggerFactory.getLogger(RestTemplateConfig.class);

    @Value("${generic.http.client.connection.manager.max.total}")
    private int generichttpClientConnManagerMaxTotal;

    @Value("${generic.http.client.connection.manager.max.per.route}")
    private int generichttpClientConnManagerMaxPerRoute;

	@Bean
	public RestTemplate getRestTemplate() {
		   
		RestTemplate restTemplate = new RestTemplate();
		try {
			restTemplate = new RestTemplate(clientHttpRequestFactory());
		} catch (Exception e) {
			logger.error("Exception occured while creating restTemplate " + e);
			e.printStackTrace();
		}
		return restTemplate;
	}

	@Bean
    public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() throws Exception {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setHttpClient(createHttpClient());
        return clientHttpRequestFactory;
    }


	@Bean
	public CloseableHttpClient createHttpClient() throws Exception {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(generichttpClientConnManagerMaxTotal);
        connectionManager.setDefaultMaxPerRoute(generichttpClientConnManagerMaxPerRoute);
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        return httpClient;
    } 

}
