<<<<<<< HEAD
# Quick Start Guide

## 1. Start Backend (Terminal 1)
```bash
cd c:\Users\Shivam\Desktop\Java\OOP_bank\backend
mvn spring-boot:run
```

**Wait for**: "Started BankApplication in X seconds"  
**Backend URL**: http://localhost:8080

---

## 2. Open Frontend (Browser)
```
Open: c:\Users\Shivam\Desktop\Java\OOP_bank\frontend\index.html
(Or: http://localhost:3000 if using local server)
```

---

## 3. Test Operations

**View 3 Test Accounts:**
- Account 1: $1000 (PIN: 1111)
- Account 2: $5000 (PIN: 2222)
- Account 3: $3000 (PIN: 3333)

**Try These:**
1. **Deposit**: Enter 500 → click Deposit → Balance updates to $1500
2. **Withdraw**: Enter 200 + PIN 1111 → click Withdraw → Balance updates to $1300
3. **Change PIN**: Enter 1111 + new 9999 → click Change PIN → PIN updated
4. **Wrong PIN**: Try withdrawing with wrong PIN → Error message
5. **Insufficient Funds**: Try withdrawing more than balance → Error message

---

## 4. Backend Features

- **Synchronized methods** for thread-safe operations
- **PIN verification** before withdrawals
- **Balance validation** before transactions
- **H2 in-memory database** (data resets on restart)
- **CORS enabled** for frontend communication

---

## 5. Database Console (Optional)
```
http://localhost:8080/h2-console
```
View actual database records in real-time.

---

## Troubleshooting

| Issue | Solution |
|-------|----------|
| Backend won't start | Ensure Java 17+ installed, port 8080 free |
| Frontend can't connect | Check backend is running, try http://localhost:8080/api/accounts in browser |
| Port 8080 in use | `netstat -ano \| findstr :8080` to find process, kill or change port |
| Data not persisting | H2 is in-memory, data resets on restart (expected) |

---

**That's it! Your OOP Banking System is live.** 🚀
=======
# Quick Start Guide

## 1. Start Backend (Terminal 1)
```bash
cd c:\Users\Shivam\Desktop\Java\OOP_bank\backend
mvn spring-boot:run
```

**Wait for**: "Started BankApplication in X seconds"  
**Backend URL**: http://localhost:8080

---

## 2. Open Frontend (Browser)
```
Open: c:\Users\Shivam\Desktop\Java\OOP_bank\frontend\index.html
(Or: http://localhost:3000 if using local server)
```

---

## 3. Test Operations

**View 3 Test Accounts:**
- Account 1: $1000 (PIN: 1111)
- Account 2: $5000 (PIN: 2222)
- Account 3: $3000 (PIN: 3333)

**Try These:**
1. **Deposit**: Enter 500 → click Deposit → Balance updates to $1500
2. **Withdraw**: Enter 200 + PIN 1111 → click Withdraw → Balance updates to $1300
3. **Change PIN**: Enter 1111 + new 9999 → click Change PIN → PIN updated
4. **Wrong PIN**: Try withdrawing with wrong PIN → Error message
5. **Insufficient Funds**: Try withdrawing more than balance → Error message

---

## 4. Backend Features

- **Synchronized methods** for thread-safe operations
- **PIN verification** before withdrawals
- **Balance validation** before transactions
- **H2 in-memory database** (data resets on restart)
- **CORS enabled** for frontend communication

---

## 5. Database Console (Optional)
```
http://localhost:8080/h2-console
```
View actual database records in real-time.

---

## Troubleshooting

| Issue | Solution |
|-------|----------|
| Backend won't start | Ensure Java 17+ installed, port 8080 free |
| Frontend can't connect | Check backend is running, try http://localhost:8080/api/accounts in browser |
| Port 8080 in use | `netstat -ano \| findstr :8080` to find process, kill or change port |
| Data not persisting | H2 is in-memory, data resets on restart (expected) |

---

**That's it! Your OOP Banking System is live.** 🚀
>>>>>>> 951a9d8 (Initial push)
