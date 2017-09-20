app.controller('ng-app-controller-edit', 
['$scope', '$http','$timeout', function ($scope,$http,$timeout)
  {
	 (function () 
		        {
		            
		            $http.post('/test',{}) //nombre del controlador java
		            .then(function (response)
		            {
		                var data=response.data;
		                     
		               $scope.bbdd=data;
		               
		               $scope.count = function ()
		               {
		            	   var contador = data.length;
		            	   $scope.c = contador;
		            	   console.log(contador);
		               };
		               
		               
		               
		               

		            });       

		        })();
	 
	 
	 
	 
    
  }]);
  
  