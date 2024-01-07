package com.example.demo1.ui;

import com.example.demo1.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.web.HTMLEditor;
import com.browniebytes.javafx.control.DateTimePicker;

public class TasksController extends BaseController {
    @FXML
    public DateTimePicker datePicker;
    private BaseModel model;
    @FXML
    public HTMLEditor addField;
    @FXML
    public ListView<javafx.scene.Node> listView;

    @Override
    public void updateUI() {
        model = new AddModel(this);
        BaseModel model2 = new BrowseModel(this);
        model2.execute();
        BaseModel model3 = new BackgroundThreadModel(this);
        model3.execute();
    }

    @FXML
    protected void onAddButtonClicked() {
        model.execute();
    }
}