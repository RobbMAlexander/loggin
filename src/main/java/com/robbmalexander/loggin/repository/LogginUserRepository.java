package com.robbmalexander.loggin.repository;


import com.robbmalexander.loggin.model.LogginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogginUserRepository extends JpaRepository<LogginUser, Long> {
    LogginUser findByUsername(String username);
}
