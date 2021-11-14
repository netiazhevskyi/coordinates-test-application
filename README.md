It is a java application based on Spring Boot framework, it allows connection to third party API 
and users are able to search by address and get all addresses by coordinates. 
The result is printed in JSON format.

- Application implements N-tier architecture and consists of DAO, service and controllers layers.
- it implements Authorization/Authentication procedures for result endpoints.
This application has 2 endpoints:
- "/search" endpoint allows to save and return coordinates entered in the request. 
You must enter your request in the following format: 
"localhost:8080/search?format=json&housenumber=<ENTER HOUSER NUMBER>&streetname=<ENTER STREET>&city=<ENTER CITY>"
Example: search?format=json&housenumber=218&streetname=Piccadilly Circus&city=london"
- "/addresses" will return address related to previously entered coordinates.
