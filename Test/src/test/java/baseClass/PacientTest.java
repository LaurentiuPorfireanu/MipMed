package baseClass;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PacientTest {

    @Test
    void testAdaugaIstoric() {
        Pacient pacient = new Pacient("Ion Popescu", "1234567890123");
        pacient.adaugaIstoric("Alergie la polen");

        assertTrue(pacient.getIstoricMedical().contains("Alergie la polen"));
    }

    @Test
    void testEsteValid() {
        Pacient pacient = new Pacient("Ion Popescu", "1234567890123");
        assertTrue(pacient.esteValid());
    }

    @Test
    void testMesajEroare() {
        Pacient pacient = new Pacient("", "123"); // Invalid Pacient
        assertEquals("CNP-ul trebuie să aibă 13 caractere!", pacient.mesajEroare());
    }
}
