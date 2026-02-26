CREATE TABLE IF NOT EXISTS notifications (
    id SERIAL PRIMARY KEY,
    orderId INT NOT NULL
    customerId INT NOT NULL,
    orderDate DATE NOT NULL,
    productName VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    totalPrice DECIMAL(10, 2) NOT NULL
);

INSERT INTO notifications (orderId, customerId, orderDate, productName, quantity, totalPrice) VALUES 
(1, 2, '2026-02-28', 'fish', 12, 3468.00),
(2, 3, '2026-02-28', 'soda', 220, 3060.00),
(3, 4, '2026-02-29', 'milk', 46, 828.00);