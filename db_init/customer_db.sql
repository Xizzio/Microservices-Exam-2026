CREATE TABLE IF NOT EXISTS customers (
    id SERIAL PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    admin BOOLEAN DEFAULT FALSE
);

INSERT INTO customers (email, username, password, admin) VALUES 
('admin@exam.com', 'admin', '$2a$10$LtCWmKR66Br3JBt.BlIxaOCM7EWqebJ2G6I1r9ilGf1CYXfep1qwa', true), -- Password: adminpassword
('meny@exam.com', 'meny', '$2a$10$ZqYublxRRPNDlL7Mi7Ayxu0sPKeea27K2oGJqw/R668IjCKraVCSa', false), -- Password: menypassword
('coop@exam.com', 'coop', '$2a$10$JQXn/vrZQ9FlOFwqsPRHBObYfviXPhfQgt.tT46M/8po/Z1RVpeEu', false), -- Password: cooppassword
('kiwi@exam.com', 'kiwi', '$2a$10$OAqMkTYbq.n8vVEokOTvjOqxsRPoX6buGsQ3ORHAA2zw8TFZ/8gOC', false); -- Password: kiwipassword