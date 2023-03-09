package com.catalin.rosu.controller;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.catalin.rosu.entity.Recipe;
import com.catalin.rosu.repository.RecipeRepository;

@RestController
@RequiredArgsConstructor
public class Controller {

	@Autowired
	private RecipeRepository recipeRepository;


	@PostMapping("/recipes")
	public void addRecipe(@RequestBody Recipe recipe) {
	    recipeRepository.save(recipe);
	}

	@PutMapping("/recipes")
	public void updateRecipe(@RequestBody Recipe recipe) {
	    recipeRepository.save(recipe);
	}

	@DeleteMapping("/recipes")
	public void deleteRecipe(@RequestParam String id) {
	    recipeRepository.deleteById(Integer.valueOf(id));
	}

	@GetMapping(path="/recipes", produces = "application/json")
	public List<Recipe> getEmployees() {
		return recipeRepository.findAll();
	}

	@GetMapping("/recipe/{id}")
	public ResponseEntity<Recipe> getReceipt(@PathVariable("id") Integer receipeId) {
		Recipe recipe = recipeRepository.getById(receipeId);
		return ResponseEntity.ok().body(recipe);
	}

	@GetMapping("/recipes")
	public List<Recipe> getRecipes(@RequestParam(required = false) String filter) {
	    if (filter == null) {
	        return recipeRepository.findAll();
	    }
		return null;   //todo: return filtered results
	}

    @GetMapping("/recipes/search")
    public List<Recipe> searchRecipes(@RequestParam(required = false) String keyword) {
      if (keyword != null) {
            return recipeRepository.findByNameContaining(keyword);
        } else {
            return recipeRepository.findAll();
        }

    }

    
    

}

