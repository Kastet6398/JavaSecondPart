package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    private final CalcModel model;
    public HelloController() {
        model = new CalcModel(this);
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClickOne() {
        model.setNum(1);
    }

    @FXML
    protected void onHelloButtonClickTwo() {
        model.setNum(2);
    }
    @FXML
    protected void onHelloButtonClickPlus() {

        model.plus();
    }
    @FXML
    protected void onHelloButtonClickEqual() {

        model.equal();
    }

    public void setLabelNum(String labelNum) {
        welcomeText.setText(labelNum);
    }
}