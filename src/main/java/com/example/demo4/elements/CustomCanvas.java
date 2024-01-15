package com.example.demo4.elements;

import com.example.demo4.records.Point;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class CustomCanvas extends Canvas {
    private final GraphicsContext graphicsContext = getGraphicsContext2D();

    public Color getBackground() {
        return background;
    }

    private Color background;

    private final List<Point> points = new ArrayList<>();

    public void setBackground(Color color) {
        setBackground(color, true);
    }

    public void clear() {
        clearPoints();
        setBackground(background);
    }

    public void drawPoint(Point point) {
        graphicsContext.setFill(javafx.scene.paint.Color.valueOf(point.color()));
        graphicsContext.fillOval(point.x(), point.y(), point.size(), point.size());
    }

    public void setBackground(Color color, boolean isDrawPoints) {
        this.background = color;

        graphicsContext.clearRect(0, 0, getWidth(), getHeight());
        graphicsContext.setFill(color);
        graphicsContext.fillRect(0, 0, getWidth(), getHeight());
        if (isDrawPoints)
            for (Point point : points)
                drawPoint(point);
    }

    public void addPoint(Point point, boolean isDrawPoint) {
        points.add(point);
        if (isDrawPoint)
            drawPoint(point);
    }

    public void addPoint(Point point) {
        addPoint(point, true);
    }

    public void addPoint(List<Point> points, boolean isDrawPoints) {
        this.points.addAll(points);
        if (isDrawPoints)
            for (Point point : points)
                drawPoint(point);
    }

    public void addPoint(List<Point> points) {
        addPoint(points, true);
    }

    public void clearPoints() {
        points.clear();
    }

    public List<Point> getPoints() {
        return points;
    }
}
