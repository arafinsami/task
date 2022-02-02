package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entity.User;

public interface AppUserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	User findByPasswordRecoveryCode(String code);
}
