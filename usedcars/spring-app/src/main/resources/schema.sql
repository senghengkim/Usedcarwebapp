CREATE TABLE IF NOT EXISTS Car (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    make VARCHAR(255) NOT NULL,
    model VARCHAR(255),
    `year` INT CHECK (`year` >= 1900 AND `year` <= 2025),
    color VARCHAR(255),
    mileage INT CHECK (mileage > 0),
    vin CHAR(17) NOT NULL,
    `status` VARCHAR(50) CHECK (status IN ('AVAILABLE', 'SOLD', 'PENDING', 'NOT_AVAILABLE')),
    VERSION INT
);

CREATE TABLE IF NOT EXISTS Dealership (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    address VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Listing (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    car_id INT NOT NULL,
    `description` VARCHAR(255),
    price DOUBLE,
    `date` DATE NOT NULL,
    dealership_id INT NOT NULL,
    FOREIGN KEY (car_id) REFERENCES Car(id),
    FOREIGN KEY (dealership_id) REFERENCES Dealership(id)
);