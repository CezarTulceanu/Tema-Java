USE magazin;

INSERT INTO produse (denumire, pret) VALUES
                                         ('Lapte', 4.5),
                                         ('Paine', 2.0),
                                         ('Branza', 10.5),
                                         ('Apa', 1.5),
                                         ('Oua', 8.0);

#Cerinta 3

CREATE TABLE IF NOT EXISTS comenzi (
                                       idComanda INT PRIMARY KEY,
                                       data DATETIME,
                                       status VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS comenzi_produse (
                                               idComanda INT,
                                               idProdus INT,
                                               FOREIGN KEY (idComanda) REFERENCES comenzi(idComanda),
                                               FOREIGN KEY (idProdus) REFERENCES produse(id)
);

INSERT INTO comenzi (idComanda, data, status) VALUES
                                                  (101, '2025-06-08 10:00:00', 'NEPROCESAT'),
                                                  (102, '2025-06-08 11:00:00', 'PROCESAT'),
                                                  (103, '2025-06-08 12:00:00', 'LIVRAT');

INSERT INTO comenzi_produse (idComanda, idProdus) VALUES
                                                      (101, 1),
                                                      (101, 2),
                                                      (102, 3),
                                                      (102, 4),
                                                      (103, 1),
                                                      (103, 5);
