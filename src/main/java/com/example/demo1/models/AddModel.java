package com.example.demo1.models;

import com.browniebytes.javafx.control.DateTimePicker;
import com.example.demo1.Id;
import com.example.demo1.records.DatabaseConnection;
import com.example.demo1.ui.BaseController;
import javafx.scene.web.HTMLEditor;

import java.sql.SQLException;
import java.sql.Timestamp;

public class AddModel extends BaseModel {
    public AddModel(BaseController controller) {
        super(controller);
    }

    public Object execute() {
        try {
            String date = ((DateTimePicker) (controller.getField(Id.DATE_PICKER))).getTime("yyyy-MM-dd HH:mm:ss");
            DatabaseConnection.insertData(((HTMLEditor) (controller.getField(Id.ADD_FIELD))).getHtmlText(), Timestamp.valueOf(date));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        controller.updateUI();
        return null;
    }
}
