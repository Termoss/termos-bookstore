# BookStore
The REST app simulates Book Store shop system.
### Requirements

- Java Development Kit
- PostgreSQL
- Maven 
- Lombok plugin

1. Install JDK
2. Install Lombok plugin in IDE
3. Install PostgresSQL >=12.2
4. Create PostgresSQL database from: 
5. src/main/resources/Scripts/SQL scripts.txt
6. An app's setup requires `postgres` account in the database with password `postgres`.
7. Alternatively, the setup can be changed in file `application.properties` in `src/main/resources/` 
8. Install Postman 
9. In Postman use Http method with URL with authorization 
Type: Basic Auth
username: admin 
password: admin1
or another account with ADMIN role.

**Example Book, Order, User Jsons in:** src\main\resources\Jsons

**HTTP** Method	URI	Description

###### **Books,**

**GET**	/books	List all books.

**GET**	/book/{id}	Find a book where id = {:id}.

**POST**	/book	Save a book.
Allows query by example requests via request parameters (`title`, `author`, `price`, `description` and `releaseDate`)
**PUT**	/book/{id}	Update a book where id = {:id}, or save it.

**DELETE**	/book/{id}	Delete a book where id = {:id}.
 
######  **Users,** 

**GET**	/users	List all users.

**GET**	/user/{id}	Find a user where id = {:id}.

**POST**	/user	Save a user. 
Allows query by example requests via request parameters 
(`city`, `firstName`, `surName`, `userTel`,`username`,`password`,`matchingPassword`,`email`,`authorities` and `enabled`)

**PUT**	/user/{id}	Update a user where id = {:id}, or save it.

**DELETE**	/user/{id}	Delete a user where id = {:id}.

######  **Orders,**
 
 **GET**	/orders	List all orders.
 
 **GET**	/order/{id}	Find a order where id = {:id}.
 
 **POST**	/order	Save a order. 
 Allows query by example requests via request parameters (`bookId`, `userId`, `orderDate`, `quantity`,`price`,`status` and `invoice`)
 **PUT**	/order/{id}	Update a order where id = {:id}, or save it.
 
 **DELETE**	/order/{id}	Delete a order where id = {:id}.
 
### Technologies used :

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Security](https://spring.io/projects/spring-security)
* [PostgreSQL](https://www.postgresql.org/)
* [Maven](https://maven.apache.org)
* [JUnit Jupiter](https://junit.org/junit5)
* [Project Lombok](https://projectlombok.org/)
* [Mockito](https://site.mockito.org/)
* [SLF4J](http://www.slf4j.org/)

 
### Developers

* [Tomasz Czerwiec](https://github.com/Termoss)
* [Dorota Granicka](https://github.com/dgra47)

