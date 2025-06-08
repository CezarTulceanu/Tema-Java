package Repositories;

import Entitati.Produs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.*;

import Utile.DatabaseConnection;


import static Utile.Constante.NUME_FISIER;
import static Utile.FilesUtils.citesteProduse;

public class ProdusRepo {
    public static List<Produs> produse;

    public static List<Produs> getProduse() throws IOException {
        return citesteProduse(NUME_FISIER);
    }

    //Cerinta 1

    public static Map<Integer, AbstractMap.SimpleEntry<Double, String>> getProduseMap() {
        Map<Integer, AbstractMap.SimpleEntry<Double, String>> map = new HashMap<>();

        try {
            Connection conn = Utile.DatabaseConnection.getConnection();
            String sql = "SELECT id, denumire, pret FROM produse";
            var stmt = conn.prepareStatement(sql);
            var rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String denumire = rs.getString("denumire");
                double pret = rs.getDouble("pret");

                map.put(id, new AbstractMap.SimpleEntry<>(pret, denumire));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

}
