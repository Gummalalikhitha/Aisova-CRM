Markdown# Aisova Solutions - Customer Management REST API

## 📖 Project Overview
This project is a secure, production-ready Customer Management REST API developed as a technical assessment for Aisova Solutions Pvt Ltd. It serves as the core backend module for a CRM platform, enabling standard CRUD operations, robust validation, and custom search functionalities.

## 🚀 Technology Stack
* **Language:** Java 17
* **Framework:** Spring Boot 3
* **Persistence:** Spring Data JPA / Hibernate
* **Database:** H2 Database (In-Memory)
* **Build Tool:** Maven
* **Security:** Spring Security with **JWT Authentication** (Bonus Task Implemented)
* **API Documentation:** Swagger UI / OpenAPI 3.0

## 🏗️ Architecture
The application strictly follows an enterprise-level, layered architecture for clear separation of concerns:
* `controller/`: REST API endpoints and routing.
* `service/`: Core business logic and validations.
* `repository/`: Database interactions via Spring Data JPA.
* `entity/`: JPA domain models (`Customer`, `User`).
* `dto/`: Data Transfer Objects to ensure entities are not exposed directly.
* `config/`: Application configurations (Security, Swagger).
* `exception/`: Global exception handling (`@RestControllerAdvice`).
* `security/`: JWT generation, validation, and authentication filters.

## ⚙️ Setup and Execution

### Prerequisites
* Java Development Kit (JDK) 17 or higher
* Maven 3.6+

### Installation Steps
1. **Clone the repository:**
   ```bash
   git clone <your-github-repository-url>
   cd aisova-crm-api
Build the project:Bashmvn clean install
Run the application:Bashmvn spring-boot:run
The application will start on http://localhost:8080🔐 Authentication (JWT & Basic)All business endpoints are secured. Upon application startup, a default Admin user is automatically generated.Admin Credentials:Email: admin@gmail.comPassword: Admin@123How to Access Secured APIs:Send a POST request to /api/auth/login with the Admin credentials.Copy the resulting token from the response.Include it in the Authorization header as a Bearer Token for all customer-related API requests.📡 API EndpointsHTTP MethodEndpointDescriptionAuthenticationPOST/api/auth/signupRegister a new userPublicPOST/api/auth/loginAuthenticate and get JWTPublicPOST/api/customersCreate a new customerBearer TokenGET/api/customersList all customersBearer TokenGET/api/customers/{id}Get customer by IDBearer TokenPUT/api/customers/{id}Update an existing customerBearer TokenDELETE/api/customers/{id}Delete a customerBearer TokenGET/api/customers/search?email=Search customer by emailBearer Token📚 Documentation & Database AccessSwagger UI Documentation: Access the interactive API documentation at: http://localhost:8080/swagger-ui.htmlH2 Database Console: View and query the in-memory database at: http://localhost:8080/h2-consoleJDBC URL: jdbc:h2:mem:aisovadbUser Name: saPassword: (leave blank)📁 Evaluation Deliverables Included
