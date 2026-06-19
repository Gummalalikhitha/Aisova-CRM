# Aisova Solutions - Customer Management REST API

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
* `entity/`: JPA domain models (`Customer`).
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

2. **Build the project:**
   ```bash
   mvn clean install
   
3. **Run the application:**
   ```bash
   mvn spring-boot:run
  
The application will start on http://localhost:8080
## 🔐 Authentication (JWT & Basic)
All business endpoints are secured. Upon application startup, a default Admin user is automatically generated.

**Admin Credentials:**
* **Email:** `admin@gmail.com`
* **Password:** `Admin@123`

**How to Access Secured APIs:**
1. Send a `POST` request to `/api/auth/login` with the Admin credentials.
2. Copy the resulting token from the response.
3. Include it in the `Authorization` header as a `Bearer Token` for all customer-related API requests.

## 📡 API Endpoints

| HTTP Method | Endpoint | Description | Authentication |
|---|---|---|---|
| POST | `/api/auth/login` | Authenticate and get JWT | Public |
| POST | `/api/customers` | Create a new customer | Bearer Token |
| GET | `/api/customers` | List all customers | Bearer Token |
| GET | `/api/customers/{id}` | Get customer by ID | Bearer Token |
| PUT | `/api/customers/{id}` | Update an existing customer | Bearer Token |
| DELETE | `/api/customers/{id}` | Delete a customer | Bearer Token |
| GET | `/api/customers/search?email=` | Search customer by email | Bearer Token |

## 📚 Documentation & Database Access
* **Swagger UI Documentation:** Access the interactive API documentation at: `http://localhost:8080/swagger-ui.html`
* **H2 Database Console:** View and query the in-memory database at: `http://localhost:8080/h2-console`
  * **JDBC URL:** `jdbc:h2:mem:aisovadb`
  * **User Name:** `sa`
  * **Password:** *(leave blank)*

---

## 📸 Application Screenshots

### 1. Create Customer (POST)
![Create Customer Success](screenshots/create-customer.jpg)

### 2. List Customers (GET)
![List Customers Success](screenshots/list-customers.jpg)

### 3. Database Console (H2)
![H2 Database Records](screenshots/h2-database.jpg)

### 4. Swagger UI Documentation
![Swagger UI](screenshots/swagger-ui.jpg)
