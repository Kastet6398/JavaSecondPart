package com.example.demo1.models;

import com.example.demo1.Id;
import com.example.demo1.ui.BaseController;
import com.example.demo1.records.DatabaseConnection;
import com.example.demo1.records.Task;
import javafx.css.PseudoClass;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.web.HTMLEditor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BrowseModel extends BaseModel {
    private final ListView<Node> listView;
    private final double width;
    public BrowseModel(BaseController controller) {
        super(controller);
        listView = (ListView<Node>) controller.getField(Id.LIST_VIEW);
        width =  listView.getPrefWidth();
    }

    public Object execute() {
        listView.getItems().clear();
        try {
            List<Task> data = DatabaseConnection.retrieveData();
            List<HTMLEditor> editors = new ArrayList<>();
            for (Task taskData : data) {
                HTMLEditor task = new HTMLEditor();
                task.setPrefHeight(200);
                task.setPrefWidth(width);
                task.setHtmlText(taskData.text());
                editors.add(task);

                Button deleteButton = new Button("Delete");
                deleteButton.setPrefWidth(width);
                deleteButton.pseudoClassStateChanged(PseudoClass.getPseudoClass("error"), true);
                BaseModel model = new DeleteModel(controller, taskData.id());
                deleteButton.setOnMouseClicked(_ -> model.execute());

                listView.getItems().add(task);
                listView.getItems().add(deleteButton);
                listView.getItems().add(new Separator(Orientation.HORIZONTAL));
            }

            Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new ControlHTMLEditorContentChangedModel(editors, data)::execute, 0, 100, TimeUnit.MILLISECONDS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
