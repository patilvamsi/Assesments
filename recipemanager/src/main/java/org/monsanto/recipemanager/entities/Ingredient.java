package org.monsanto.recipemanager.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "INGREDIENT_MST")
public class Ingredient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6838450172177398089L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "I_ID")
	private int id;

	@Column(name = "I_NAME")
	private String name;

	@ManyToOne(optional=false)
	@JoinColumn(name = "R_ID")
	@JsonIgnore
	private Recipe recipe;

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

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}
