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

**Endpoint:** `api/vi/book`  
```
**Method:** `POST - creates a new book into the database.` 
```
**Body:** JSON object of Book.
```

**Request Format:**

```json
{
  "name": " String ",
  "description": " String ",
  "productNumber": " String ",
  "price":  BigDecimal,
  "inventory":  int,
  "review": [
{
  "comments": " String ",
  "ratings": int 
}
 ] 
}
```

**Endpoint:** `api/vi/books`  
```
**Method:** `GET - gets all the books in the database.` 
```
**Body:** Not needed.
```

```
**Endpoint:** `api/vi/book/{id}`  
```
**Method:** `GET - gets a single book from the database.` 
```
**Body:** Not needed.
```

```


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

