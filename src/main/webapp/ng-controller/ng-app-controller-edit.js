app.controller('ng-app-controller-edit', 
['$scope', '$http','$timeout', function ($scope,$http,$timeout)
  {
	 (function () 
		        {
		            
		            $http.post('/searchAll',{}) //nombre del controlador java
		            .then(function (response)
		            {
		                var data=response.data;
		                     
		               $scope.bbdd=data;

		            });       

		        })();
    
  }]);
  
  