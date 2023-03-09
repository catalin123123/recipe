package com.catalin.rosu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalin.rosu.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {


	List<Recipe> findByNameContaining(String keyword);
	
	
	
}

