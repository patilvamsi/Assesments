var AppService = angular.module('recipemenu');

AppService.service("service",['processRequestService', service]);
AppService.service('processRequestService', ['$http', processRequestService]);

function endPoints(){
		this.save = "/save";
		this.getall = "/getall";
		this.deleteRecipe ="/delete"
		this.getRecipe ="/get/"
}
var endPoint = new endPoints();

function processRequestService($http){

	this.processAsyncRequest = function(apiContextName, endPointName, request ){
		
	}
	
	this.processSyncRequest = function(apiContextName, endPointName, request ){
			
	}

	this.processSimpleGetRequest = function(endPointName, request ){
		return $http.get( endPointName , JSON.stringify(request));
	}
	
	this.processSimplePostRequest = function(endPointName, request ){
		return $http.post( endPointName , JSON.stringify(request));
	}
	
	return this;
	
}
function service(req){
	
	this.saveRecipe = function(recipe){
		return req.processSimplePostRequest(endPoint.save,recipe);
	}
	this.deleteRecipe = function(recipe){
		return req.processSimplePostRequest(endPoint.deleteRecipe,recipe);
	}
	this.getRecipes = function(recipe){
		return req.processSimpleGetRequest(endPoint.getall);
	}
	this.getRecipe = function(id){
		return req.processSimpleGetRequest(endPoint.getRecipe+""+id);
	}
	return this;
}
