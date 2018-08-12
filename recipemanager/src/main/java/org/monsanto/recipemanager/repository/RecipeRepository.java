package org.monsanto.recipemanager.repository;

import org.monsanto.recipemanager.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer> {

}
