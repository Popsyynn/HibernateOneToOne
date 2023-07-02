# HibernateOneToOne
Implemented a microservice architecture for managing tutorials and tutorial details in a Spring Boot backend environment. The project utilized a one-to-one relationship between tutorial details and tutorials, allowing users to perform Http requests
# Spring Boot Project - One-to-One ORM

This Spring Boot project demonstrates a one-to-one relationship mapping between TutorialDetail and Tutorial entities using Hibernate and MySQL.

## Project Overview

The project focuses on managing tutorials and their details in a database. It provides CRUD (Create, Read, Update, Delete) operations for tutorials, along with their corresponding details.

The application is built with the following technologies:

- Java
- Spring Boot
- Hibernate
- MySQL

## Features

- Create a new tutorial along with its details
- Retrieve the details of a tutorial
- Update the details of a tutorial
- Delete a tutorial and its associated details
- Get published tutorial responses.

## Setup

Follow these steps to set up the project on your local machine:

1. Ensure you have Java Development Kit (JDK) installed. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. Install MySQL database and create a database named `tutorialdetails`. You can download MySQL from [here](https://dev.mysql.com/downloads/installer/).

3. Clone this repository or download the project files.

4. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).

5. Modify the database configuration in `application.properties` file located in the `src/main/resources` directory. Set the correct MySQL connection properties such as URL, username, and password.

6. Build the project and resolve any missing dependencies.

7. Run the application.

8. Access the application through the defined endpoint, e.g., `http://localhost:8080`.

## API Endpoints

The following API endpoints are available in the application:

- `GET api/tutorials` - Retrieve all tutorials
- `GET api/tutorials/{id}` - Retrieve a tutorial by ID
- `POST api/tutorials` - Create a new tutorial
- `PUT api/tutorials/{id}` - Update the tutorial
- `DELETE api/tutorials/{id}` - Delete a tutorial by ID
- `DELETE api/tutorials` - Delete all tutorial
- `GET api/tutorials/published - Get Published tutorial
- `GET api/details/{id} - Get tutorial detail by id
- `POST api/tutorials/{id}/details - Create a new tutorial detail
- `PUT api/details/{id} - Update tutorial details
- `DELETE api/details/{id} - Delete tutorial details by id and corresponding parent entity
- `DELETE api/tutorials/{id}/details - Delete tutorial detail by id

## Database Schema

The database schema for the application consists of two tables:

1. `tutorial` - Stores tutorial information
   - Columns: `id`, `title`, `description`, `published`

2. `tutorial_detail` - Stores tutorial details associated with each tutorial
   - Columns: `id`, `createdOn`,`createdBy`

## Resources

Here are some resources that can help you understand the concepts used in this project:

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Hibernate Documentation](https://hibernate.org/orm/documentation/)
- [MySQL Documentation](https://dev.mysql.com/doc/)

## Contributing

If you find any issues or have suggestions for improvement, feel free to contribute to this project. You can submit a pull request or open an issue on the project repository.

## License

This project is licensed under the [MIT License](LICENSE). You are free to use, modify, and distribute the code for personal or commercial purposes.

## Acknowledgments

We would like to express our gratitude to the Spring Boot, Hibernate, and MySQL communities for providing excellent frameworks and tools for building robust and scalable applications.

## Contact

If you have any questions or inquiries, please contact:

- Email: popsyynn@gmail.com
- Mobile: +2348174336178

Thank you for your interest in this project!
