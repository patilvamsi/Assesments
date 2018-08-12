var appFactory = angular.module('recipemenu');

appFactory.factory("factory", factory);

function factory() {

	var recipe = {
		name : "",
		ingredients : []
	};

	var ingredient = {
		name : ""
	}

	this.getRecipe = function() {
		var r = angular.copy(recipe);
		r.ingredients.push(angular.copy(ingredient));
		return r;
	}
	this.getIngredient = function() {
		return angular.copy(ingredient);
	}
	return this;
}