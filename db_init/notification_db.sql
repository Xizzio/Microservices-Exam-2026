CREATE TABLE IF NOT EXISTS notifications (
    id SERIAL PRIMARY KEY,
    order_id INT NOT NULL
    customer_id INT NOT NULL,
    order_date DATE NOT NULL,
    product_name VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL
);

INSERT INTO notifications (order_id, customer_id, order_date, product_name, quantity, total_price) VALUES 
(1, 2, '2026-02-28', 'fish', 12, 3468.00),
(2, 3, '2026-02-28', 'soda', 220, 3060.00),
(3, 4, '2026-02-29', 'milk', 46, 828.00);