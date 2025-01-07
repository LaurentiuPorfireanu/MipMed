package baseClass;

public abstract class Persoana {
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }
    public String getNume() {
        return nume;
    }
    public String getCnp() {
        return cnp;
    }

    public abstract void afisareDetalii();
}
