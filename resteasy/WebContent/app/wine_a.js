var app = angular.module('myApp', ['wineServices']);
//var app = angular.module('myApp', []);

app.controller('wineController',['$scope','Wine', function($scope, Wine){
	Wine.obter().get({}, function(result) {
		$scope.wines = result;
	});
	Wine.teste('String');
}]);

//app.controller('customersCtrl', function($scope, $http) {
//	$http.get("http://localhost:8080/resteasy/ooo/data/wine/user").success(
//			function(response) {
//				$scope.wines = response;
//			});
//});
