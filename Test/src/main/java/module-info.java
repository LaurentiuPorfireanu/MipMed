module org.example.test {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires junit;


    opens org.example.test to javafx.fxml;
    exports org.example.test;
    opens baseClass to com.google.gson;
    opens gestionari to com.google.gson;
    opens states to com.google.gson;
}