package com.example.gptbot.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class OpenAIAPIRequest {

    private static HttpURLConnection getHttpURLConnection(String query) {
        try {
            String url = "https://api.openai.com/v1/chat/completions";
            URL obj = new URI(url).toURL();
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");

            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + Constants.OPENAI_KEY);

            con.setDoOutput(true);

            String requestBody = "{ \"model\": \"" + Constants.OPENAI_MODEL + "\", " +
                    "\"messages\": [{\"role\": \"user\", \"content\": \"" + query + "\"}]}";

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(requestBody);
                wr.flush();
            }
            return con;
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getAIResponse(String query) {
        try {
            HttpURLConnection con = OpenAIAPIRequest.getHttpURLConnection(query);
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine).append("\n");
                }
                JSONObject jsonResponse = new JSONObject(response.toString());

                JSONArray choices = jsonResponse.getJSONArray("choices");
                JSONObject firstChoice = choices.getJSONObject(0);
                JSONObject message = firstChoice.getJSONObject("message");
                return message.getString("content");
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
