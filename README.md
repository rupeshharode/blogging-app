# Blogging Application

A simple Spring Boot blogging application with CRUD operations for blog posts.

## Setup

1. Ensure you have MySQL installed and running.
2. Create a database named `blogpost`.
3. Set environment variables for database credentials:
   - `DB_USERNAME` (default: root)
   - `DB_PASSWORD` (default: password)

   Or create `src/main/resources/application-local.properties` with:
   ```
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. Run the application:
   ```
   ./mvnw spring-boot:run
   ```

5. Access at http://localhost:8080

## Features

- View all posts
- Create new posts
- Edit existing posts
- Delete posts