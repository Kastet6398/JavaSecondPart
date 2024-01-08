package com.example.demo1.models;

import com.example.demo1.records.DatabaseConnection;
import com.example.demo1.records.Task;
import com.example.demo1.ui.BaseController;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;

import java.sql.SQLException;
import java.util.List;


public class BackgroundThreadModel extends BaseModel {
    private static final BaseModel soundModel = new SoundModel();
    public BackgroundThreadModel(BaseController controller) {
        super(controller);
    }

    @Override
    public Object execute() {
        new Thread(() -> {
            while (true) {
                try {
                    List<Task> fetched = DatabaseConnection.retrieveData();

                    for (Task t : fetched) {
                        if (!t.isShown()) {
                            long timestampSeconds = t.timestamp().getTime();
                            long currentSeconds = System.currentTimeMillis();
                            if (currentSeconds >= timestampSeconds) {
                                try {
                                    DatabaseConnection.setShown(t.id());
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                                soundModel.execute();
                                Platform.runLater(() -> {
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Task!");
                                    alert.setHeaderText("Task!");
                                    GridPane expContent = new GridPane();
                                    WebView webView = new WebView();
                                    new ReadModel(webView, t.id()).execute();
                                    expContent.setMaxWidth(Double.MAX_VALUE);
                                    expContent.add(webView, 0, 0);
                                    alert.getDialogPane().setExpandableContent(expContent);
                                    alert.show();
                                });
                            }
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        return null;
    }
}
