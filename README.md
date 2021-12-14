The task is to build a simple application that will contain all the common layers, used in the
backend. It should provide rest endpoints for consumers and connect to a database to store the
data. The app should be built with plain Java frameworks and technologies
Preconditions
- Set up any standalone Database engine (H2 - the simplest option, Postgres, MySql)
- Be able to connect to it through any interface (browser, workbench, datagrip,
  terminal etc)
- Create new Database and User, grant this user all permissions to work with
  Database
- Obtain credentials (url, username, password) to connect your app to DB
- Create a simple table User with next columns:
- id (Number, PK)
- name (text, 255 chars)
- email (Unique constraint, text)
- Setup Postman (prefered) or any other tool to make REST requests
- GET localhost:8080/user/{id} - to fetch user
- POST localhost:8080/user {JSON payload} - to create user
- GET localhost:8080/user/search?{params} - so search users
  Build an App
  Servlets
  This layer will be responsible for interaction with outer world and will serve the API of our service
- accept POST with JSON of user information and return an ID of created user
- return 400 if payload is invalid
- accept GET with ID of user and return JSON of found user
- return 404 if user not found
- return 400 if ID is not valid
- accept GET /search with params and return a list of JSON objects that matched request
- return 404 if user not found
- return 400 if params are not valid
- return 500 with meaningful error message in case of ANY unhandled exception
  Service
  This layer will handle custom business logic
- Will be a Singletone - only one instance is available throughout all application
- Operates with User Data Transfer Object with next fields:
- id
- name
- email
- Implements interface with next methods:
- UserDTO getUserById(Long id)
- Long createUser(UserDTO data)
  Repository
  Responsible for database operations
- Will be a Singletone - only one instance is available throughout all application
- Operates with User Entity object with next fields
- id
- name
- email
- Can connect to a Database through any ConnectionPool
- Can do next operations
- Create user from provided params
- Fetch user from DB by ID
- Search user by arbitrary params
  Tests
- Write Unit tests for each component using JUnit, Mockito
- Write full integration test that will set up in-memory DB (or use DBUnit), populate it with test
  data, build all the chain of services of our app and make a request to Servlet API
  Dev Notes
- Use Jackson Object Mapper to translate incoming JSON to Objects and vise-versa
- Make a Validator interface and implementation that will be responsible for validation of input
  params
- Make a Converter static class that can convert UserEntity into UserDTO and back
- Use plain JDBC to connect to a database
- Use Maven to build a project, that connects to DB and listens to port 8080 on localhost
- You can try both approaches:
- make a WAR and deploy it manually in Tomcat
- make it an executable JAR with embedded Web Container (Tomcat)