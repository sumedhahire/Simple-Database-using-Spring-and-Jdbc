This is a web application built with Spring Boot and Thymeleaf that allows users to upload files to an H2 database, and then view, download, and delete those files. User access is authenticated, and custom login, logout, and error pages are included.
Features

    -Upload files to an H2 database using a form
    -View a preview of uploaded files
    -Download uploaded files by ID
    -Delete uploaded files by ID
    -Authenticate user access with custom login page
    -Show error message on login failure
    -Custom logout page

Requirements

    -Java 11 or higher
    -Maven 3.6 or higher

Installation

    1)Clone the repository:
	git clone https://github.com/darkone03/Simple-Database-using-Spring-and-Jdbc.git

    2)Navigate to the project:
	cd Simple-Database-using-Spring-and-Jdbc

    3)Build the project using maven:		
	mvn clean install

     4)Run the project:	
	mvn spring-boot:run
	
     5)open your web brower:
	http://localhost:8080/


Usage
    -to access the application authenticate yourself,username="user" and password="password"
    -If login fails, an error message will be displayed on the login page.
    -On the upload page, click the "browse" button to select a file to upload. Then click the "Upload" button to upload the file to the database.
    -The id, content type,and name of the uploaded file will be displayed on the file page, along with a preview of the file.
    -To download a file, click the "Download" button below the file.
    -To delete a file, enter the file's ID into the "Delete" form and click the "Delete" button.
    -To log out, click the "Logout" in the navigation bar.
    -There is an easter egg if you are able to find it
Configuration

The application can be configured using the following properties:

    spring.datasource.url: the URL of the H2 database
    spring.datasource.username: the username for the H2 database
    spring.datasource.password: the password for the H2 database
    spring.jpa.hibernate.ddl-auto: the Hibernate DDL mode (e.g. update, create, none)
    spring.jpa.properties.hibernate.dialect: the Hibernate dialect for the database
    spring.security.user.name: the default username for the application
    spring.security.user.password: the default password for the application

License

This project is licensed under the MIT License - see the LICENSE file for details.