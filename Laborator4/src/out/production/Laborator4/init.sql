DROP DATABASE IF EXISTS magazin;
CREATE DATABASE magazin;
USE magazin;

CREATE TABLE produse (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         denumire VARCHAR(100),
                         pret DOUBLE
);

INSERT INTO produse (denumire, pret) VALUES
                                         ('Lapte', 4.5),
                                         ('Paine', 2.0),
                                         ('Branza', 10.5),
                                         ('Apa', 1.5);
