package gestionari;

import baseClass.Consultatie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionareJSON {
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static void exportaProgramari(String filePath, List<Consultatie> programari) {
        try (FileWriter writer = new FileWriter(filePath)) {
            String json = gson.toJson(programari);
            writer.write(json); // Scrie JSON-ul în fișier
            System.out.println("Programările au fost salvate în JSON!");
        } catch (IOException e) {
            System.out.println("Eroare la salvarea în JSON: " + e.getMessage());
        }
    }


    public static List<Consultatie> importaProgramari(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Consultatie[] programariArray = gson.fromJson(reader, Consultatie[].class);
            return new ArrayList<>(List.of(programariArray));
        } catch (IOException e) {
            System.out.println("Eroare la încărcarea din JSON: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
