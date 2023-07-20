## Problem Statement: Enable Centralized Configuration using Configuration Server

* In this exercise, you will externalize the  properties of a  project codebase to a centralized configuration server. The application contains two Spring Boot applications:
  - blog-service – A Spring Boot based microservice which exposes URLs to enable CRUD functionality. 
  - config-service– A Spring cloud centralized Config Server.

To solve the problem, you need to complete the following steps:

**Note**: Classes provided in this exercise will show compilation errors when the exercise is cloned locally.
You need to go through the comments thoroughly and complete the application.
  
        1. Add the required dependency to enable Config Server in pom.xml.
        2. Add annotation to make the config-server act like Spring Config Server. 
        3. Create a local git repository and add the properties for whatever database you are choosing with the name of Config Client such as blog-service.properties.
        4. Add properties in application.properties to fetch the properties from the Git repository.
        5. Test in Postman to see if you can access the Blog service.

  
### Instructions
 - Take care of whitespace/trailing whitespace
 - Do not change the provided class/method names unless instructed
 - Ensure your code compiles without any errors/warning/deprecations 
 - Follow best practices while coding
 
 
 




 
 



