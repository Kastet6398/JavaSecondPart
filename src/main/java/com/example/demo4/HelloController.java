package com.example.demo4;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HelloController extends BaseController {
    public ColorPicker color;
    public Spinner<Integer> spinner;
    public ColorPicker background;
    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    private static final Gson gson = new Gson();
    private final List<Point> points = new ArrayList<>();
    private boolean isDragging = false;
    private boolean isReadyToDrag = false;

    public void drag(MouseEvent mouseEvent) {
        if (isReadyToDrag) {
            isDragging = true;
            isReadyToDrag = false;
        } else
            isReadyToDrag = true;

        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        String colorString = color.getValue().toString();

        if (!points.isEmpty() && isDragging) {
            Point previousPoint = points.getLast();
            double deltaX = x - previousPoint.x();
            double deltaY = y - previousPoint.y();
            double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            int steps = (int) distance;
            for (int i = 0; i < steps; i++) {
                double interpolatedX = previousPoint.x() + (deltaX / steps) * i;
                double interpolatedY = previousPoint.y() + (deltaY / steps) * i;
                Point point = new Point(interpolatedX, interpolatedY, colorString, spinner.getValueFactory().getValue());
                points.add(point);
                drawPoint(point);
            }
        } else {
            Point point = new Point(x, y, colorString, spinner.getValueFactory().getValue());
            points.add(point);
            drawPoint(point);
        }
    }


    private void drawPoint(Point point) {
        gc.setFill(javafx.scene.paint.Color.valueOf(point.color()));
        gc.fillOval(point.x(), point.y(), point.size(), point.size());
    }

    SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
    {
        valueFactory.setValue(5);
    }

    private String filenameString;

    public void save() {
        if (filenameString == null || filenameString.isEmpty()) saveAs();
        if (filenameString != null) {
            var json = gson.toJson(new DrawingsConfig(points, background.getValue().toString()));
            Utils.writeFile(filenameString, json);
        }
    }

    @Override
    public void init() {
        spinner.setValueFactory(valueFactory);
        gc = canvas.getGraphicsContext2D();
        background.valueProperty().addListener((_, _, newValue) -> setBackground(newValue));
        setBackground(Color.WHITE);
        color.setValue(Color.BLACK);
    }

    public void open() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);

        filenameString = String.valueOf(fileChooser.showOpenDialog(stage));

        Type drawingsConfigType = new TypeToken<DrawingsConfig>() {}.getType();

        DrawingsConfig loadedPoints = gson.fromJson(Utils.readFile(filenameString), drawingsConfigType);

        if (loadedPoints != null) {
            points.clear();
            points.addAll(loadedPoints.points());
            setBackground(Color.valueOf(loadedPoints.background()));
        }
    }

    private void setBackground(Color color) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(color);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Point point : points)
            drawPoint(point);
    }

    public void onMouseReleased() {
        isDragging = false;
        isReadyToDrag = false;
    }

    public void clear() {
        Color backgroundColor = background.getValue();
        points.clear();
        setBackground(backgroundColor);
    }

    public void saveAs() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(stage);
        if (file == null) filenameString = null;
        else {
            filenameString = file.getAbsolutePath();
            if (!filenameString.endsWith(".json")) filenameString = STR."\{filenameString}.json";
            save();
        }
    }
}