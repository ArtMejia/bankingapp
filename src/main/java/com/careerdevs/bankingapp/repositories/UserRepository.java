package com.careerdevs.bankingapp.repositories;

import com.careerdevs.bankingapp.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
