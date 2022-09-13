package com.careerdevs.bankingapp.repositories;

import com.careerdevs.bankingapp.models.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {

}
