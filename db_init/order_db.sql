CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL,
    order_date DATE NOT NULL,
    order_status VARCHAR(20) NOT NULL,
    product VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL
);

INSERT INTO orders (customer_id, order_date, order_status, product, quantity, total_price) VALUES 
(2, '2025-02-22', 'cancelled', 'fish', 26, 7514.00),
(2, '2025-02-23', 'confirmed', 'fish', 12, 3468.00),
(3, '2025-02-23', 'confirmed', 'soda', 220, 3060.00),
(4, '2025-02-24', 'confirmed', 'milk', 46, 828.00);