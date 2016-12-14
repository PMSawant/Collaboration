var app=angular.module('myApp',['ngRoute'])
app.config(function($routeProvider){
	console.log('Entering in configuration')
	
	$routeProvider
	.when('/createPerson',{
		controller:'PersonController',
		templateUrl:'pages/createPerson.html'
	})
	.when('/listOfPersons',{
		controller:'PersonController',
		templateUrl:'pages/listOfPersons.html'
	})
	.when('/',{templateUrl:'pages/home.html'})
})