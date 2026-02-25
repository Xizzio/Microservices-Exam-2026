CREATE TABLE IF NOT EXISTS customers (
    id SERIAL PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    admin BOOLEAN DEFAULT FALSE
);

INSERT INTO customers (email, username, password, admin) VALUES 
('admin@exam.com', 'admin', 'adminpassword', true),
('meny@exam.com', 'meny', 'menypassword', false),
('coop@exam.com', 'coop', 'cooppassword', false),
('kiwi@exam.com', 'kiwi', 'kiwipassword', false);