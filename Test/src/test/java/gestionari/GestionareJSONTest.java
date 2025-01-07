package gestionari;
import baseClass.Consultatie;
import baseClass.Medic;
import baseClass.Pacient;
import gestionari.GestionareJSON;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestionareJSONTest {

    @Test
    void testExportaProgramari() throws Exception {
        Path permanentFilePath = Paths.get("test_output_programari.json");
        Pacient pacient = new Pacient("Ion Popescu", "1234567890123");
        Medic medic = new Medic("Maria Ionescu", "9876543210123", "Cardiologie");
        Consultatie consultatie = new Consultatie(pacient, medic, "12/12/2024 10:30");

        GestionareJSON.exportaProgramari(permanentFilePath.toString(), List.of(consultatie));

        assertTrue(Files.exists(permanentFilePath), "The JSON file should be created.");
        String jsonContent = Files.readString(permanentFilePath);
        assertTrue(jsonContent.contains("Ion Popescu"));
        assertTrue(jsonContent.contains("Maria Ionescu"));
        assertTrue(jsonContent.contains("12/12/2024 10:30"));


        System.out.println("Exported JSON saved to: " + permanentFilePath.toAbsolutePath());
    }

    @Test
    void testImportaProgramari() throws Exception {

        Path permanentFilePath = Paths.get("test_output_programari.json");


        assertTrue(Files.exists(permanentFilePath), "The JSON file for import should exist.");


        List<Consultatie> programari = GestionareJSON.importaProgramari(permanentFilePath.toString());


        assertEquals(1, programari.size());
        Consultatie consultatie = programari.get(0);
        assertEquals("Ion Popescu", consultatie.getPacient().getNume());
        assertEquals("Maria Ionescu", consultatie.getMedic().getNume());
        assertEquals("12/12/2024 10:30", consultatie.getDataOra());
    }
}
