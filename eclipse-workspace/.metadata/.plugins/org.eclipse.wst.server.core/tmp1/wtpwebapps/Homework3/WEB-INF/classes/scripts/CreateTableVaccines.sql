CREATE TABLE vaccines (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    dosesRequired INT NOT NULL,
    daysBetweenDoses INT NOT NULL,
    dosesReceived INT DEFAULT 0,
    dosesLeft INT DEFAULT 0
);