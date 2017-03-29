package org.github.narendra.accounts_web_service.repository;

import org.github.narendra.accounts_web_service.domain.FrequentFlyerMember;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends MongoRepository<FrequentFlyerMember, String> {
	FrequentFlyerMember findByAccountNumber(String number);
}
