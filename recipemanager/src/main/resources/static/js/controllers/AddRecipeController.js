var appController = angular.module('recipemenu');

appController.controller('SaveController',['$scope','$state','factory','service','$rootScope',SaveController]);


function SaveController($scope,$state,factory,service,$rootScope){
	
	$scope.recipe = factory.getRecipe();
	
	$scope.addRecipe = function(){
		$scope.recipe.ingredients.push(angular.copy(factory.getIngredient()));
	}
	
	$scope.delRecipe = function(ing){
		var x = $scope.recipe.ingredients.indexOf(ing);
		$scope.recipe.ingredients.splice(x,1);
	}
	
	$scope.save = function(){
		var x = angular.copy($scope.recipe);
		if(x.name == undefined || x.name == ""){
			alert('Recipe name cant be empty');
			return;
		}
		if(x.ingredients.length == 0){
			alert('Atleast add one Ingredient');
			return;
		}else if(x.ingredients.length > 4){
			alert('Cant add ingredients more than 4');
			return;
		}
		var flag = false;
		angular.forEach(x.ingredients,function(item){
			if(item.name == undefined || item.name == ""){
				flag=true;
				return;
			}
			item.id = undefined;
		});
		if(flag){
			alert('Ingredient name cant be empty');
			return;
		}
		x.id = undefined;
		service.saveRecipe(x).then(function(resp){
			alert('saved successfully');
			$rootScope.$broadcast('saved',resp);
			$scope.recipe = factory.getRecipe();
			$scope.recipe.ingredients = [];
			$scope.recipe.ingredients.push(factory.getIngredient());
		},function(error){
			alert('save failed');
		});
	}
	
}