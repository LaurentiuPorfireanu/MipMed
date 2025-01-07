package gestionari;

import baseClass.Consultatie;
import baseClass.Medic;
import baseClass.Pacient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestionareProgramariTest {

    @Test
    void testAdaugaProgramare() {
        GestionareProgramari gestionare = new GestionareProgramari();
        Pacient pacient = new Pacient("Ion Popescu", "1234567890123");
        Medic medic = new Medic("Maria Ionescu", "9876543210123", "Cardiologie");
        Consultatie consultatie = new Consultatie(pacient, medic, "12/12/2024 10:30");

        gestionare.adaugaProgramare(consultatie);

        assertEquals(1, gestionare.getProgramari().size());
        assertEquals(consultatie, gestionare.getProgramari().get(0));
    }

    @Test
    void testAfisareProgramari() {
        GestionareProgramari gestionare = new GestionareProgramari();
        Pacient pacient = new Pacient("Ion Popescu", "1234567890123");
        Medic medic = new Medic("Maria Ionescu", "9876543210123", "Cardiologie");
        Consultatie consultatie1 = new Consultatie(pacient, medic, "12/12/2024 10:30");
        Consultatie consultatie2 = new Consultatie(new Pacient("Vasile Popa", "9876543210123"), medic, "13/12/2024 11:00");

        gestionare.adaugaProgramare(consultatie1);
        gestionare.adaugaProgramare(consultatie2);

      
        gestionare.afisareProgramari();
    }

    @Test
    void testGetProgramari() {
        GestionareProgramari gestionare = new GestionareProgramari();
        Pacient pacient = new Pacient("Ion Popescu", "1234567890123");
        Medic medic = new Medic("Maria Ionescu", "9876543210123", "Cardiologie");
        Consultatie consultatie = new Consultatie(pacient, medic, "12/12/2024 10:30");

        gestionare.adaugaProgramare(consultatie);

        assertEquals(1, gestionare.getProgramari().size());
        assertTrue(gestionare.getProgramari().contains(consultatie));
    }
}
