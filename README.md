# 🌟 Spring Boot CRUD Challenges 🌟

## 🚀 Overview

Welcome to this repository of Spring Boot CRUD Challenges! This project is designed for developers to practice and prepare for the performance test in the Riwi community. Each project focuses on using:

- 🔒 Spring Security with JWT for authentication
- 🗄️ Hibernate/JPA for entity management
- 🐬 MySQL as the database
- 🎯 Hexagonal architecture

With these challenges, you'll also learn how to:

- 📚 Document APIs using Swagger
- 🔗 Manage relationships between entities with Hibernate

Complete the challenges and get ready for your performance test! 💪

---

## 🗂️ Projects List

Here are the five CRUD projects that you'll find in this repository:

### 1️⃣ 📚 Library Management System

Build a digital library system where users can search for books by category or author, and administrators can manage books, authors, and categories.

#### Key Features:
- 👥 User Roles: Regular users can search for books, while admins manage books
- ✏️ CRUD: Full CRUD functionality for books, authors, and categories
- 🔗 Many-to-many relationship between books and authors
- 📊 One-to-many relationship between categories and books
- 🔐 JWT based authentication to secure endpoints
- 📖 Swagger documentation to explore the API

### 2️⃣ 🍽️ Restaurant Reservation System

Create a restaurant reservation system where users can browse available restaurants and reserve tables, while administrators manage restaurants and table availability.

#### Key Features:
- 👨‍💼 Admin Features: Manage restaurants and tables
- 🍴 User Features: Make reservations, check table availability in real time
- 🏪 One-to-many relationship between restaurants and tables
- ✅ Validation: Ensure no double bookings by validating table availability
- 🔒 JWT authentication and Swagger documentation

### 3️⃣ 🎓 Online Course Platform

Develop an online course platform where users can enroll in courses, complete lessons, and leave feedback. Administrators manage the courses and their content.

#### Key Features:
- 📝 Course Management: Admins can create, update, and delete courses
- 📚 Lesson Management: Courses contain multiple lessons
- 👥 Many-to-many relationship between users and courses
- 💬 Users can enroll in courses and leave comments
- 🔐 JWT authentication and Swagger documentation for the API

### 4️⃣ 🗓️ Event Management System

Build a platform where users can register for events, and organizers can manage their events. The system should validate event capacity and manage participant lists.

#### Key Features:
- ✏️ CRUD: Event creation, registration, and management
- 👥 Many-to-many relationship between users and events
- 🚫 Capacity Validation: Ensure the number of participants does not exceed the event capacity
- 🔒 JWT authentication and Swagger API documentation

### 5️⃣ 📊 Project and Task Management System

Create a project and task management system where users can create projects, assign tasks, and track progress.

#### Key Features:
- 📁 Project Management: Create, update, and delete projects
- ✅ Task Management: Assign tasks to users, set deadlines, and mark tasks as completed
- 🔗 One-to-many relationship between projects and tasks
- 🔐 JWT authentication and Swagger documentation for the API

---

## 🚀 How to Run the Projects

Follow these steps to get the projects up and running on your local machine:

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/spring-boot-crud-challenges.git
   ```

2. Set up the database:
   - Ensure you have MySQL running
   - Create a database for each project

3. Configure `application.properties`:
   - Open the `src/main/resources/application.properties` file and configure your MySQL connection:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your_database
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

4. Run the project:
   - Use Maven to build and run:
     ```bash
     ./mvnw spring-boot:run
     ```

5. Access Swagger:
   - Once running, access the API documentation via Swagger:
     ```
     http://localhost:8080/swagger-ui.html
     ```

---

## 🤝 Contributing

Contributions are welcome! If you have any ideas, bug fixes, or improvements, feel free to follow these steps:

1. Fork this repository
2. Create a new branch: `git checkout -b my-new-feature`
3. Make your changes and commit: `git commit -m "Add some feature"`
4. Push to the branch: `git push origin my-new-feature`
5. Open a Pull Request

---

## 📜 License

This project is licensed under the MIT License.

---

## 📧 Contact

Have any questions or suggestions? Feel free to reach out!

- Email: your.email@example.com
- Twitter: @your-twitter

---

## 🌍 Join the Riwi Community

This repository was created as part of the preparation for the performance test in the Riwi community. Join us and improve your skills alongside other developers! 💻👨‍💻👩‍💻