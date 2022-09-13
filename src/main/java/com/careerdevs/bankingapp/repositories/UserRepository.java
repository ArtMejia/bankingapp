package com.careerdevs.bankingapp.repositories;

import com.careerdevs.bankingapp.models.UserModel;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<UserModel, Long> {

}
