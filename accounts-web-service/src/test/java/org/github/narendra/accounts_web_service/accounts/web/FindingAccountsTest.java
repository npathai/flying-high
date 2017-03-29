package org.github.narendra.accounts_web_service.accounts.web;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.github.narendra.accounts_web_service.AccountsApp;
import org.github.narendra.accounts_web_service.domain.FrequentFlyerMember;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = AccountsApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class FindingAccountsTest {
	private static final FrequentFlyerMember sarah = new FrequentFlyerMember("123456", "Sarah", "Edwards", "SYD");

	private RestTemplate rest = new RestTemplate();
	
	@Value("${local.server.port}")
	private int port;

	private String baseUrl;
	
	@Before
	public void configureBaseUrl() {
		baseUrl = "http://localhost:" + port;
		rest.getForObject(baseUrl + "/rest/api/accounts/reset", Void.class);
	}
	
	@Test
	public void listsAllAccounts() {
		ResponseEntity<List<FrequentFlyerMember>> safeAccounts = rest.exchange(baseUrl + "/rest/api/accounts",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<FrequentFlyerMember>>(){}
		);
		Assert.assertFalse(safeAccounts.getBody().isEmpty());
		Assert.assertThat(safeAccounts.getBody().size(), is(equalTo(1)));
	}
	
	@Test
	public void listsAnAccountByAccountNumber() {
		ResponseEntity<FrequentFlyerMember> account = rest.getForEntity(baseUrl + "/rest/api/accounts/123456", FrequentFlyerMember.class);
		
		Assert.assertNotNull(account.getBody());
		Assert.assertThat(account.getBody(), is(equalTo(sarah)));
	}
}
