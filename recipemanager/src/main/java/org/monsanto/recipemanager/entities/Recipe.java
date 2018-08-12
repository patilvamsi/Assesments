package org.monsanto.recipemanager.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RECIPE_MST")
public class Recipe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6411596212962421365L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "R_ID")
	private int id;

	@Column(name = "R_NAME")
	private String name;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Ingredient> ingredients;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void addIngredients(Ingredient ingredient) {
		this.ingredients.add(ingredient);
		ingredient.setRecipe(this);
	}
}
