package baseClass;
import baseClass.Consultatie;
import baseClass.Medic;
import baseClass.Pacient;
import states.StareProgramare;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConsultatieTest{

    @Test
    void testConstructorNoArgs() {
        Consultatie consultatie = new Consultatie();
        assertNotNull(consultatie.getPacient());
        assertNotNull(consultatie.getMedic());
        assertEquals("", consultatie.getDataOra());
        assertEquals(StareProgramare.Programat, consultatie.getStare());
    }

    @Test
    void testConstructorWithArgs() {
        Pacient pacient = new Pacient("Ion Popescu", "1234567890123");
        Medic medic = new Medic("Maria Ionescu", "9876543210123", "Cardiologie");
        Consultatie consultatie = new Consultatie(pacient, medic, "12/12/2024 10:30");

        assertEquals(pacient, consultatie.getPacient());
        assertEquals(medic, consultatie.getMedic());
        assertEquals("12/12/2024 10:30", consultatie.getDataOra());
    }

    @Test
    void testGetPacient() {
        Pacient pacient = new Pacient("Ion Popescu", "1234567890123");
        Consultatie consultatie = new Consultatie(pacient, new Medic(), "12/12/2024 10:30");

        assertEquals(pacient, consultatie.getPacient());
    }

    @Test
    void testGetMedic() {
        Medic medic = new Medic("Maria Ionescu", "9876543210123", "Cardiologie");
        Consultatie consultatie = new Consultatie(new Pacient(), medic, "12/12/2024 10:30");

        assertEquals(medic, consultatie.getMedic());
    }

    @Test
    void testGetDataOra() {
        Consultatie consultatie = new Consultatie(new Pacient(), new Medic(), "12/12/2024 10:30");
        assertEquals("12/12/2024 10:30", consultatie.getDataOra());
    }

    @Test
    void testGetStare() {
        Consultatie consultatie = new Consultatie();
        assertEquals(StareProgramare.Programat, consultatie.getStare());
    }

    @Test
    void testAfisareDetalii() {
        Pacient pacient = new Pacient("Ion Popescu", "1234567890123");
        Medic medic = new Medic("Maria Ionescu", "9876543210123", "Cardiologie");
        Consultatie consultatie = new Consultatie(pacient, medic, "12/12/2024 10:30");

        consultatie.afisareDetalii(); // This prints to console; verify manually or redirect output in advanced tests
    }

    @Test
    void testObtineDetalii() {
        Pacient pacient = new Pacient("Ion Popescu", "1234567890123");
        Medic medic = new Medic("Maria Ionescu", "9876543210123", "Cardiologie");
        Consultatie consultatie = new Consultatie(pacient, medic, "12/12/2024 10:30");

        String expectedDetails = "Consultatie: Pacient: Ion Popescu, Medic: Maria Ionescu, Data: 12/12/2024 10:30, Stare: Programat";
        assertEquals(expectedDetails, consultatie.obtineDetalii());
    }

    @Test
    void testEsteValid() {
        Pacient pacient = new Pacient("Ion Popescu", "1234567890123");
        Medic medic = new Medic("Maria Ionescu", "9876543210123", "Cardiologie");
        Consultatie consultatie = new Consultatie(pacient, medic, "12/12/2024 10:30");

        assertTrue(consultatie.esteValid());
    }

    @Test
    void testMesajEroare() {
        Pacient pacient = new Pacient("", "123"); // Invalid Pacient
        Medic medic = new Medic("Maria Ionescu", "9876543210123", "Cardiologie");
        Consultatie consultatie = new Consultatie(pacient, medic, "invalid_date");

        assertEquals("Pacientul nu este valid: CNP-ul trebuie să aibă 13 caractere!", consultatie.mesajEroare());
    }
}
