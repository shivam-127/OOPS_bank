# Banking System - OOP Showcase

A simple full-stack banking application built with Spring Boot backend and vanilla JavaScript frontend. Showcases OOP concepts: encapsulation, thread-safe operations, and object-oriented design patterns.

## Project Structure

```
OOP_bank/
├── backend/                          # Spring Boot REST API
│   ├── pom.xml
│   ├── src/main/java/com/bank/
│   │   ├── BankApplication.java      # Main application + sample data init
│   │   ├── entity/BankAccount.java   # JPA Entity
│   │   ├── repository/               # Database access layer
│   │   ├── service/                  # Business logic (synchronized methods)
│   │   └── controller/               # REST endpoints
│   └── src/main/resources/
│       └── application.properties    # H2 database config
│
└── frontend/
    └── index.html                    # Vanilla JS UI (single file)
```

## Features

✅ **Create Accounts** - Initialize with balance and PIN  
✅ **Deposit Money** - Add funds to any account  
✅ **Withdraw Money** - With PIN verification and balance check  
✅ **Change PIN** - Secure PIN updates  
✅ **Real-time Balance** - Updated after each operation  
✅ **Thread-safe Operations** - Synchronized methods in service layer  
✅ **Responsive UI** - Works on desktop, tablet, and mobile  

## Backend Setup

### Prerequisites
- Java 17+ installed
- Maven installed (`mvn --version` to verify)

### Run Backend

1. Navigate to backend directory:
   ```bash
   cd backend
   ```

2. Build and run with Maven:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   Or run the JAR file:
   ```bash
   mvn package
   java -jar target/banking-system-1.0.0.jar
   ```

3. Backend starts at: **http://localhost:8080**

### Sample Data
The backend auto-initializes with 3 test accounts:
- Account 1: Balance $1000, PIN: 1111
- Account 2: Balance $5000, PIN: 2222
- Account 3: Balance $3000, PIN: 3333

### H2 Database Console
Access at: **http://localhost:8080/h2-console**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave blank)

## Frontend Setup

Simply open the HTML file in your browser:

1. Navigate to frontend directory:
   ```bash
   cd frontend
   ```

2. Open `index.html` in your browser:
   - Double-click the file, OR
   - Use a local server (recommended):
     ```bash
     # Using Python 3
     python -m http.server 3000
     
     # Using Node.js http-server
     npx http-server -p 3000
     ```
   
3. Frontend opens at: **http://localhost:3000**

## How to Use

1. **Start the backend** first (Spring Boot server must be running)
2. **Open `frontend/index.html`** in your browser
3. **Perform operations**:
   - View all 3 accounts and their balances
   - Enter amount → click **Deposit** to add funds
   - Enter amount + PIN → click **Withdraw** to remove funds
   - Enter old PIN + new PIN → click **Change PIN** to update security
4. **Click Refresh** to reload account data from backend

## OOP Concepts Demonstrated

### 1. **Encapsulation**
- Private fields in `BankAccount` entity (balance, pin)
- Public methods control access to sensitive data
- PIN verification prevents unauthorized withdrawals

### 2. **Thread-Safe Operations** (Synchronized)
```java
@Autowired
private BankAccountService service;

public synchronized BankAccount deposit(Long id, Double amount) {
    // Ensures only one thread modifies balance at a time
}
```

### 3. **Repository Pattern**
- `BankAccountRepository` abstracts database operations
- Service layer uses repository for data persistence

### 4. **Layered Architecture**
- Controller → Service → Repository → Entity
- Clear separation of concerns

### 5. **Exception Handling**
- PIN mismatch throws exception
- Insufficient balance throws exception
- Frontend displays user-friendly error messages

## API Endpoints

### Get All Accounts
```
GET http://localhost:8080/api/accounts
```

### Get Single Account
```
GET http://localhost:8080/api/accounts/{id}
```

### Create Account
```
POST http://localhost:8080/api/accounts
Body: {"accountName": "Test", "balance": 1000, "pin": 1111}
```

### Deposit Money
```
POST http://localhost:8080/api/accounts/{id}/deposit
Body: {"amount": 500}
```

### Withdraw Money
```
POST http://localhost:8080/api/accounts/{id}/withdraw
Body: {"amount": 200, "pin": 1111}
```

### Change PIN
```
POST http://localhost:8080/api/accounts/{id}/change-pin
Body: {"oldPin": 1111, "newPin": 9999}
```

## Troubleshooting

### Frontend can't connect to backend
- Ensure backend is running on `http://localhost:8080`
- Check browser console (F12) for CORS or connection errors
- Backend has CORS enabled for all origins

### Port already in use
- Backend: `netstat -ano | findstr :8080` (Windows) to find process
- Kill the process or change port in `application.properties`

### H2 Database reset
- Data is stored in-memory and resets when server restarts
- Check H2 console to verify data persistence

## Next Steps (Optional Enhancements)

- Add user authentication (JWT)
- Implement transaction history
- Add multiple currency support
- Real-time WebSocket updates
- Deploy to cloud (Heroku, AWS)
- Add unit tests

## License

Educational project - free to use and modify.
