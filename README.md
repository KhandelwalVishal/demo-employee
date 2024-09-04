# Project Title

Sample Spring boot application to get and add employees of the organization. 

## Getting Started

Just download the code and start the application as spring boot app. The application has an in-memory database (H2) which gets 
auto configure while application start up.

After application start-up, you can see the database tables through console with below link:
http://localhost:8085/h2-console/login.jsp

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:dcbapp
User Name: sa
Password:password


In order to create new Employee through API endpoints, below is the sample Request Body:

{
    "empName":"Vishal",
    "address":"97 Morningside Drive",
    "dateOfBirth":"1994-09-02",
    "contactNumber": "6478038513",
    "title":"Developer",
    "sin":"12345678"
}
