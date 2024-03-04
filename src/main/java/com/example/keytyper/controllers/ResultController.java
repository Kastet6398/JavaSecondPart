package com.example.keytyper.controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.List;
import java.util.Map;

public class ResultController extends BaseController {
    public static final int FONT_SIZE = 30;

    @FXML
    private VBox box;

    @FXML
    private Text cpm;

    public void setupUI(){
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Second");
        final LineChart<Number,Number> lineChart =
                new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Result");
        XYChart.Series<Number,Number> series = new XYChart.Series<>();
        series.setName("Typed characters");

        XYChart.Series<Number,Number> series2 = new XYChart.Series<>();
        series2.setName("Errors");
        List<Map<String, Integer>> collection = (List<Map<String,java.lang.Integer>>) getParameters().get("result");
        for (int i = 0; i < collection.size(); i++) {
            series.getData().add(new XYChart.Data<>(i + 1, collection.get(i).get("typed")));
            series2.getData().add(new XYChart.Data<>(i + 1, collection.get(i).get("errors")));
        }
        lineChart.getData().addAll(series, series2);
        box.getChildren().addFirst(lineChart);

        cpm.setFont(new Font(FONT_SIZE));
        cpm.setText("Characters per second: " + (collection.stream().mapToInt(x -> x.get("typed")).average().orElse(0)) + "\nCorrect characters per second: " + (collection.stream().mapToInt(x -> x.get("typed") - x.get("errors")).average().orElse(0)));
    }
}
