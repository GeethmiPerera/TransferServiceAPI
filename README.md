# 💸 TransferServiceAPI

A simple RESTful API built with Spring Boot for transferring funds between accounts. This project demonstrates clean code architecture, RESTful design, error handling, and basic testing.

---

## 🚀 Features

- Fund transfers between in-memory accounts
- RESTful endpoints with input validation
- Custom error handling with appropriate HTTP status codes

---

## 📦 Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Maven

---

## 📁 Project Structure

```
com.example.TransferService
├── controller         // API endpoints
├── model              // Data models: Account, Transaction
├── service            // TransferService with business logic
├── TransferServiceAPI // Main application class
└── test               // tests
```

---

## 🔄 API Endpoints

### POST `/api/transfer`

Transfer funds between accounts.

#### Request Body

```json
{
  "sourceAccountNumber": "123",
  "destinationAccountNumber": "4565",
  "amount": 100.0
}
```

#### Possible Responses

- `200 OK` – `"Transfer successful."`
- `404 Not Found` – `"Accounts not found."`

---

### GET `/api/account/{accountNumber}`

Fetch account details by account number.

#### Example Response

```json
{
  "accountNumber": "123",
  "balance": 1400.0
}
```

- `200 OK` – if account exists
- `404 Not Found` – if account not found

---

## 🛠️ How to Run Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/GeethmiPerera/transfer-service-api.git
   cd transfer-service-api
   ```

2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Use Postman or curl to test the API at `http://localhost:8080/api`

---






