CREATE TABLE IF NOT EXISTS orders (
    id BIGSERIAL PRIMARY KEY,
    customerId BIGINT NOT NULL,
    productName VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    totalPrice DECIMAL(10, 2) NOT NULL,
    orderStatus VARCHAR(20) NOT NULL,
    orderDate DATE NOT NULL
);

INSERT INTO orders (customerId, productName, quantity, totalPrice, orderStatus, orderDate) VALUES 
(2, 'fish', 26, 7514.00, 'cancelled', '2025-02-22'),
(2, 'fish', 12, 3468.00, 'confirmed', '2025-02-23'),
(3, 'soda', 220, 3060.00, 'confirmed', '2025-02-23'),
(4, 'milk', 46, 828.00, 'confirmed', '2025-02-24');