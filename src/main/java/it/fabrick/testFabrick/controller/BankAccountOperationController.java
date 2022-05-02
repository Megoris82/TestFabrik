package it.fabrick.testFabrick.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import it.fabrick.testFabrick.service.IBankAccountOperationService;
import it.fabrick.testFabrick.service.entity.Transaction;
import it.fabrick.testFabrick.service.request.MoneyTransferRequest;
import it.fabrick.testFabrick.service.response.BalanceDetail;
import it.fabrick.testFabrick.service.response.BalanceDetailResponse;
import it.fabrick.testFabrick.service.response.MoneyTransfer;

@RestController
@RequestMapping("/api")
public class BankAccountOperationController {
	
	@Autowired
	private IBankAccountOperationService accountOperationService;
	
	@RequestMapping(value = "/balance/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<BalanceDetail> getBalanceDetail(@PathVariable("accountId") Long accountId){
		
		ResponseEntity<BalanceDetail> response = null;
		BalanceDetail balanceDetailResponse = null;
		try {
			balanceDetailResponse = accountOperationService.getAccountBalance(accountId);
			response = new ResponseEntity<>(balanceDetailResponse,HttpStatus.OK);
		} catch (HttpStatusCodeException e) {
			response = new ResponseEntity<>(balanceDetailResponse,e.getStatusCode());
		}
		
		return response;

		
	}
	
	@RequestMapping(value = "/transactions/{accountId}/{fromAccountingDate}/{toAccountingDate}", method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> getTransactions(@PathVariable("accountId") Long accountId,
			@PathVariable("fromAccountingDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromAccountingDate,
			@PathVariable("toAccountingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toAccountingDate ){
		
		ResponseEntity<List<Transaction>> response = null;
		List<Transaction> transactions = null;
		try {
			transactions = accountOperationService.getTransactions(accountId,fromAccountingDate,toAccountingDate);
			response = new ResponseEntity<>(transactions,HttpStatus.OK);
		} catch (HttpStatusCodeException e) {
			response =  new ResponseEntity<>(transactions,e.getStatusCode());
		}
		
		return response;
	}
	
	@RequestMapping(value = "/money-transfers/{accountId}", method = RequestMethod.POST,consumes = "application/json")
	public ResponseEntity<MoneyTransfer> createMoneyTransfer(@RequestBody MoneyTransferRequest request,@PathVariable("accountId") Long accountId){
		ResponseEntity<MoneyTransfer> response = null;
		MoneyTransfer moneyTransfer = null;
		try {
			moneyTransfer = accountOperationService.createMoneyTranfer(request, accountId);
			response = new ResponseEntity<>(moneyTransfer,HttpStatus.OK);
		} catch (HttpStatusCodeException e) {
			response = new ResponseEntity<>(moneyTransfer,e.getStatusCode());
		}
		
		return response;
		
	}
	

}
