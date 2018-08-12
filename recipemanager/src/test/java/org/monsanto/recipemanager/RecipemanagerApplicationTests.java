package org.monsanto.recipemanager;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.monsanto.recipemanager.entities.Recipe;
import org.monsanto.recipemanager.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase
public class RecipemanagerApplicationTests {

	@Autowired(required = true)
	RecipeRepository rep;

	@Test
	public void contextLoads() {
	}

	@Test
	public void checkGetAll() {
		List<Recipe> recipies = rep.findAll();
		Assert.assertFalse("Data is not retriving", recipies.isEmpty());
		Assert.assertNotNull("Provided List is null;", recipies);
	}
	
	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
	    int id = 1;
	    Optional<Recipe> found = rep.findById(id);
	    Assert.assertTrue("Data is not retriving", found.isPresent());
	 }

}
