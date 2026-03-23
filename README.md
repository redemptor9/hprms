# Hospital Patient Record Management System (HPRMS)

**Course:** CPP 3101: OBJECT ORIENTED PROGRAMMING WITH JAVA (ASS 3)  
**Group:** 7  

### Group Members:
1. 25/04246 GITONGA EVANS KIMATHI
2. 18/05761 OKONGO REDEMPTER OMWERI
3. 22/05498 OCHIENG ALFRED KEVIN
4. 25/00397 KAMAMIA MARK MAINA
5. MUINGO FEDELIS SHARON
6. 23/03916 KYALO SAMUEL MAKEWA
7. 21/01323 BUKACHI TABYRITA ANYONA
8. MAKINI BARNABAS GISAIRO

---

## 📌 Project Overview
The Hospital Patient Record Management System (HPRMS) is a robust Java-based solution designed to digitize and streamline hospital operations. It manages patient registration, appointment scheduling, medical records, laboratory tests, billing operations, and automated report generation. 

The software strictly adheres to a **3-tier architecture**:
1. **Presentation Layer (UI)**: HTML/CSS/JS web dashboard interface.
2. **Business Logic Layer**: Spring Boot RESTful API Controllers and Services.
3. **Data Layer**: Spring Data JPA repositories communicating with an H2 Relational Database.

## ✨ Core Features Developed
- **Patient Registration:** Secure capture and editing of patient demographics.
- **Appointments:** Scheduling and tracking between doctors and patients.
- **Medical Records:** Storing diagnosis histories and prescriptions.
- **Laboratory:** Capturing lab test results and clinical observations.
- **Billing:** Invoice generation and live payment tracking.
- **Reporting:** Automated statistical aggregation of hospital performance.
- **Security:** Fully implemented Role-Based Access Control (RBAC) via Spring Security and JSON Web Tokens (JWT).

## 🚀 How to Run the Application

### Prerequisites
- Java Development Kit (JDK 11 or higher)
- Maven 

### Startup Instructions
1. Open a terminal and navigate to the root directory of this project.
2. Run the following command to compile and start the backend server:
   ```bash
   mvn spring-boot:run
   ```
3. Once the server starts (you will see `Tomcat started on port 8080`), open your web browser and navigate to:
   **[http://localhost:8080](http://localhost:8080)**

*The system will automatically initialize with a default Administrator account and load the dashboard interface.*

### Database Access
The application uses an in-memory H2 database for testing and demonstration purposes. You can view the live database tables at:
- **URL:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **JDBC URL:** `jdbc:h2:mem:hprmsdb`
- **Username:** `sa`
- **Password:** *(leave completely blank)*

## 🛠 Technology Stack
- **Backend:** Java, Spring Boot, Spring Security (JWT), Spring Data JPA, Maven.
- **Frontend:** HTML5, Vanilla JavaScript, CSS3 (Glassmorphism design).
- **Database:** H2 (Relational SQL).
