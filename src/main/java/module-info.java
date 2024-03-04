module com.example.keytyper {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.jetbrains.annotations;
    requires com.fasterxml.jackson.databind;

    exports com.example.keytyper.controllers;
    opens com.example.keytyper.controllers to javafx.fxml;
    exports com.example.keytyper.views;
    opens com.example.keytyper.views to javafx.fxml;
}
