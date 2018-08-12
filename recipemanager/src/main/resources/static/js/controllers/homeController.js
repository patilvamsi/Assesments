var appController = angular.module('recipemenu');

appController.controller('HomeController',['$scope','$state','service','predata',HomeController]);


function HomeController($scope,$state,service,predata){
	
	/*service.getRecipes().then(function(resp){
		
	},function(){
		
	});*/
	$scope.recipies = predata.data;
	
	$scope.$on('saved',function(){
		service.getRecipes().then(function(resp){
			$scope.recipies = resp.data;
		},function(){
			
		});
	});
	
	
	$scope.addRecipe = function(){
		$state.go("home.save");
	}
	
	$scope.showRecipe = function(reci){
		var data = angular.copy(reci);
		$state.go("home.details",{recipe:data});
		$scope.recipe = undefined;
	}
	
	
}