DROP DATABASE IF EXISTS magazin;
CREATE DATABASE magazin;
USE magazin;

CREATE TABLE produse (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         denumire VARCHAR(100),
                         pret DOUBLE
);

DELETE FROM produse;





