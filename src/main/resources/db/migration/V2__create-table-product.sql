CREATE TABLE product (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         id_sup INT,
                         FOREIGN KEY (id_sup) REFERENCES supplier(id_sup)
);
