open module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires datetime.picker.javafx;
    requires javafx.media;
    requires sigar;
    requires commons.daemon;
    requires jdk.unsupported;
    requires java.management;

    exports com.example.demo1.models;
    exports com.example.demo1.records;
    exports com.example.demo1.ui;
    exports com.example.demo1;
}
