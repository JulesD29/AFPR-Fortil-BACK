-- Création des tables
CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS message (
    id INT AUTO_INCREMENT PRIMARY KEY,
    message VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS tag (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tag VARCHAR(50) NOT NULL
);


-- Insertion de données dans les tables
INSERT INTO user (username) VALUES
    ('Jules'),
    ('Simon');

INSERT INTO message (message) VALUES
    ('Salut !'),
    ('Ca va ?');

INSERT INTO tag (tag) VALUES
    ('23-01-2023'),
    ('24-01-2023');