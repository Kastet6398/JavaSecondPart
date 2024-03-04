package com.example.keytyper.models;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class LoadTextIntoTextFlowModel extends BaseModel {
    public static final int FONT_SIZE = 30;

    @Override
    public void execute() {
        String str = (String) getParameters().get("str");
        TextFlow text = (TextFlow) getParameters().get("text");
        for (char c : str.toCharArray()) {
            Text newText = new Text(String.valueOf(c));
            newText.setFill(Color.GRAY);
            newText.setFont(new Font(FONT_SIZE));
            text.getChildren().add(newText);
        }
    }
}
