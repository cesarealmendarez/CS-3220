-- Create Vaccines Table
CREATE TABLE vaccines (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    dosesRequired INT NOT NULL,
    daysBetweenDoses INT NOT NULL,
    dosesReceived INT DEFAULT 0,
    dosesLeft INT DEFAULT 0
);

-- Create Patients Table
CREATE TABLE patients (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    vaccineID INT NOT NULL,
    firstDoseDate DATE,
    secondDoseDate DATE
);

-- Insert Patient
INSERT INTO patients (name, vaccineID, firstDoseDate, secondDoseDate) 
VALUES ('John Doe', 1, '2023-04-15', '2023-05-06');

-- Insert Vaccine
INSERT INTO vaccines (name, dosesRequired, daysBetweenDoses, dosesReceived, dosesLeft)
VALUES ('Moderna', 2, 28, 100, 100);