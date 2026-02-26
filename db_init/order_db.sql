CREATE TABLE IF NOT EXISTS orders (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    product_name VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    order_status VARCHAR(20) NOT NULL,
    order_date DATE NOT NULL
);

INSERT INTO orders (customer_id, product_name, quantity, total_price, order_status, order_date) VALUES 
(2, 'fish', 26, 7514.00, 'cancelled', '2025-02-22'),
(2, 'fish', 12, 3468.00, 'confirmed', '2025-02-23'),
(3, 'soda', 220, 3060.00, 'confirmed', '2025-02-23'),
(4, 'milk', 46, 828.00, 'confirmed', '2025-02-24');