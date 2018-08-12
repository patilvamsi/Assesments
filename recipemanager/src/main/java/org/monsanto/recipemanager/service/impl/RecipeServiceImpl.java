package org.monsanto.recipemanager.service.impl;

import java.util.List;
import java.util.Optional;

import org.monsanto.recipemanager.entities.Ingredient;
import org.monsanto.recipemanager.entities.Recipe;
import org.monsanto.recipemanager.repository.RecipeRepository;
import org.monsanto.recipemanager.service.RecipeService;
import org.monsanto.recipemanager.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired(required = true)
	RecipeRepository rep;

	@Override
	@Transactional(rollbackFor = Exception.class, readOnly = false)
	public Recipe save(Recipe recipe) throws Exception {

		if (recipe.getIngredients().size() <= Constants.LOWER_LIMIT
				|| recipe.getIngredients().size() > Constants.HIGHER_LIMIT) {
			throw new Exception(Constants.INGRIDIENT_COUNT_EXCEPTION_STRING);
		}
		for (Ingredient in : recipe.getIngredients()) {
			in.setRecipe(recipe);
		}
		return rep.save(recipe);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, readOnly = false)
	public Recipe update(Recipe recipe) {
		return rep.save(recipe);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, readOnly = false)
	public Recipe delete(Recipe recipe) {
		return rep.save(recipe);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, readOnly = true)
	public List<Recipe> getAll() {
		return rep.findAll();
	}

	@Override
	@Transactional(rollbackFor = Exception.class, readOnly = true)
	public Optional<Recipe> getById(Integer id) {
		return rep.findById(id);
	}

}
