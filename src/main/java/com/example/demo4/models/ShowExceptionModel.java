package com.example.demo4.models;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ShowExceptionModel extends BaseModel<Void> {

    private static final String DEFAULT_HEADER = "An unknown error occurred";

    private static final String DEFAULT_TITLE = "An error occurred";

    public ShowExceptionModel() {
        super(null);
    }

    @Override
    public Void execute() {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        initAlert(alert);

        alert.showAndWait();
        return null;
    }

    private void initAlert(Alert alert) {
        Object title = args.getOrDefault("title", DEFAULT_TITLE);
        if (title instanceof String titleString)
            alert.setTitle(titleString);
        else alert.setTitle(DEFAULT_TITLE);

        Object header = args.getOrDefault("header", DEFAULT_HEADER);
        if (header instanceof String headerString)
            alert.setHeaderText(headerString);
        else alert.setHeaderText(DEFAULT_HEADER);

        Object detail = args.get("detail");
        if (detail instanceof String detailString)
            alert.setContentText(detailString);

        Object throwable = args.get("throwable");
        if (throwable instanceof Throwable exception) {
            String exceptionText = STR."""
\{exception.getMessage()}
\{Arrays.stream(exception.getStackTrace())
        .map(element -> STR."\{element}\n")
        .collect(Collectors.joining())
}
""";

            GridPane expContent = new GridPane();
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(new Label(exceptionText));
            expContent.add(scrollPane, 0, 0);
            alert.getDialogPane().setExpandableContent(expContent);
        }
    }
}
