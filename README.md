## Run
1. Execute ```mvn clean package```
2. Then ```java -jar 'deposit-management-0.0.1-SNAPSHOT.jar'```
3. Locate **http://localhost:8080/** for project main page.

## Run from IDEA
1. In order to compile project from IDEA, please install **Lombok** plugin.
2. Execute DmRunner's main method in order to start application.
3. Locate **http://localhost:8080/** for project main page.

When application has been started, you can observe in logs something like this:
>: Started DmRunner in 9.045 seconds (JVM running for 9.71)

## Technology stack
1. Java8 - I use v 1.8.0_40
2. Based on spring-boot v 1.3.2
3. Spring framework v 4.2.4
4. Hibernate v 4.3.11
5. Embedded tomcat v 8.0.30
6. In-memory rational db h2 v 1.4
7. Thymeleaf template engine, bootstrap3 and jquery
8. and so on

## Project overview
- *DmRunner* - application launcher
- *data.sql* - initial database data
- *application.properties* - default project settings
- *ru.spb.yarish.dm.config* - spring contexts
- *resources/templates/layout.html* - base template