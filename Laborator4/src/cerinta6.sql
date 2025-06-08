USE magazin;


INSERT INTO comenzi (idComanda, data, status, idClient) VALUES
    (104, '2025-06-08 15:00:00', 'PROCESAT', 1);

INSERT INTO comenzi_produse (idComanda, idProdus) VALUES
                                                      (104, 2),
                                                      (104, 3);
