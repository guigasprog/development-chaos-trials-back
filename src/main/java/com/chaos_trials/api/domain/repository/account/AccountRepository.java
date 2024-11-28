package com.chaos_trials.api.domain.repository.account;

import com.chaos_trials.api.domain.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("SELECT a FROM Account a WHERE a.email = :login OR a.username = :login")
    Optional<Account> findFirstByEmailOrUsername(@Param("login") String login);

    Optional<Account> findFirstByEmailOrUsername(String email, String username);

}
