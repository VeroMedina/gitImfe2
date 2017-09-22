app.controller('ng-app-controller-edit', 
['$scope', '$http','$timeout', function ($scope,$http,$timeout)
  {
    /**************************************************************************
     * 
     * CONFIG
     * 
     **************************************************************************/
	 var contSelect = document.querySelector('#contSelect');
	 var data = null;

    /**************************************************************************
     * 
     * INI
     * 
     **************************************************************************/
	 (function () 
    {
       
        $http.post('/test',{}) //nombre del controlador java
        
        .then(function (response)
        {
           data = response.data;
                 
           $scope.bbdd=data; //Envia todos los datos

        });       

    })();


    /**************************************************************************
     * 
     * FUNCTIONS MODEL
     * 
     **************************************************************************/
     $scope.getDataTable = function ()
     {
  	   console.log(contSelect.value);
  	   
       $http.post('/geteditable',
       {
    	   table : contSelect.value //Capturamos el valor del option del select (nombre de la tabla)
       }) 
       .then(function (response)
       {
          data = response.data;
          console.log(JSON.stringify(data));      
          $scope.gettable = data; //Envia al html todos los datos de la tabla indicada
          

       }); 
     };
     
     /**
      * Boton enviar
      */
     $scope.send = function ()
     {
  	   console.log(contSelect.value);
  	   
       $http.post('/geteditable',
       {
    	   table : contSelect.value //Capturamos el valor del option del select (nombre de la tabla)
       }) 
       .then(function (response)
       {
          data = response.data;
          console.log(JSON.stringify(data));      
          $scope.gettable = data; //Envia al html todos los datos de la tabla indicada
          

       }); 
     };


    /**************************************************************************
     * 
     * PRIVATE FUNCTIONS
     * 
     **************************************************************************/
	
	
	
	
	

	 
	 
	 
     

	 
	 
    
  }]);
  
  