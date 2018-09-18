[![Build Status](https://travis-ci.org/pavzay/seminar-manager.svg?branch=master)](https://travis-ci.org/pavzay/seminar-manager)

# Seminar Manager

### Build project
`./gradlew clean build`

### Run
`docker-compose up`

### Endpoints
- http://localhost:8761 - Eureka 
- http://localhost:8080 - UI
- http://localhost:8080/swagger-ui.html - Swagger UI
- http://localhost:8088/hystrix - Hystrix Dashboard
- http://localhost:8088/turbine.stream - Turbine Stream

## Development

1. Run **set_hostname.sh** under sudo user.
2. Change variables in **set_environment_variables.sh** file and run it under sudo user.

### Possible problems

Problem: Error **404** for **http://localhost:8080/** in the browser after launch **GatewayApplication** from IDE.

Decision: In **IntelliJ IDEA** open run configuration for **GatewayApplication** and set **$MODULE_DIR$** for **Working directory**

Explanation: This problem reproduces only for multi modules projects when the one module launched from IDE. 
The problem is due to the fact that IDE set system property **user.dir** in root project path and Spring Boot application don't see webapp folder where the index.html file is.
But when working directory set in **$MODULE_DIR$** , **user.dir** contains the path of launched module and the application container loads webapp files. 
