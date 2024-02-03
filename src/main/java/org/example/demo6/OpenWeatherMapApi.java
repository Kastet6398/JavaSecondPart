package org.example.demo6;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class OpenWeatherMapApi {

    private static final String API_KEY = "55131bc723c7f2d5ad9443f7430b7d95";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";

    public static WeatherData getWeatherData(String city) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        String apiUrl = API_URL + "?q=" + URLEncoder.encode(city, StandardCharsets.UTF_8) + "&appid=" + API_KEY + "&units=metric";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(response.body(), JsonObject.class);
            return gson.fromJson(json, WeatherData.class);
        } else {
            throw new RuntimeException("Failed to get weather data. Status code: " + response.statusCode());
        }
    }
}
