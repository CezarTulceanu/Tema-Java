package Utile;

import Entitati.Produs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilesUtils {
    public static List<Produs> citesteProduse(String numeFisier) throws IOException {
        List<Produs> listaProduse = new ArrayList<>();

        InputStream is = FilesUtils.class.getClassLoader().getResourceAsStream(numeFisier);
        if (is == null) {
            throw new FileNotFoundException("Fișierul nu a fost găsit: " + numeFisier);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = br.readLine()) != null) {
            String[] vector = line.split(",");
            Produs produs = new Produs(vector[0], (double) Float.parseFloat(vector[1]));
            listaProduse.add(produs);
        }
        return listaProduse;
    }
}
