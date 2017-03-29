package org.github.narendra.accounts_web_service.database;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.github.narendra.accounts_web_service.domain.FrequentFlyerMember;
import org.github.narendra.accounts_web_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSetupImpl implements DatabaseSetup {

	private final static FrequentFlyerMember sarah = new FrequentFlyerMember("123456",
			"Sarah", "Edwards", "SYD");

	private final static List<FrequentFlyerMember> DEFAULT_ACCOUNTS = Collections.unmodifiableList(Arrays.asList(
			sarah
	));

	@Autowired
	private AccountRepository accountRepository;
	
	public void initializeReferenceData() {
		accountRepository.deleteAll();
		accountRepository.insert(DEFAULT_ACCOUNTS);
	}
}
