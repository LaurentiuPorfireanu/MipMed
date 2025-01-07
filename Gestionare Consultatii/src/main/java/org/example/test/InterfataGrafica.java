package org.example.test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import gestionari.*;
import baseClass.*;

import java.util.List;

public class InterfataGrafica extends Application {
    private GestionareProgramari gestionare = new GestionareProgramari();
    private final String jsonFilePath = "programari_interfata.json"; // Locația fișierului JSON

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestionare Programări Medicale");

        // Elemente UI
        Label lblPacient = new Label("Nume Pacient:");
        TextField tfPacient = new TextField();

        Label lblCNP = new Label("CNP Pacient:");
        TextField tfCNP = new TextField();

        Label lblMedic = new Label("Nume Medic:");
        TextField tfMedic = new TextField();

        Label lblCNPMedic = new Label("CNP Medic:");
        TextField tfCNPMedic = new TextField();

        Label lblSpecializare = new Label("Specializare Medic:");
        TextField tfSpecializare = new TextField();

        Label lblDataOra = new Label("Data și Ora (dd/MM/yyyy HH:mm):");
        TextField tfDataOra = new TextField();

        Button btnAdauga = new Button("Adaugă Consultație");
        Button btnAfiseaza = new Button("Afișează Consultații");
        Button btnSalveaza = new Button("Salvează în JSON");
        Button btnIncarca = new Button("Încarcă din JSON");

        TextArea taAfisare = new TextArea();
        taAfisare.setEditable(false);

        // Layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(lblPacient, 0, 0);
        gridPane.add(tfPacient, 1, 0);
        gridPane.add(lblCNP, 0, 1);
        gridPane.add(tfCNP, 1, 1);
        gridPane.add(lblMedic, 0, 2);
        gridPane.add(tfMedic, 1, 2);
        gridPane.add(lblCNPMedic, 0, 3);
        gridPane.add(tfCNPMedic, 1, 3);
        gridPane.add(lblSpecializare, 0, 4);
        gridPane.add(tfSpecializare, 1, 4);
        gridPane.add(lblDataOra, 0, 5);
        gridPane.add(tfDataOra, 1, 5);
        gridPane.add(btnAdauga, 0, 6);
        gridPane.add(btnAfiseaza, 1, 6);
        gridPane.add(btnSalveaza, 0, 7);
        gridPane.add(btnIncarca, 1, 7);

        VBox vbox = new VBox(10, gridPane, taAfisare);
        vbox.setPadding(new Insets(10));

        //  butonului "Adaugă Consultație"
        btnAdauga.setOnAction(e -> {
            String numePacient = tfPacient.getText();
            String cnpPacient = tfCNP.getText();
            String numeMedic = tfMedic.getText();
            String cnpMedic = tfCNPMedic.getText();
            String specializare = tfSpecializare.getText();
            String dataOra = tfDataOra.getText();

            if (numePacient.isEmpty() || cnpPacient.isEmpty() || numeMedic.isEmpty() || cnpMedic.isEmpty() || specializare.isEmpty() || dataOra.isEmpty()) {
                taAfisare.setText("Toate câmpurile trebuie completate!");
                return;
            }

            if (!cnpPacient.matches("\\d{13}")) { // Validare CNP pacient
                taAfisare.setText("CNP-ul pacientului trebuie să conțină exact 13 cifre!");
                return;
            }

            if (!cnpMedic.matches("\\d{13}")) { // Validare CNP medic
                taAfisare.setText("CNP-ul medicului trebuie să conțină exact 13 cifre!");
                return;
            }

            Pacient pacient = new Pacient(numePacient, cnpPacient);
            Medic medic = new Medic(numeMedic, cnpMedic, specializare);
            Consultatie consultatie = new Consultatie(pacient, medic, dataOra);

            if (consultatie.esteValid()) {
                gestionare.adaugaProgramare(consultatie);
                taAfisare.setText("Consultația a fost adăugată cu succes!");
                tfPacient.clear();
                tfCNP.clear();
                tfMedic.clear();
                tfCNPMedic.clear();
                tfSpecializare.clear();
                tfDataOra.clear();
            } else {
                taAfisare.setText("Consultația este invalidă: " + consultatie.mesajEroare());
            }
        });

        //  butonului "Afișează Consultații"
        btnAfiseaza.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            gestionare.getProgramari().forEach(c -> sb.append(c.obtineDetalii()).append("\n"));
            taAfisare.setText(sb.toString());
        });

        //  butonului "Salvează în JSON"
        btnSalveaza.setOnAction(e -> {
            GestionareJSON.exportaProgramari(jsonFilePath, gestionare.getProgramari());
            taAfisare.setText("Programările au fost salvate în fișierul JSON.");
        });

        //  butonului "Încarcă din JSON"
        btnIncarca.setOnAction(e -> {
            List<Consultatie> programariImportate = GestionareJSON.importaProgramari(jsonFilePath);
            if (programariImportate.isEmpty()) {
                taAfisare.setText("Nu există programări în fișierul JSON.");
            } else {
                gestionare.getProgramari().clear();
                gestionare.getProgramari().addAll(programariImportate);
                taAfisare.setText("Programările au fost încărcate din fișierul JSON.");
            }
        });


        Scene scene = new Scene(vbox, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
