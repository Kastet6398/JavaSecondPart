package com.example.demo1.models;

import com.example.demo1.records.DatabaseConnection;
import javafx.scene.web.WebView;

import java.sql.SQLException;
import java.util.Objects;

public class ReadModel extends BaseModel {
    private final WebView webView;
    private final int id;

    public ReadModel(WebView webView, int id) {
        super(null);
        this.webView = webView;
        this.id = id;
    }

    public Object execute() {
        try {
            webView.getEngine().loadContent(Objects.requireNonNull(DatabaseConnection.getTaskById(id)).text());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
