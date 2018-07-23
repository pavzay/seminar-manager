package com.github.pavzay.seminarmanager.auth.repository;

import com.github.pavzay.seminarmanager.auth.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
