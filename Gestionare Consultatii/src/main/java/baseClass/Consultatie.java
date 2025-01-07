package baseClass;


import states.StareProgramare;

import interfaces.*;


public class Consultatie implements Afisabil, Validabil {
    private Pacient pacient;
    private Medic medic;
    private String dataOra;
    private StareProgramare stare;


    public Consultatie() {
        this.pacient = new Pacient();
        this.medic = new Medic();
        this.dataOra = "";
        this.stare = StareProgramare.Programat;
    }

    public Consultatie(Pacient pacient, Medic medic, String dataOra) {
        this.pacient = pacient;
        this.medic = medic;
        this.dataOra = dataOra;
        this.stare = StareProgramare.Programat;
    }
    public Pacient getPacient() {
        return pacient;
    }

    public Medic getMedic() {
        return medic;
    }

    public String getDataOra() {
        return dataOra;
    }

    public StareProgramare getStare() {
        return stare;
    }
    @Override
    public void afisareDetalii() {
        System.out.println(obtineDetalii());
    }

    @Override
    public String obtineDetalii() {
        return "Consultatie: Pacient: " + getPacient().getNume() + ", Medic: " + getMedic().getNume() +
                ", Data: " + getDataOra() + ", Stare: " + getStare();
    }

    @Override
    public boolean esteValid() {
        String regex = "\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}";
        return getPacient().esteValid() && getMedic().esteValid() && getDataOra().matches(regex);
    }

    @Override
    public String mesajEroare() {
        if (!getPacient().esteValid()) {
            return "Pacientul nu este valid: " + getPacient().mesajEroare();
        } else if (!getMedic().esteValid()) {
            return "Medicul nu este valid: " + getMedic().mesajEroare();
        } else if (!getDataOra().matches("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}")) {
            return "Data consultației trebuie să respecte formatul dd/MM/yyyy HH:mm!";
        }
        return "Obiect valid!";
    }
}