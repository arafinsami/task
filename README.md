1. You should have MySQL Database, Database name: task, user:root, password:
2. First you should start eureka, than gateway and finally country-api service
3. Here I have user OpenJDK-17
4. Eureka path : http://localhost:8761/
5. To call country api service, just call through API Gateway as http://localhost:8888/country-app/swagger-ui/. Here I have added swagger ui.
6. In swagger, you can see Permission Data upload, and data is in task/data directory. So execute Permission Data Upload API and upload 
   data from task/data directory, here there is a xlsx file.
7. Then , you can see Setup Data API. After that you have to execute setup innitial data, just execute the API through Swagger UI.
8. After that you can see, Login Controller in Swagger UI. just click that, giving username and password as admin. A token will be generated. After getting token, on the uppler right corner, you can see a Authorize button, just click it and paste as: Bearer  token.
9. After that you will be able to search country by country name like BD, If you search BD it will give you as :

    {
      "data": {
                "countryName": "BD",
                "countryFullName": "Bangladesh",
                "population": 200000000,
                "currencies": [
                               {
                                 "id": 1,
                                 "currency": "Taka"
                               },
                               {
                                  "id": 2,
                                  "currency": "US Dollars"
                               }
                ]
      },
    "message": null,
    "errors": null,
    "status": "success"
   } 
   
10. Necessary screenshots is given task/data directory.
