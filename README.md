# finalProjectIronhack

#### Description of the project - Digital Products

- Home page - have a few items from a featured Category shown and welcome banner.
- The possibility to have Categories for Items.
- The possiblity to have Sub-Categories for Items.
- The possibilty to define a new Item : name, description, productNumber, price, images.
- The ability to have an Item in one or more Categories.
- The possiblity of defining inventory for an Item.
- A Shopping Cart for the Shopper / User.
- Placing an Order.
- User management with roles : Administrator ( which can add items or modify prices) and Shopper.
- Order histroy.
- Oder status.
- Emailing of Oder Status to the Shopper.
- Product Rating.
- Coupons and Discounts.
- Search for a Product.
- Review and Comments.

### Class Diagram

  <img width="488" alt="image" src="https://github.com/francisChigozie/finalProjectIronhack/assets/81627242/a691a517-b2da-4a23-8b28-8faab25f16f3">

### Setup
- Create the Spring Boot final Project called Digital Products.
- Define Database Configurations
- Create an Entity Class.
- Create JPA Data Repository Layer.
- Create RestController and map API Requests.
- Create Unit testing for API requests and run the Unit testing.
- Create Integration testing and run the Integration testing.
- Build and run the Project.

### Technologies Used
- IntelliJ IDEA 2023.1.1
- Spring web - Full stack development with Tomcat and Spring MVC.
- DevTools - Spring Boot Development Tools.
- JPA - Java Persistance API, including Spring-data JPA, Spring-Orm, and Hibernate.
- MySQL - MySQL JDBC Driver.
- Spring boot Starter Validation.
- Spring Doc - Swagger WebMVC User Interface
- Org.mapstruct and mapstruct processor.
- Spring Security - De facto Security for Spring Boot.
- Actuator - Production-ready features to help you monitor and manage your Application.
- Spring REST Docs - Document RESTful service.
- Spring Project Lombok.

### Controllers and Routes structure
- *CustomerController* : (https://github.com/francisChigozie/finalProjectIronhack/blob/main/src/main/java/com/ironhack/finalprojectdigitalproduct/controller/CustomerController.java)
---
### **Creating a New Customer**

**Endpoint:** `/api/v1/register`  
**Method:** `POST`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "userName": " John Doe ",
  "email": " johndoe@gmail.com ",
  "birthdate": " 19-10-2010",
  "sex": "Female",
  "selectCoins":  200,
  "password": "123456",
  "rePassword": "12345",
  "currentAddress": [
 { "streetAddress" :"Tom Avenue",
    "city": "Berlin",
    " postal": "23456"
 }
   ]
  "minimumOrderValue": 12.50,
  "role": "Administration"
}
```

### **Finding All Customers**

**Endpoint:** `/api/v1/customers`  
**Method:** `GET`  

### **Find One Customer**

**Endpoint:** `/api/v1/customer/{id}`  
**Method:** `GET`  

### **Updating a Customer**

**Endpoint:** `/api/v1/customer/{id}`  
**Method:** `PUT`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "userName": " John Doe ",
  "email": " johndoe@gmail.com ",
 "currentAddress": [
 { "streetAddress" :"Tom Avenue",
    "city": "Berlin",
    " postal": "23456"
 }
   ]
}
```

### **Updating Email Only of the Customer**

**Endpoint:** `/api/v1/customer/{id}`  
**Method:** `PATCH`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "email": "doe@gmail.com"
}
```
### **Deleting a Customer**

**Endpoint:** `/api/v1/customer/{id}`  
**Method:** `DELETE`  

---

- *BookController* : (https://github.com/francisChigozie/finalProjectIronhack/blob/main/src/main/java/com/ironhack/finalprojectdigitalproduct/controller/BookController.java)
---

### **Creating a New Book**

**Endpoint:** `/api/v1/books`  
**Method:** `POST`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "name": " Spring Book In Action ",
  "description": " Spring Framwork that simplifies Java development.  ",
  "productNumber": " MANNING- 0213 ",
  "price":  28.45,
  "inventory":  30,
  "review": [] ,
  "author": "Craig Walls"
}
```

### **Finding All Books**

**Endpoint:** `/api/v1/books`  
**Method:** `GET`  

### **Find One Book**

**Endpoint:** `/api/v1/book/{id}`  
**Method:** `GET`  

### **Updating a Book**

**Endpoint:** `/api/v1/book/{id}`  
**Method:** `PUT`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "name": "Spring Framwork that simplifies Java development. ",
  "description": " Spring Framwork that simplifies Java development.  ",
  "productNumber": " MANNING- 0213 ",
  "price":  28.45,
  "inventory":  15,
  "review": [] 
}
```

### **Updating Price Only of the Book**

**Endpoint:** `/api/v1/book/{id}`  
**Method:** `PATCH`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "price":  19.00
}
```
### **Deleting a Book**

**Endpoint:** `/api/v1/book/{id}`  
**Method:** `DELETE`  

### **Adding Review To Book**

**Endpoint:** `/api/v1/book/{id}/reviews`  
**Method:** `POST`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "userName":" John Doe",
  "comments": "An Interesting Book to read",
  "ratings": 4
}
```

---
- *FilmController* : (https://github.com/francisChigozie/finalProjectIronhack/blob/main/src/main/java/com/ironhack/finalprojectdigitalproduct/controller/FilmController.java)
---
### **Creating a New Film**

**Endpoint:** `/api/v1/films`  
**Method:** `POST`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "name": " Coming To America ",
  "description": " Cultural Comedian  ",
  "productNumber": " COMED - 25 ",
  "price":  12.00,
  "inventory":  12,
  "review": [] ,
  "director": "Eddie Morphy"
}
```

### **Finding All Films**

**Endpoint:** `/api/v1/films`  
**Method:** `GET`  

### **Find One Film**

**Endpoint:** `/api/v1/film/{id}`  
**Method:** `GET`  

### **Updating a Film**

**Endpoint:** `/api/v1/film/{id}`  
**Method:** `PUT`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
 "name": " Coming To America ",
  "description": " First American Impressions  ",
  "productNumber": " COMED - 25 ",
  "price":  12.00,
  "inventory":  24
}
```

### **Deleting a Book**

**Endpoint:** `/api/v1/book/{id}`  
**Method:** `DELETE`  

### **Adding Review To Film**

**Endpoint:** `/api/v1/book/{id}/reviews`  
**Method:** `PUT`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "userName":" Felix Oti",
  "comments": "Best before",
  "ratings": 4
}
```

---
- *MusicProductController* : (https://github.com/francisChigozie/finalProjectIronhack/blob/main/src/main/java/com/ironhack/finalprojectdigitalproduct/controller/MusicProductController.java)
---
### **Creating a New Music Product**

**Endpoint:** `/api/v1/musicProducts`  
**Method:** `POST`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "name": " We Are The World ",
  "description": " Freedom Songs and Unity  ",
  "productNumber": " MUSiC - 01 ",
  "price":  25.45,
  "inventory":  40,
  "review": [] ,
  "performer": "Mecheal Jackson"
}
```

### **Finding All Music Products**

**Endpoint:** `/api/v1/musicProducts`  
**Method:** `GET`  

### **Find One Music Product**

**Endpoint:** `/api/v1/musicProduct/{id}`  
**Method:** `GET`  

### **Updating a Music Product**

**Endpoint:** `/api/v1/musicProduct/{id}`  
**Method:** `PUT`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
   "name": " We Are The World ",
  "description": " Freedom Songs and Unity  ",
  "productNumber": " MUSiC - 01 ",
  "price":  25.45,
  "inventory":  40
}
```

### **Updating Only the Performer in the Music Product**

**Endpoint:** `/api/v1/musicProduct/{id}`  
**Method:** `PATCH`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "performer":  "World Performers"
}
```
### **Deleting a Music Product**

**Endpoint:** `/api/v1/musicProduct/{id}`  
**Method:** `DELETE`  

### **Adding Review To Music Product**

**Endpoint:** `/api/v1/musicProduct/{id}/reviews`  
**Method:** `POST`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "userName":" Jane Doe",
  "comments": "One of the best of all times",
  "ratings": 5
}
```

---
- *GameController* : (https://github.com/francisChigozie/finalProjectIronhack/blob/main/src/main/java/com/ironhack/finalprojectdigitalproduct/controller/GameController.java)
---
### **Creating a New Game**

**Endpoint:** `/api/v1/games`  
**Method:** `POST`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "name": " Super Mario 2 ",
  "description": " Car Racing Tournaments  ",
  "productNumber": " GM - 22 ",
  "price":  25.45,
  "inventory":  45,
  "review": [] ,
  "author": "Nitendo Production"
}
```

### **Finding All Games**

**Endpoint:** `/api/v1/games`  
**Method:** `GET`  

### **Find One Game**

**Endpoint:** `/api/v1/game/{id}`  
**Method:** `GET`  

### **Updating a Game**

**Endpoint:** `/api/v1/game/{id}`  
**Method:** `PUT`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "name": " Super Mario 10 ",
  "description": " Car Racing Editions  ",
  "productNumber": " GM - 25 ",
  "price":  45.45,
  "inventory":  42
}
```

### **Updating Only the Author of The Game**

**Endpoint:** `/api/v1/game/{id}`  
**Method:** `PATCH`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "author":  "Sony Play Stations"
}
```
### **Deleting a Game**

**Endpoint:** `/api/v1/game/{id}`  
**Method:** `DELETE`  

### **Adding Review To The Game**

**Endpoint:** `/api/v1/game/{id}/reviews`  
**Method:** `POST`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "userName":" Jonathan Kings",
  "comments": "Very entertaining",
  "ratings": 3
}
```

---
- *NonFictionBookController* : (https://github.com/francisChigozie/finalProjectIronhack/blob/main/src/main/java/com/ironhack/finalprojectdigitalproduct/controller/NonFictionBookController.java)
---
### **Creating a New Non Fiction Book**

**Endpoint:** `/api/v1/nonFictionBooks`  
**Method:** `POST`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "name": " Alice In Wonder Land ",
  "description": " A Real Life Story  ",
  "productNumber": " N-Fiction - 22 ",
  "price":  25.45,
  "inventory":  45,
  "review": [] ,
  "subject": "Adams Smith"
}
```

### **Finding All Non Fiction Books**

**Endpoint:** `/api/v1/nonFictionBooks`  
**Method:** `GET`  

### **Find One Non Fiction Book**

**Endpoint:** `/api/v1/nonFictionBook/{id}`  
**Method:** `GET`  

### **Updating a Non Fiction Book**

**Endpoint:** `/api/v1/nonFictionBook/{id}`  
**Method:** `PUT`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "name": " Tells of Two Cities ",
  "description": " A Real Life Story  ",
  "productNumber": " N-Fiction - 12 ",
  "price":  2.45,
  "inventory":  5
}
```

### **Updating Only the Subject of Non Fiction Book**

**Endpoint:** `/api/v1/nonFictionBook/{id}`  
**Method:** `PATCH`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "subject":  "Story Telling"
}
```
### **Deleting a Non Fiction Book**

**Endpoint:** `/api/v1/nonFictionBook/{id}`  
**Method:** `DELETE`  

### **Adding Review To Non Fiction Book**

**Endpoint:** `/api/v1/nonFictionBook/{id}/reviews`  
**Method:** `POST`  
**Headers:**

- `Content-Type`: `application/json`
- `Authorization`: `Bearer YOUR_JWT_TOKEN_HERE`

**Body:**

```json
{
  "userName":" Silace Kingibe",
  "comments": "Recommended for children during bed times",
  "ratings": 4
}
```

---


### Extra links 

[Final Project Manangement Account](https://trello.com/b/SxxrLFZ9/digital-products)

[Final Project Presentations](https://slides.com/d/M3dAltY/live)

[REST API presentation with Swagger UI](http://localhost:8080/swagger-ui/index.html)

[Final Project Git Hub Account](https://github.com/francisChigozie/finalProjectIronhack)

### Future Work
- Integration with a payment Provider.
- User Profile Management.
- Profile Picture upload by the User.

### Resources
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=${db_url}
spring.datasource.username=${db_username}
spring.datasource.password=${db_password}


#just for learning / developing
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect


server.error.include-stacktrace=never

spring.profiles.active=dev
```

### Team Members

Salvatore Corsaro: salvatore.corsaro@ironhack.com

