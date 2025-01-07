package interfaces;

public interface Validabil {
    public boolean esteValid();
    public String mesajEroare();
    public default void valideaza() {
        if (!esteValid()) {
            System.out.println("Eroare: " + mesajEroare());
        } else {
            System.out.println("Obiect valid!");
        }
    }
}