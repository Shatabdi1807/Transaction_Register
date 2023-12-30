CREATE DATABASE kiranaregisterdb;

CREATE TABLE kiranaregisterdb.kirana_transactions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    type VARCHAR(8) NOT NULL
);

select * from kiranaregisterdb.kirana_transactions;