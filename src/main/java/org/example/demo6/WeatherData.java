package org.example.demo6;

import com.google.gson.annotations.SerializedName;

public class WeatherData {

    @SerializedName("main")
    public MainData main;

    @SerializedName("weather")
    public Weather[] weather;

    public MainData getMain() {
        return main;
    }

    public Weather[] getWeather() {
        return weather;
    }
}

