package org.github.narendra.accounts_web_service.web;

import java.util.List;

import org.github.narendra.accounts_web_service.database.DatabaseSetup;
import org.github.narendra.accounts_web_service.domain.FrequentFlyerMember;
import org.github.narendra.accounts_web_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/accounts")
public class AccountsController {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private DatabaseSetup databaseSetup;
	
	@RequestMapping(method = RequestMethod.GET, value = "")
	public List<FrequentFlyerMember> listAllAccounts() {
		return accountRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reset")
	public void initializeAirports() {
		databaseSetup.initializeReferenceData();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{number}")
	public FrequentFlyerMember getAccount(@PathVariable String number) {
		return accountRepository.findByAccountNumber(number);
	}
}
