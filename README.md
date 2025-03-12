# 📚 Spring Boot Security Demo

This project is a Spring Boot application that integrates **Spring Security**, providing user authentication and authorization. It includes role-based access control for administrators and users, along with basic CRUD operations for managing books.

## 🛠️ Technologies Used

- **Spring Boot** (Backend framework)
- **Spring Security** (Authentication & Authorization)
- **Spring Data JPA** (Database integration)
- **MySQL** (Database)
- **Thymeleaf** (Frontend templating)
- **Lombok** (Reducing boilerplate code)
- **BCrypt** (Password hashing)

## 📂 Project Structure

```bash
src/
 ├── main/
 │   ├── java/com/example/demo/
 │   │   ├── controller/      # Controllers (Admin, User, Role, Home)
 │   │   ├── model/           # Entity classes (User, Role, Book)
 │   │   ├── repository/      # Spring Data JPA repositories
 │   │   ├── service/         # Business logic (UserService, BookService, RoleService)
 │   │   ├── dto/             # Data Transfer Objects (UserDto, RoleDto)
 │   │   ├── mapper/          # Entity <-> DTO Mappers
 │   ├── resources/
 │   │   ├── templates/       # Thymeleaf HTML templates
 │   │   ├── application.properties  # Database & security configurations
 ├── pom.xml                  # Project dependencies
 ├── README.md                # Project documentation
```

## 🔑 User Roles & Permissions

### ADMIN
- Can add, delete, and list books
- Has access to `/admin/*` routes

### USER
- Can view books
- Limited access to functionality

## 🚀 Running the Project

### Clone the repository:

```bash
git clone https://github.com/your-repo.git
cd your-repo
```

### Configure the database (H2 or MySQL) in `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

### Run the application:

```bash
mvn spring-boot:run
```

### Access the web interface:

- **Home:** [http://localhost:8080](http://localhost:8080)
- **Admin Panel:** [http://localhost:8080/admin](http://localhost:8080/admin)

## 🔄 API Endpoints

| Method | Endpoint            | Description          | Role Required |
|--------|---------------------|----------------------|---------------|
| GET    | `/`                 | Home page           | Any           |
| GET    | `/login`            | Login page          | Any           |
| GET    | `/register`         | Registration page   | Any           |
| POST   | `/createUser`       | Register user       | Any           |
| GET    | `/users`            | List all users      | ADMIN         |
| GET    | `/roles`            | List all roles      | ADMIN         |
| GET    | `/admin/books`      | List all books      | ADMIN         |
| GET    | `/admin/add-book`   | Add book page       | ADMIN         |
| POST   | `/admin/add-book`   | Add book            | ADMIN         |
| POST   | `/admin/delete-book/{id}` | Delete book  | ADMIN         |

## 🔒 Security

- Spring Security is configured to restrict access based on roles.
- BCrypt password hashing is used to securely store passwords.
- CSRF protection is enabled by default for extra security.

## 📌 Future Improvements

- ✅ REST API with JWT authentication
- ✅ More detailed logging
- ✅ Improved UI with Bootstrap

