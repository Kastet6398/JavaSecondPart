package com.example.demo1.models;

import com.example.demo1.records.DatabaseConnection;
import javafx.scene.web.HTMLEditor;

import java.sql.SQLException;

public class EditModel extends BaseModel {
    private final int id;
    private final HTMLEditor editor;

    public EditModel(int id, HTMLEditor editor) {
        super(null);

        this.id = id;
        this.editor = editor;
    }

    public Object execute() {
        try {
            DatabaseConnection.updateData(editor.getHtmlText(), id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

}
