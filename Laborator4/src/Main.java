import Entitati.Client;
import Entitati.Comanda;
import Entitati.Produs;
import Repositories.ProdusRepo;
import Servicii.ServiciuClientImplementation;

import java.io.IOException;
import java.util.*;
import Utile.FilesUtils;

import static Repositories.ComandaRepo.getComenzi;

import static Repositories.ComandaRepo.afiseazaComenziCuProduse;

import static Repositories.ClientRepo.afiseazaClientiCuMaiMulteComenzi;


public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IOException {
        Client client1 = new Client("Popescu Ion", "ion@gmail.com", 15, "Bucuresti");
        Client client2 = new Client("Ionescu George", "georg@gmail.com", 25, "Ploiesti");
        Client client3 = new Client("Ion Marcel", "marcel@yahoo.com", 30, "Constanta");
        Client client4 = new Client("Popescu Ion", "ion@gmail.com", 15, "Bucuresti");
        Client client5 = new Client("Ionescu George", "georg@gmail.com", 25, "Ploiesti");
        Client client6 = new Client("Ion Marcel", "marcel@yahoo.com", 30, "Constanta");

        List<Produs> produse = FilesUtils.citesteProduse("Resources/produse.txt");
        Collections.sort(produse);

        List<Client> clienti = new ArrayList<>();
        clienti.add(client1);
        clienti.add(client2);
        clienti.add(client3);
        clienti.add(client4);
        clienti.add(client5);
        clienti.add(client6);

        Collections.sort(clienti);

        //Cerinta 1 VEZI PRODUS REPO

        Map<String, List<Comanda>> gestionareClienti = new HashMap<>();
        for (Client client : clienti) {
            String key = client.getEmail();
            if (gestionareClienti.containsKey(key)) {
                List<Comanda> comenziPerClient = new ArrayList<>(gestionareClienti.get(key));
                comenziPerClient.addAll(client.getComenzi());
                gestionareClienti.put(key, comenziPerClient);
            } else gestionareClienti.put(key, client.getComenzi());
        }

        Map<Integer, AbstractMap.SimpleEntry<Double, String>> produseMap = ProdusRepo.getProduseMap();


        for (Map.Entry<Integer, AbstractMap.SimpleEntry<Double, String>> entry : produseMap.entrySet()) {
            int id = entry.getKey();
            double pret = entry.getValue().getKey();
            String denumire = entry.getValue().getValue();

            System.out.println("ID: " + id + ", Denumire: " + denumire + ", Pret: " + pret);
        }

        if (produseMap.containsKey(1)) {
            produseMap.put(1, new AbstractMap.SimpleEntry<>(999.99, produseMap.get(1).getValue()));
        }

        if (produseMap.containsKey(2)) {
            produseMap.put(2, new AbstractMap.SimpleEntry<>(123.45, produseMap.get(2).getValue()));
        }


        //Cerinta 2

        System.out.println("---- După modificare ----");
        for (Map.Entry<Integer, AbstractMap.SimpleEntry<Double, String>> entry : produseMap.entrySet()) {
            int id = entry.getKey();
            double pret = entry.getValue().getKey();
            String denumire = entry.getValue().getValue();

            System.out.println("ID: " + id + ", Denumire: " + denumire + ", Pret: " + pret);
        }
        //Cerinta 3 VEZI CERINTA3.sql

        //Cerinta 4 VEZI COMANDAREPO

        afiseazaComenziCuProduse();

        //Cerinta 5 VEZI CERINTA5.sqp

        //Cerinta 6 VEZI CLIENTREPO
        afiseazaClientiCuMaiMulteComenzi();

        //Cerinta 7 VEZI CERINTA7.sql

        //System.out.println(gestionareClienti);
    }
}
