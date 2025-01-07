package org.example.test;

import java.time.LocalDateTime;
import java.util.List;

import baseClass.*;
import gestionari.*;


public class Main {
    public static void main(String[] args) {
        // Creare pacienți
        Pacient pacient1 = new Pacient("Ion Popescu", "1234567890123");
        pacient1.adaugaIstoric("Hipertensiune");

        Pacient pacient2 = new Pacient("Maria Ionescu", "9876543210123");
        pacient2.adaugaIstoric("Diabet tip 2");

        // Creare medici
        Medic medic1 = new Medic("Dr. Ana Ionescu", "1234567899876", "Cardiologie");
        medic1.adaugaZiLucratoare("Luni");
        medic1.adaugaZiLucratoare("Miercuri");

        Medic medic2 = new Medic("Dr. Mihai Popa", "6543219876543", "Diabetologie");
        medic2.adaugaZiLucratoare("Marți");
        medic2.adaugaZiLucratoare("Joi");

        // Creare consultații
        String dataConsultatie1 = "28/11/2024 10:30";
        String dataConsultatie2 = "29/11/2024 14:00";

        Consultatie consultatie1 = new Consultatie(pacient1, medic1, dataConsultatie1);
        Consultatie consultatie2 = new Consultatie(pacient2, medic2, dataConsultatie2);

        // Gestionarea consultațiilor
        GestionareProgramari gestionare = new GestionareProgramari();
        gestionare.adaugaProgramare(consultatie1);
        gestionare.adaugaProgramare(consultatie2);

        // Afișare consultații
        System.out.println("Programări disponibile:");
        gestionare.afisareProgramari();

        // Salvare în JSON
        String filePath = "programari.json";
        GestionareJSON.exportaProgramari(filePath, gestionare.getProgramari());
        System.out.println("\nProgramările au fost salvate în fișierul programari.json.");

        // Încărcare din JSON
        List<Consultatie> programariImportate = GestionareJSON.importaProgramari(filePath);
        System.out.println("\nProgramări importate din fișierul JSON:");
        programariImportate.forEach(Consultatie::afisareDetalii);

        // Validare și afișare stări
        System.out.println("\nValidare consultații:");
        for (Consultatie consultatie : programariImportate) {
            consultatie.valideaza();
        }
    }
}