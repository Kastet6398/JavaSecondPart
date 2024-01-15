package com.example.demo4.ui;

import com.example.demo4.elements.CustomCanvas;
import com.example.demo4.models.BaseModel;
import com.example.demo4.models.ChooseFileModel;
import com.example.demo4.models.ShowExceptionModel;
import com.example.demo4.records.DrawingsConfig;
import com.example.demo4.records.Point;
import com.example.demo4.utils.ChooseFileOperation;
import com.example.demo4.utils.Constants;
import com.example.demo4.utils.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class HelloController extends BaseController {
    @FXML
    private ColorPicker color;
    @FXML
    private Spinner<Integer> spinner;
    @FXML
    private ColorPicker background;
    @FXML
    private CustomCanvas canvas;


    private boolean isDragging = false;
    private boolean isReadyToDrag = false;

    private String filenameString;

    private static final SpinnerValueFactory<Integer> valueFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
    static {
        valueFactory.setValue(5);
    }


    private final BaseModel<String> chooseFileModel;
    private final BaseModel<Void> showExceptionModel;


    public HelloController() {
        showExceptionModel = new ShowExceptionModel();
        chooseFileModel = new ChooseFileModel();
    }

    @Override
    public void init() {
        spinner.setValueFactory(valueFactory);
        background.valueProperty().addListener((_, _, newValue) -> canvas.setBackground(newValue));
        color.setValue(Color.BLACK);
        canvas.setBackground(Constants.DEFAULT_CANVAS_BACKGROUND, false);
    }


    @FXML
    private void drag(MouseEvent mouseEvent) {
        if (isReadyToDrag) {
            isDragging = true;
            isReadyToDrag = false;
        } else
            isReadyToDrag = true;

        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        int size = spinner.getValueFactory().getValue();
        String colorString = color.getValue().toString();

        if (!canvas.getPoints().isEmpty() && isDragging) {
            Point previousPoint = canvas.getPoints().getLast();
            double deltaX = x - previousPoint.x();
            double deltaY = y - previousPoint.y();
            double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            int steps = (int) distance;
            for (int i = 0; i < steps; i++) {
                double interpolatedX = previousPoint.x() + (deltaX / steps) * i;
                double interpolatedY = previousPoint.y() + (deltaY / steps) * i;
                canvas.addPoint(new Point(interpolatedX, interpolatedY, colorString, size));
            }
        } else
            canvas.addPoint(new Point(x, y, colorString, size));
    }

    @FXML
    private void clear() {
        canvas.clear();
    }

    @FXML
    private void onMouseReleased() {
        isDragging = false;
        isReadyToDrag = false;
    }

    @FXML
    private void save() {
        if (filenameString == null || filenameString.isEmpty()) saveAs();
        if (filenameString != null)
            Utils.save(new DrawingsConfig(canvas.getPoints(), background.getValue().toString()), filenameString);
    }

    @FXML
    private void saveAs() {
        chooseFileModel.setArg("type", ChooseFileOperation.SAVE);
        filenameString = chooseFileModel.execute();
        if (filenameString != null) {
            if (!filenameString.endsWith(".json"))
                    filenameString = STR."\{filenameString}.json";
            save();
        }
    }
    @FXML
    private void open() {
        chooseFileModel.setArg("type", ChooseFileOperation.OPEN);
        filenameString = chooseFileModel.execute();
        try {
            DrawingsConfig loadedPoints = (DrawingsConfig) Utils.fromJson(Utils.readFile(filenameString), DrawingsConfig.class);
            if (loadedPoints != null) {
                canvas.clearPoints();
                canvas.addPoint(loadedPoints.points(), false);
                canvas.setBackground(Color.valueOf(loadedPoints.background()));
            } else {
                showExceptionModel.setArg("header", STR."An error occurred while loading that file \"\{filenameString}\"");
                showExceptionModel.setArg("detail", STR."It seems that the file \"\{filenameString}\" is empty or corrupted");
                showExceptionModel.execute();
                filenameString = null;
            }
        } catch (Throwable e) {
            showExceptionModel.setArg("throwable", e);
            showExceptionModel.setArg("header", STR."An error occurred while loading that file \"\{filenameString}\"");
            showExceptionModel.execute();
            filenameString = null;
        }
    }
}
