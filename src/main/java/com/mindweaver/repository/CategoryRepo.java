package com.mindweaver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindweaver.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{

	void save(Optional<Category> updateCategory);

}
