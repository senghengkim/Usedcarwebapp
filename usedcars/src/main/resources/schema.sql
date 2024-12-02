CREATE TABLE IF NOT EXISTS Car (
    id INT NOT NULL PRIMARY KEY,
    make VARCHAR(255) NOT NULL,
    model VARCHAR(255),
    `year` INT CHECK (`year` >= 1900 AND `year` <= 2025),
    color VARCHAR(255),
    mileage INT CHECK (mileage > 0),
    vin CHAR(17) NOT NULL,
    `status` VARCHAR(50) CHECK (status IN ('AVAILABLE', 'SOLD', 'PENDING', 'NOT_AVAILABLE'))
);