package Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Utile.DatabaseConnection;

public class ClientRepo {

    public static void afiseazaClientiCuMaiMulteComenzi() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT c.idClient, c.nume, c.email, COUNT(cm.idComanda) AS nr_comenzi " +
                    "FROM clienti c " +
                    "JOIN comenzi cm ON c.idClient = cm.idClient " +
                    "GROUP BY c.idClient " +
                    "HAVING COUNT(cm.idComanda) > 1";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\nClienți cu mai mult de 1 comandă:");
            while (rs.next()) {
                int id = rs.getInt("idClient");
                String nume = rs.getString("nume");
                String email = rs.getString("email");
                int nr = rs.getInt("nr_comenzi");

                System.out.println("- " + nume + " (" + email + ") -> " + nr + " comenzi");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
