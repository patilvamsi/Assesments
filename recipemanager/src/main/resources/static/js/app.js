var app = angular.module('recipemenu', ['ui.router','ngMaterial' ]);


app.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('');

    $stateProvider
        .state('home', {
            url: '',
            templateUrl: 'welcome',
            controller : 'HomeController',
            resolve:{
	        	predata : function(service){
	        		return service.getRecipes();
	        	}
	        }
        }).state('home.save', {
            url: '/addRecipe',
            templateUrl: 'add.html',
            controller:"SaveController"
        }).state('home.details', {
            url: '/viewRecipe',
            templateUrl: 'view.html',
            controller : "ViewDetailsController",
            params : {
	        	recipe : undefined
	        },
	        resolve:{
	        	predata : function(service,$stateParams){
	        		if($stateParams.recipe == undefined)
	        			return {};
	        		else
	        		return service.getRecipe($stateParams.recipe.id);
	        	}
	        }
        });
        
        
});
