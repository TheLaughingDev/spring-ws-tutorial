# spring-ws-tutorial
A spring-ws tutorial using Kotlin. Based on the
[this](https://spring.io/guides/gs/producing-web-service) Spring-WS tutorial.

I created this project to get a better understanding of building SOAP web services using Spring WS.

# Structure
* build.gradle: Main gradle build file.
* server: Builds the web services server as a spring boot application.
	* src/main/resources
		* countries.xsd: Defines the SOAP resquests, responses, and data.
		* data.sql: SQL file for creating rows in the H2 database.
* wsdl: Converts the countries.xsd into Java objects.

# Execution
To run the project from the home directory:

```bash
./gradlew build
./gradlew :server:bootrun
```
