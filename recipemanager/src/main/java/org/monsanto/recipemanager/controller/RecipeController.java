package org.monsanto.recipemanager.controller;

import java.util.List;
import java.util.Optional;

import org.monsanto.recipemanager.entities.Recipe;
import org.monsanto.recipemanager.service.impl.RecipeServiceImpl;
import org.monsanto.recipemanager.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class RecipeController {

	@Autowired
	RecipeServiceImpl service;

	@RequestMapping(value = Constants.SAVE_RECIPE, method = RequestMethod.POST,produces="application/json")
	@ResponseBody
	public Recipe saveRecipe(@RequestBody Recipe recipe) throws Exception {
		return service.save(recipe);
	}

	@RequestMapping(value = Constants.GET_ALL_RECIPIES, method = RequestMethod.GET)
	@ResponseBody
	public List<Recipe> getAllRecipe() throws JsonProcessingException {
		return service.getAll();
	}

	@RequestMapping(value = Constants.GET_RECIPE_BY_ID, method = RequestMethod.GET)
	@ResponseBody
	public Optional<Recipe> getAllRecipe(@PathVariable int id) throws JsonProcessingException {
		return service.getById(id);
	}
	
	@RequestMapping(value = Constants.DELETE_RECIPE, method = RequestMethod.GET)
	@ResponseBody
	public Recipe deleteRecipe(@RequestBody Recipe recipe) throws JsonProcessingException {
		return service.delete(recipe);
	}

}
