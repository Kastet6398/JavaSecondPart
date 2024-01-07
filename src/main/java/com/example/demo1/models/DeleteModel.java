package com.example.demo1.models;

import com.example.demo1.records.DatabaseConnection;
import com.example.demo1.ui.BaseController;

import java.sql.SQLException;

public class DeleteModel extends BaseModel {
    private final int id;

    public DeleteModel(BaseController controller, int id) {
        super(controller);
        this.id = id;
    }

    public Object execute() {
        try {
            DatabaseConnection.deleteData(id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        controller.updateUI();
        return null;
    }
}
