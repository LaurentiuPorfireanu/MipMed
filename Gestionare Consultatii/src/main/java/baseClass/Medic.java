package baseClass;

import java.util.Set;
import java.util.HashSet;
import baseClass.Persoana;
import interfaces.*;

public class Medic extends Persoana implements Afisabil,Validabil {
    private String specializare;
    private Set<String> zileLucratoare;

    public Medic() {
        super("", "");
        this.specializare = "";
        this.zileLucratoare = new HashSet<>();
    }

    public Medic(String nume,String cnp,String specializare) {
        super(nume,cnp);
        this.specializare = specializare;
        zileLucratoare = new HashSet<>();
    }


    public Set<String> getZileLucratoare() {
        return zileLucratoare;
    }

    public void adaugaZiLucratoare(String zi) {
        zileLucratoare.add(zi);
    }
    public String getSpecializare() {
        return specializare;
    }

    @Override
    public void afisareDetalii() {
        System.out.println(obtineDetalii());
    }

    @Override
    public String obtineDetalii() {
        return "Medic: " + getNume() + ", CNP: " + getCnp() + ", Specializare: " + getSpecializare() +
                ", Zile lucrătoare: " + getZileLucratoare();
    }

    @Override
    public boolean esteValid() {
        return getCnp().length() == 13 && !getNume().isEmpty() && !getSpecializare().isEmpty();
    }

    @Override
    public String mesajEroare() {
        if (getCnp().length() != 13) {
            return "CNP-ul trebuie să aibă 13 caractere!";
        } else if (getNume().isEmpty()) {
            return "Numele medicului nu poate fi gol!";
        } else if (getSpecializare().isEmpty()) {
            return "Specializarea medicului nu poate fi goală!";
        }
        return "Obiect valid!";
    }
}
