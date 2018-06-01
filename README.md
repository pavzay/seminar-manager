# Seminar Manager

### Build project
`./gradlew clean build`


## Development
### Possible problems

Error **404** for **http://localhost:8080/** in the browser after launch **GatewayApplication** from IDE.

In **IntelliJ IDEA** open run configuration for **GatewayApplication** and set **$MODULE_DIR$** for **Working directory**

This problem reproduces only for multi modules projects, for single project Spring Boot see webapp folder correct when the application launched from IDE.
This problem is due to the fact that IDE set system property **user.dir** in root project path, but with **$MODULE_DIR$** in module path. 
