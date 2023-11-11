module com.example.brunasilva_comp228lab4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.brunasilva_comp228lab4 to javafx.fxml;
    exports com.example.brunasilva_comp228lab4;
}