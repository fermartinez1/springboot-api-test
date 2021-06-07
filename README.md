## **Springboot test API**

OpenAPI available
http://localhost:8080/api/swagger-ui/

H2 DB console
http://localhost:8080/api/h2-console

Jacoco report available
`api-test\target\site\jacoco`

Run application command line
`mvn spring-boot:run`

Run application
`RUN ApiTestApplication`

Curl example
`curl -X GET "http://localhost:8080/api/prices?date=2020-06-14T09%3A23%3A15.089Z&productId=35455&brandId=1" -H "accept: */*"`

