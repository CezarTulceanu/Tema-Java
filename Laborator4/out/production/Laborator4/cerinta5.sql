USE magazin;

CREATE TABLE IF NOT EXISTS clienti (
                                       idClient INT PRIMARY KEY,
                                       nume VARCHAR(100),
    email VARCHAR(100),
    varsta INT,
    oras VARCHAR(100)
    );

ALTER TABLE comenzi
    ADD COLUMN idClient INT,
ADD CONSTRAINT fk_client_comanda FOREIGN KEY (idClient) REFERENCES clienti(idClient);

INSERT INTO clienti (idClient, nume, email, varsta, oras) VALUES
                                                              (1, 'Ion Popescu', 'ion@gmail.com', 30, 'Bucuresti'),
                                                              (2, 'Maria Ionescu', 'maria@yahoo.com', 25, 'Ploiesti'),
                                                              (3, 'George Enescu', 'george@music.ro', 40, 'Cluj');

UPDATE comenzi SET idClient = 1 WHERE idComanda = 101;
UPDATE comenzi SET idClient = 2 WHERE idComanda = 102;
UPDATE comenzi SET idClient = 3 WHERE idComanda = 103;

