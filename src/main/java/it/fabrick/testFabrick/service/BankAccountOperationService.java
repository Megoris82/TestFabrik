package it.fabrick.testFabrick.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import it.fabrick.testFabrick.config.GenericApplicationProperties;
import it.fabrick.testFabrick.model.DBTransaction;
import it.fabrick.testFabrick.repository.TransactionRepository;
import it.fabrick.testFabrick.service.entity.Transaction;
import it.fabrick.testFabrick.service.request.MoneyTransferRequest;
import it.fabrick.testFabrick.service.response.BalanceDetail;
import it.fabrick.testFabrick.service.response.BalanceDetailResponse;
import it.fabrick.testFabrick.service.response.MoneyTransfer;
import it.fabrick.testFabrick.service.response.MoneyTransferResponse;
import it.fabrick.testFabrick.service.response.TransactionList;
import it.fabrick.testFabrick.service.response.TransactionListResponse;

@Service
public class BankAccountOperationService implements IBankAccountOperationService{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private GenericApplicationProperties applicationProperties;
	
	@Autowired
	private TransactionRepository repository;
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	private static final Logger logger = LoggerFactory.getLogger(BankAccountOperationService.class);
	
	@Override
	public BalanceDetail getAccountBalance(Long accountId) throws HttpStatusCodeException{
		BalanceDetail balanceDetailResponse = null;
		try {
			String urlAccountBalance = applicationProperties.getBaseUrl() + accountId + "/balance";
			HttpHeaders headers = getHeaders();
			HttpEntity<String> getAccountBalanceEntity = new HttpEntity<String>(headers);
			ResponseEntity<BalanceDetailResponse> accountResponse = restTemplate.exchange(urlAccountBalance, HttpMethod.GET,
					getAccountBalanceEntity, BalanceDetailResponse.class);
			balanceDetailResponse = accountResponse.getBody().getPayload();
		}catch (HttpStatusCodeException e) {
			logger.error("error during call balance {}", e.getResponseBodyAsString());
			throw e;
		}
		return balanceDetailResponse;
	}
	
	@Override
	public List<Transaction> getTransactions(Long accountId,Date fromAccountingDate,Date toAccountingDate) throws HttpStatusCodeException{
		List<Transaction> transactions = null;
		try {
			String urlListTransactions = applicationProperties.getBaseUrl() + accountId + "/transactions";
			HttpHeaders headers = getHeaders();
			String urlTemplate = UriComponentsBuilder.fromHttpUrl(urlListTransactions)
					.queryParam("fromAccountingDate", "{fromAccountingDate}")
					.queryParam("toAccountingDate", "{toAccountingDate}")
					.encode().toUriString();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Map<String, String> params = new HashMap<>();
			params.put("fromAccountingDate", df.format(fromAccountingDate));
			params.put("toAccountingDate", df.format(toAccountingDate));
			HttpEntity<String> getTransactionListEntity = new HttpEntity<String>(headers);
			ResponseEntity<TransactionListResponse> accountResponse = restTemplate.exchange(urlTemplate, HttpMethod.GET,
					getTransactionListEntity, TransactionListResponse.class,params);
			transactions = accountResponse.getBody().getPayload().getList();
		}catch (HttpStatusCodeException e) {
			logger.error("error during call transactions {}", e.getResponseBodyAsString());
			throw e;
		}
		if(transactions != null) {
			for(Transaction transaction : transactions) {
				if(!repository.existsById(transaction.getTransactionId())) {
					DBTransaction dbTransaction = modelMapper.map(transaction,DBTransaction.class);
					repository.save(dbTransaction);
				}
			}
		}
		
		return transactions;
	}
	@Override
	public MoneyTransfer createMoneyTranfer(MoneyTransferRequest request,Long accountId) throws HttpStatusCodeException {
		MoneyTransfer moneyTranserResponse = null;
		try {
			String urlMoneyTransfer = applicationProperties.getBaseUrl() + accountId + "/payments/money-transfers";
			HttpHeaders headers = getHeaders();
			HttpEntity<MoneyTransferRequest> moneyTransferEntity = new HttpEntity<MoneyTransferRequest>(request,headers);
			ResponseEntity<MoneyTransferResponse> moneyTranferResponse = restTemplate.exchange(urlMoneyTransfer, HttpMethod.POST,
					moneyTransferEntity, MoneyTransferResponse.class);
			moneyTranserResponse = moneyTranferResponse.getBody().getPayload();
		}catch (HttpStatusCodeException e) {
			logger.error("error during call money-transfers {}", e.getResponseBodyAsString());
			throw e;
		}
		return moneyTranserResponse;
		
	}
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Auth-Schema", applicationProperties.getAuthSchema());
		headers.add("Api-Key", applicationProperties.getApiKey());
		return headers;
	}
	
}
