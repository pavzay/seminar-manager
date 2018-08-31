package com.github.pavzay.seminarmanager.auth.repository;

import com.github.pavzay.seminarmanager.auth.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, String> {
}
