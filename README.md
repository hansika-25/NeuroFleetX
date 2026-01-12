🚌 NeuroFleetX: Urban Power Fleet Management System
NeuroFleetX is a next-generation, AI-integrated transit management ecosystem designed to digitize and optimize urban mobility. Built using a high-performance Decoupled Architecture, it leverages Java Spring Boot for an enterprise-grade backend and React.js for a dynamic user interface, with MongoDB serving as the flexible, high-scale NoSQL data foundation.

The project addresses the core inefficiencies of traditional public transport by providing real-time visibility, automated scheduling, and intelligent, AI-driven passenger assistance.

🚀 Core Functionalities
1. Centralized Admin Command Center
Fleet Oversight: Full CRUD (Create, Read, Update, Delete) operations for the entire bus inventory.

Dynamic Dispatch: Real-time assignment of drivers to specific routes based on availability and demand.

Operational Analytics: A comprehensive dashboard visualizing active fleet status, pending maintenance, and route efficiency.

2. Real-Time Passenger Empowerment
Live Geospatial Tracking: Accurate visualization of bus movements using real-time data streaming and map integration.

NeuroBot (AI Assistant): An integrated Generative AI chatbot that processes natural language queries to provide instant ETAs, fare estimates, and route guidance.

Digital Access: A mobile-responsive portal for commuters to access schedules and live updates without physical helpdesks.

3. Driver Management Module
Shift Logistics: A dedicated interface for drivers to check their assigned vehicle and route details for each shift.

Instant Status Updates: Drivers can toggle statuses (e.g., "In Transit," "Delayed," "Maintenance"), which instantly synchronizes data across Admin and Passenger views.

🛠️ Technical Stack & Architecture
Backend: Java Spring Boot
RESTful Micro-services: Engineered using Spring Web to handle complex business logic and stakeholder communication.

Spring Security & JWT: Implemented a stateless authentication mechanism ensuring secure data exchange and Role-Based Access Control (RBAC).

Spring Data MongoDB: Facilitates seamless interaction between Java objects and the NoSQL database, allowing for a highly flexible and scalable data schema.

Postman API Testing: All endpoints were rigorously validated using Postman for request-response accuracy and security compliance.

Frontend: React.js
Stateful UI: Efficiently manages real-time data flow and UI updates using React Hooks (useState, useEffect).

Tailwind CSS: Utilized for building a professional, high-performance, and fully responsive user interface.

Axios: Integrated for asynchronous, non-blocking API communication with the Spring Boot backend.

Database: MongoDB (NoSQL)
Schema Flexibility: Chosen to handle varying data structures for different vehicle types, dynamic route logs, and unstructured AI chat history.

High Availability: Ensures the system remains responsive even under high concurrent loads during peak transit hours.

🏗️ System Execution Flow
Authentication: Users log in via the React frontend. The Spring Boot backend validates credentials against MongoDB and issues a JWT Token.

Authorized Communication: The frontend includes the JWT in the header for all subsequent requests. Spring Boot filters validate the token before processing data.

Real-Time Sync: When a driver updates a status, the change is persisted in MongoDB. The backend then triggers an update, ensuring the Passenger and Admin dashboards reflect the new data immediately.

AI Logic: Passenger queries are sent to a dedicated Spring Boot service, which interacts with the GenAI API to return context-aware transit information through the NeuroBot interface.

🚦 Installation & Configuration
Prerequisites
JDK 17 or higher

Node.js (v18+)

MongoDB Atlas (Cloud) or MongoDB Compass (Local)

Maven

1. Backend Configuration
Update src/main/resources/application.properties:

Properties

spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster.mongodb.net/NeuroFleetX
jwt.secret=your_super_secure_long_secret_key_here
Run the backend:

Bash

mvn spring-boot:run
2. Frontend Configuration
Install dependencies and start:

Bash

cd frontend
npm install
npm run dev

📜 Acknowledgements
This project was developed during the Infosys Internship Program. A special and heartfelt thank you to our mentor, Vinay Sir, for his invaluable guidance, technical insights into Java microservices, and constant support in refining the system architecture.
