package com.mindweaver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindweaver.model.AuthenticationToken;
import com.mindweaver.model.User;

@Repository
public interface TokenRepo extends JpaRepository<AuthenticationToken, Long> {

	AuthenticationToken findByUser(User user);

	AuthenticationToken findByToken(String token);
}
