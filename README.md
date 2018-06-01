# Seminar Manager

### Build project
`./gradlew clean build`


## Development
### Possible problems

Problem: Error **404** for **http://localhost:8080/** in the browser after launch **GatewayApplication** from IDE.

Decision: In **IntelliJ IDEA** open run configuration for **GatewayApplication** and set **$MODULE_DIR$** for **Working directory**

Explanation: This problem reproduces only for multi modules projects when the one module launched from IDE. 
The problem is due to the fact that IDE set system property **user.dir** in root project path and Spring Boot application don't see webapp folder where the index.html file is.
But when working directory set in **$MODULE_DIR$** , **user.dir** contains the path of launched module and the application container loads webapp files. 
