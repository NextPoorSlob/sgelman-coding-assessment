# Grainger Coding Assessment

Shows a simple implementation of a user database using Java/SpringBoot on the backend and React on the frontend.

## Database Schema

The database consists of a single table named `products` with the following fields:
- `id` (integer, primary key, auto-increment)
- `name` (string, indexed, unique)

## To Run the Application

### Start The Database
1. Ensure you have Docker installed on your machine.
2. Open a terminal and navigate to the project directory.
3. Run the following command to start the PostgreSQL database using Docker: 
```
docker-compose up -d
```
To stop the database,run:
   ```
   docker-compose down
   ```

### Start The Backend
1. Navigate to the `backend` directory:
2. Run the following command to start the Spring Boot application:
```./mvnw spring-boot:run
```
The backend server will start on `http://localhost:8080`.

To stop the backend server, press `Ctrl + C` in the terminal.