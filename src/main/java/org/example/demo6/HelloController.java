package org.example.demo6;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Objects;

public class HelloController {

    @FXML
    private Label weatherLabel;

    @FXML
    private TextField input;

    @FXML
    protected void submit() {
        weatherLabel.setText("Loading");
        new Thread(()-> {
            String city = input.getText();
            try {
                WeatherData weatherData = OpenWeatherMapApi.getWeatherData(city);
                String displayText = "Temperature: " + weatherData.getMain().getTemp() + "°C\n";
                displayText += "Description: " + weatherData.getWeather()[0].getDescription();
                String finalDisplayText = displayText;
                Platform.runLater(()->weatherLabel.setText(finalDisplayText));
            }
            catch (Exception e) {
                Platform.runLater(()->weatherLabel.setText("Failed to fetch weather for location: " + city));
            }
        }).start();
    }

    @FXML
    private void onKeyPressed(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            submit();
        }
    }
}
