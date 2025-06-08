USE magazin;

INSERT INTO clienti (idClient, nume, email, varsta, oras) VALUES
    (10, 'Florin Vasile', 'florin@gmail.com', 28, 'Brașov');

INSERT INTO comenzi (idComanda, data, status, idClient) VALUES
    (201, '2025-06-08 18:00:00', 'NEPROCESAT', 10);

INSERT INTO comenzi_produse (idComanda, idProdus) VALUES
                                                      (201, 1),
                                                      (201, 4),
                                                      (201, 5);

INSERT INTO comenzi (idComanda, data, status, idClient) VALUES
    (202, '2025-06-08 19:00:00', 'PROCESAT', 10);

INSERT INTO comenzi_produse (idComanda, idProdus) VALUES
                                                      (202, 2),
                                                      (202, 3);

INSERT INTO comenzi (idComanda, data, status, idClient) VALUES
    (203, '2025-06-08 20:00:00', 'LIVRAT', 10);

INSERT INTO comenzi_produse (idComanda, idProdus) VALUES
                                                      (203, 1),
                                                      (203, 5);

