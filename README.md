# Car Web Application

Welcome to the Car Web Application! This application allows users to search for used cars based on various criteria such as make, model, price, and mileage. It also provides functionalities for adding, updating, and deleting car listings.

## Features

- **Search Cars**: Users can search for cars based on make, model, price range, and mileage.
- **Add Car**: Admins can add new car listings with details such as make, model, year, color, mileage, VIN, status, and price.
- **Update Car**: Admins can update existing car listings by providing the car ID and modifying the details.
- **Delete Car**: Admins can delete car listings by providing the car ID.
- **View Listings**: Users can view all car listings in a tabular format.

## Technologies Used

- **Backend**: Spring Boot
- **Frontend**: Thymeleaf, HTML, CSS, JavaScript
- **Database**: Spring Data JDBC

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- A database (e.g., MySQL)

### Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/car-web-application.git
    cd car-web-application
    ```

2. **Configure the database**:
    - Update the `application.properties` file with your database configuration.

3. **Build the application**:
    ```bash
    mvn clean install
    ```

4. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

### Usage

1. **Access the application**:
    - Open your web browser and navigate to `http://localhost:8080`.

2. **Search for cars**:
    - Use the search form on the homepage to filter cars by make, model, price range, and mileage.

3. **Add a new car**:
    - Click on the "Add Car" button, fill out the form, and submit to add a new car listing.

4. **Update an existing car**:
    - Click on the "Update Car" button, provide the car ID, and modify the details in the form.

5. **Delete a car**:
    - Provide the car ID and delete the car listing.

### Project Structure

- **src/main/java/com/example/usedcars**: Contains the Java source code.
    - **car**: Contains the car-related classes and controllers.
    - **web**: Contains the web controllers.
    - **sale**: Contains the sale-related classes and controllers.
    - **dealership**: Contains the dealership-related classes and controllers.
    - **listing**: Contains the listing-related classes and controllers.
- **src/main/resources/templates**: Contains the Thymeleaf templates.
- **src/main/resources/static/css**: Contains the CSS files.
- **src/main/resources/static/js**: Contains the JavaScript files.
- **src/main/resources/application.properties**: Contains the application configuration.

### Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.

### License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

### Contact

If you have any questions or need further clarification, please feel free to contact me at [your-email@example.com].
