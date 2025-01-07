package baseClass;

import java.util.ArrayList;
import java.util.List;
import baseClass.Persoana;
import interfaces.*;


public class Pacient extends Persoana implements Afisabil, Validabil {
    private List<String> istoricMedical;

    public Pacient() {
        super("", "");
        this.istoricMedical = new ArrayList<>();
    }

    public Pacient(String nume,String cnp) {
        super(nume,cnp);
        this.istoricMedical = new ArrayList<>();
    }

    public void adaugaIstoric(String detaliu)
    {
        istoricMedical.add(detaliu);
    }

    public List<String> getIstoricMedical() {
        return istoricMedical;
    }

    @Override
    public void afisareDetalii() {
        System.out.println(obtineDetalii());
    }

    @Override
    public String obtineDetalii() {
        return "Pacient: " + getNume() + ", CNP: " + getCnp() + ", Istoric medical: " + getIstoricMedical();
    }

    @Override
    public boolean esteValid() {
        return getCnp().length() == 13 && !getNume().isEmpty();
    }

    @Override
    public String mesajEroare() {
        if (getCnp().length() != 13) {
            return "CNP-ul trebuie să aibă 13 caractere!";
        } else if (getNume().isEmpty()) {
            return "Numele pacientului nu poate fi gol!";
        }
        return "Obiect valid!";
    }
}
