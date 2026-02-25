CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    product_name VARCHAR(50) NOT NULL UNIQUE,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

INSERT INTO products (product_name, quantity, price) VALUES 
('fish', 54, 289.00),
('meat', 67, 62.00),
('cheese', 78, 24.00),
('soda', 1780, 14.00),
('bread', 506, 36.00),
('milk', 304, 18.00),
('eggs', 782, 28.00),
('fruits', 1680, 6.00),
('vegetables', 1220, 12.00),
('cereal', 340, 27.00),
('coffee', 4525, 63.00),
('tea', 6740, 47.00),
('chocolate', 747, 45.00),
('chips', 902, 28.00),
('ice cream', 2640, 53.00),
('frozen pizza', 3165, 76.00),
('pasta', 2107, 24.00),
('rice', 4152, 48.00);