package baseClass;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MedicTest {

    @Test
    void testConstructor() {
        Medic medic = new Medic("Maria Ionescu", "9876543210123", "Cardiologie");
        assertEquals("Maria Ionescu", medic.getNume());
        assertEquals("9876543210123", medic.getCnp());
        assertEquals("Cardiologie", medic.getSpecializare());
    }

    @Test
    void testAdaugaZiLucratoare() {
        Medic medic = new Medic();
        medic.adaugaZiLucratoare("Luni");
        assertTrue(medic.getZileLucratoare().contains("Luni"));
    }

    @Test
    void testEsteValid() {
        Medic medic = new Medic("Maria Ionescu", "9876543210123", "Cardiologie");
        assertTrue(medic.esteValid());
    }

    @Test
    void testMesajEroare() {
        Medic medic = new Medic("", "123", ""); // Invalid Medic
        assertEquals("CNP-ul trebuie să aibă 13 caractere!", medic.mesajEroare());
    }
}
