-- Création des tables
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS messages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    message VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS tags (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tag VARCHAR(50) NOT NULL
);


-- Insertion de données dans les tables
INSERT INTO users (username) VALUES
    ('Jules'),
    ('Simon');

INSERT INTO messages (message) VALUES
    ('Salut !'),
    ('Ca va ?');

INSERT INTO tags (tag) VALUES
    ('23-01-2023'),
    ('24-01-2023');