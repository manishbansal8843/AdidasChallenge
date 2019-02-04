# About the repository

This repository contains the source code for a spring-boot microservices application. 

# Problem statement

This application provides a service that given an origin city will return a list of itineraries , one based in the less number of  connections and the second based in the less time. 
For that, couple of microservices have been implemented:

1. CityAPI microservice exposes the data related with a city defined with : city, destiny city, departure time, arrival time,  stored in a data base .
2. CityPathAnalyser microservice implements a Restful service that consumes the CityAPI service in order to calculate the shortest way( in time and in  connections ) to travel from one city to another , independent of the departure time .

# Endpoints

All apis can be accessed via zuul server. Below are the various end-points.

1. To access CityAPI micro-service: http://localhost:9999/CityAPI/api/getDetinationCities/{city_name}

2. To access CityAPI swagger end-point: http://localhost:9999/CityAPI/swagger-ui.html

3. To access CityPathAnalyser micro-service: http://localhost:9999/CityPathAnalyser/swagger-ui.html

4. To access CityPathAnalyser swagger end-point: http://localhost:9999/CityPathAnalyser/getRoutes/{source}/{destination}

5. To access Eureka dashboard: http://localhost:2222

# Config server repository

Configurations of the application are present in a separate repository. Same can be referred from [here](https://github.com/manishbansal8843/adidas-challenge-config).

# Components of the application

This application is built using spring-cloud. It consists of 2 microservices i.e. CityAPI and CityPathAnalyser.

Further, both these APIs have been protected using basic spring security api.

As an API gateway, netflix-zuul is used which further uses other netflis-oss components for making this application as cloud-native. Below are their details.

a. Hystrix: is used for implementing cicuit breaker pattern.
b. Eureka : is used for service discovery.
c. Ribbon : is used for load balancing.

# Steps to run

First, start a mySql server. Also, enable the root user with password 'manish12345'. Or if you already have this user with different password, follow below procedure.

1. Fork the application config repository.
2. change the spring.datasource.password property in CityAPI.properties.
3. Update the config repository url in bootstrap.properties of all the micro-services.

Further, to set-up the DB, execute Data.sql. Once, DB is setup, follow below procedure.

1. Clone the repository.
2. Open STS and go to File > Import > Existing maven projects.
3. Point the root directory to your cloned repository and import all the projects.
4. Start the config server by overriding one property as spring.profiles.active=adidas. same will get up on 1111 port.
5. Start Eureka server. Same will get up on 2222 port.
6. Start the CityAPI service. Same will get up on random port.
7. Start the CityPathAnalyser service. Same will get up on random port.
8. Start the zuul server. Same will gte up on 9999 port.

After this, Endpoints can be accessed using browser as well as postman.
For accessing enpoints, basic in-memory authentication is enabled with below credentials.

Username = adidas
Password = adidas