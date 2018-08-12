var appController = angular.module('recipemenu');

appController.controller('ViewDetailsController',['$scope','$state','$stateParams','service','$rootScope','factory','predata',ViewDetailsController]);


function ViewDetailsController($scope,$state,$stateParams,service,$rootScope,factory,predata){
	if(predata.data == undefined || predata.data == ""){
		$state.go("home");
	}
	$scope.recipe = predata.data;
	
	$scope.addRecipe = function(){
		$scope.recipe.ingredients.push(factory.getIngredient());
	}
	$scope.delIngredient = function(ing){
		var x = $scope.recipe.ingredients.indexOf(ing);
		$scope.recipe.ingredients.splice(x,1);
	}
	$scope.delRecipe = function(ing){
		var x = angular.copy($scope.recipe);
		service.deleteRecipe(x).then(function(resp){
			alert('Deleted successfully');
			$rootScope.$broadcast('saved',resp);
			$state.go('home');
		},function(error){
			alert('Delete failed');
		});
	}
	$scope.update = function(){
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
		});
		if(flag){
			alert('Ingredient name cant be empty');
			return;
		}
		service.saveRecipe(x).then(function(resp){
			alert('Updated successfully');
			$rootScope.$broadcast('saved',resp);
			$state.go('home');
		},function(error){
			alert('update failed');
		});
	}
	
}