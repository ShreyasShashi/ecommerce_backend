package com.mindweaver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindweaver.model.User;
import com.mindweaver.model.WishList;

@Repository
public interface WishListRepo extends JpaRepository<WishList, Long>{
	
	List<WishList>findAllByUserOrderByCreatedDateDesc(User user);

}
