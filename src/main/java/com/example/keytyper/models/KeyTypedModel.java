package com.example.keytyper.models;

import com.example.keytyper.views.BaseApplication;
import com.example.keytyper.views.ResultApplication;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class KeyTypedModel extends BaseModel {
    private int i = 0;

    @Override
    public void execute() {
        KeyEvent keyEvent = (KeyEvent) getParameters().get("keyEvent");
        if (!keyEvent.getText().isEmpty()) {
            TextFlow text = (TextFlow) getParameters().get("text");
            BaseModel timerModel = (BaseModel) getParameters().get("timerModel");
            Text character = (Text) text.getChildren().get(i);

            if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
                onBackSpace(text);
            } else if (i == text.getChildren().size() - 1) {
                onReachedEnd(timerModel);
            } else {
                if (Objects.equals(keyEvent.getText(), character.getText())) {
                    onCorrectChar(character);
                }
                else {
                    onIncorrectChar(character, timerModel);
                }
                i++;
                timerModel.getParameters().put("j", (int) timerModel.getParameters().getOrDefault("j", 0) + 1);
            }
        }
    }

    private void onBackSpace(TextFlow text) {
        ((Shape) text.getChildren().get(i - 1)).setFill(Color.GRAY);
        i--;
    }

    private void onIncorrectChar(Text character, BaseModel timerModel) {
        timerModel.getParameters().put("errors", (int) timerModel.getParameters().getOrDefault("errors", 0) + 1);
        character.setFill(Color.RED);
    }

    private void onCorrectChar(Text character) {
        character.setFill(Color.LIGHTBLUE);
    }

    private void onReachedEnd(BaseModel timerModel) {
        timerModel.execute();
        try {
            TimerThreadModel thread = (TimerThreadModel) getParameters().get("timerThreadModel");
            thread.interrupt();
            ((EventTarget) getParameters().get("scene")).removeEventFilter(KeyEvent.KEY_PRESSED, (EventHandler<? super KeyEvent>) getParameters().get("listener"));
            BaseApplication app = new ResultApplication();
            Collection<HashMap<String, Integer>> data = (Collection<HashMap<String, Integer>>) timerModel.getParameters().getOrDefault("data", new ArrayList<>());

            app.getArgs().put("result", data);
            app.start((Stage) getParameters().get("stage"));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
