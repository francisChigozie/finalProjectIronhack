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
  "comments": "An Interesting Book to read",
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

### Team Members

Salvatore Corsaro: salvatore.corsaro@ironhack.com

