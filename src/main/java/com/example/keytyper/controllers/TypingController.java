package com.example.keytyper.controllers;

import com.example.keytyper.models.*;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.TextFlow;
import org.jetbrains.annotations.NotNull;

public class TypingController extends BaseController {
    private static final String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    //Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

    @FXML
    private TextFlow text;

    private BaseModel timerModel;
    private BaseModel keyTypedModel;
    private BaseModel loadTextIntoTextFlowModel;
    private BaseModel timerThreadModel;

    public void setupUI(){
        loadTextIntoTextFlowModel = new LoadTextIntoTextFlowModel();
        loadTextIntoTextFlowModel.getParameters().put("str", str);
        loadTextIntoTextFlowModel.getParameters().put("text", text);

        timerModel = new TimerModel();

        keyTypedModel = new KeyTypedModel();
        keyTypedModel.getParameters().put("text", text);
        keyTypedModel.getParameters().put("timerModel", timerModel);
        keyTypedModel.getParameters().put("scene", getParameters().get("scene"));

        timerThreadModel = new TimerThreadModel();
        timerThreadModel.getParameters().put("timerModel", timerModel);

        new Thread(timerThreadModel::execute).start();

        keyTypedModel.getParameters().put("timerThreadModel", timerThreadModel);

        loadTextIntoTextFlowModel.execute();

        EventHandler<KeyEvent> onKeyTyped = this::onKeyTyped;
        ((EventTarget) getParameters().get("scene")).addEventFilter(KeyEvent.KEY_PRESSED, onKeyTyped);
        keyTypedModel.getParameters().put("listener", onKeyTyped);
        keyTypedModel.getParameters().put("stage", getParameters().get("stage"));
    }

    public void onKeyTyped(@NotNull KeyEvent keyEvent) {
        keyTypedModel.getParameters().put("keyEvent", keyEvent);
        keyTypedModel.execute();
    }
}
