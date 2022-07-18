package com.mindweaver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindweaver.model.Cart;
import com.mindweaver.model.User;

public interface CartRepository extends JpaRepository<Cart, Long>{

	List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
