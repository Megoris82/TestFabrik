package it.fabrik.testFabrik.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import it.fabrick.testFabrick.service.IBankAccountOperationService;
import it.fabrick.testFabrick.service.entity.Transaction;
import it.fabrick.testFabrick.service.response.BalanceDetail;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(
		  locations = "classpath:application.properties")
public class BankAccountOperationServiceTest {
	
	@Autowired
	IBankAccountOperationService accountOperationService;
	
	@Test
	public void getAccountBalance() {
		BalanceDetail balanceDetail =  accountOperationService.getAccountBalance(14537780L);
		assertTrue(balanceDetail != null);
	}
	
	@Test
	public void getListTransaction() {
		
		Date fromAccountingDate = null;
		Date toAccountingDate = null;
		try {
			fromAccountingDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-01");
			toAccountingDate=new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-04");
		} catch (ParseException e) {
			
		}
		List<Transaction> transaction =  accountOperationService.getTransactions(14537780L,fromAccountingDate,toAccountingDate);
		assertTrue(transaction != null && !transaction.isEmpty());
	}

}
