package it.fabrick.testFabrick.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.client.HttpStatusCodeException;

import it.fabrick.testFabrick.service.entity.Transaction;
import it.fabrick.testFabrick.service.request.MoneyTransferRequest;
import it.fabrick.testFabrick.service.response.BalanceDetail;
import it.fabrick.testFabrick.service.response.BalanceDetailResponse;
import it.fabrick.testFabrick.service.response.MoneyTransfer;

public interface IBankAccountOperationService {
	
	public BalanceDetail getAccountBalance(Long accountId) throws HttpStatusCodeException;
	public List<Transaction> getTransactions(Long accountId,Date fromAccountingDate,Date toAccountingDate) throws HttpStatusCodeException;
	public MoneyTransfer createMoneyTranfer(MoneyTransferRequest request,Long accountId) throws HttpStatusCodeException;
}
