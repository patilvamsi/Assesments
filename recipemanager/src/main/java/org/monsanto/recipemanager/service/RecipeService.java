package org.monsanto.recipemanager.service;

import java.util.List;
import java.util.Optional;

import org.monsanto.recipemanager.entities.Recipe;

public interface RecipeService {
	
	
	
	public Recipe save(Recipe recipe) throws Exception;

	public Recipe update(Recipe recipe);

	public Recipe delete(Recipe recipe);

	public List<Recipe> getAll();

	public Optional<Recipe> getById(Integer id);

}
