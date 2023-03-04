# Code en Running your SpringBoot Application

Run your application with class 'DemoApplication' class
Class 'Drink' contains the entities you're about to create
Interface 'RestRepository' is needed for any CRUD operations for the partical table!

# Properties

Property below means that this is a memory Database, you need to start your applicatin first!
spring.datasouce.url=jdbc:h2:mem:drinks

# Viewing JSON Data from browser

Navigate to url below and see your JSON data:
http://localhost:8080/drinks

Navigate to url below to CRUD your data from this url
http://localhost:8080/explorer/index.html#uri=/

# Remarks

One annotation is able to create an whole entire API '@RepositoryRestResource'


# TestCases

See class 'RestAssuredTests' for the restAssured tests
See class 'RestTemplateTests' for the restTemplate tests

# Used Libraries:

restTemplate
restAssured
mockMvc


# DevTools
brew install maven >> to install maven
set the right variables in your .bash_profile

# CommandLine from root directory
mvn spring-boot:run
mvn test

# PortCommands
lsof -n -i4TCP:8000 (portnumber)
kill -9 68453 (number is PID value from the list-command above)

