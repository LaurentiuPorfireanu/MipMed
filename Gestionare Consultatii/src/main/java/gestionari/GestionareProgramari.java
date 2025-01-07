package gestionari;

import baseClass.Consultatie;

import java.util.ArrayList;
import java.util.List;

public class GestionareProgramari {
    private List<Consultatie> programari;

    public GestionareProgramari() {
        this.programari = new ArrayList<>();
    }

    public void adaugaProgramare(Consultatie programare) {
        programari.add(programare);
    }

    public void afisareProgramari() {
        programari.forEach(Consultatie::afisareDetalii);
    }

    public List<Consultatie> getProgramari() {
        return programari;
    }
}