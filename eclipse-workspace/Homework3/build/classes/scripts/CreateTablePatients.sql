CREATE TABLE patients (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    vaccineID INT NOT NULL,
    firstDoseDate DATE,
    secondDoseDate DATE
);