var app=angular.module('myApp',['ngRoute'])
app.config(function($routeProvider){
	console.log('Entering in configuration')
	
	$routeProvider
	.when('/',{templateUrl:'pages/index.html'})
})
	.when('/createPerson',{
		controller:'PersonController',
		templateUrl:'pages/createPerson.html'
	})
	.when('/listOfPersons',{
		controller:'PersonController',
		templateUrl:'pages/listOfPersons.html'
	})
