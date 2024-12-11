CREATE TABLE IF NOT EXISTS Car (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    make VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    price DOUBLE NOT NULL,
    color VARCHAR(255),
    mileage INT,
    vin VARCHAR(17) NOT NULL,
    status VARCHAR(50) NOT NULL
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

CREATE TABLE IF NOT EXISTS Sale (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    sale_date DATE NOT NULL,
    sale_price DOUBLE NOT NULL,
    payment_method VARCHAR(50) NOT NULL,
    listing_id INT NOT NULL,
    FOREIGN KEY (listing_id) REFERENCES Listing(id)
);