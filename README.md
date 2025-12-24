# SmartBank – Full-Stack Banking System (Production-Oriented)

🔗 Live Demo: https://smartbank-i2kx.onrender.com/

SmartBank is a production-style digital banking application designed to demonstrate real-world backend engineering concepts used in fintech systems, including  **Ai chatbot** ,**ML-driven decision services** 
 , **Redis caching** , **secure JWT authentication**, transactional safety, idempotency, pagination .

---

## Tech Stack
**Gemini chatbot**
-integrated chatbot 

**Frontend**
- React.js

**Backend**
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- Caffeine / Redis Cache

**Database**
- PostgreSQL

**Payments**
- Razorpay (wallet top-ups)

**Machine Learning**
- Python (Loan eligibility & transaction fraud detection)

**Infrastructure**
- Docker
- Render (deployment)

---

## Core Engineering Concepts

- JWT-based authentication and role-based authorization
- DTO-driven architecture (no direct entity exposure)
- Transactional consistency using `@Transactional`
- Idempotent APIs for payments and money transfers
- Pagination for scalable data access
- Caching (Caffeine / Redis) to reduce database load
- Inter-service communication between Spring Boot and Python ML services
- Dockerized services for deployment consistency

---

## Application Flow

### User
- Login and account creation
- Add money using Razorpay
- Secure money transfers
- Loan application with ML-based eligibility check
- EMI payments (fixed 6-month tenure)
- Dynamic interest rate based on credit score  
  - Late payments reduce score  
  - Early/on-time payments improve score  
-snippets:
<img width="1910" height="400" width="600" alt="image" src="https://github.com/user-attachments/assets/af3cff04-2db4-4cc7-870d-b4588a5e85e5" />

<img width="1917" height="400" width="600" alt="image" src="https://github.com/user-attachments/assets/8081ed84-da49-4fdd-8a9f-4578aadbee83" />

<img width="1904" height="400" width="600" alt="image" src="https://github.com/user-attachments/assets/bc3a1702-b143-4195-8c88-f4ed05c4e6bf" />

<img width="1912" height="400" width="600" alt="image" src="https://github.com/user-attachments/assets/b7b95883-62fc-447a-8bf4-bb0cfaf3ef81" />

<img width="1910" height="400" width="600" alt="image" src="https://github.com/user-attachments/assets/2aefcc1b-d217-4029-ad94-64a8c7a15d9b" />

### Admin
- Monitor all transactions
- Manage users and bank accounts
- Approve or reject loan applications
- Block suspicious accounts
- Oversee fraud detection results
-snippets:
  <img width="1914" height="400" alt="image" src="https://github.com/user-attachments/assets/8ab94777-774c-4394-8027-b8dd142e8b9a" />
  
  <img width="1898" height="400" alt="image" src="https://github.com/user-attachments/assets/cd79bbce-35dd-4d2d-8d26-24c11f299835" />
  
 <img width="1913" height="891" alt="image" src="https://github.com/user-attachments/assets/0480523d-0750-47fc-8c82-0323acec8565" />

  <img width="1913" height="400" alt="image" src="https://github.com/user-attachments/assets/552376b6-8556-4c80-8132-4ceab7bca7b2" />

## Machine Learning Integration

- **Loan Eligibility Service**
  - Predicts loan approval based on financial features
- **Transaction Fraud Detection Service**
  - Flags suspicious transactions before completion

Both ML services are built in Python, deployed independently, and consumed by the Spring Boot backend via REST APIs.

---

## Project Highlights

- Designed around real banking constraints
- Emphasis on safety, consistency, and scalability
- Clean backend architecture with separation of concerns
- Practical use of ML in backend decision-making


## Author

**Subham Dutta**  
Reverside Intern  
Focused on backend engineering, distributed systems, and fintech systems.
