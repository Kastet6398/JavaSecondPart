package org.example.utils;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.*;
import org.example.models.CalculationResult;

public class Utils {
    private static final String API_URL = "https://py-learn.onrender.com/api/calculator/";


    public static String calculate(String expression) {
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = new FormBody.Builder()
                    .add("expression", expression)
                    .build();

            Request request = new Request.Builder()
                    .url(API_URL)
                    .post(requestBody)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                var body = response.body();
                assert body != null;

                if (response.isSuccessful()) {
                    String resultString = body.string();

                    ObjectMapper objectMapper = new ObjectMapper();

                    try {
                        CalculationResult result = objectMapper.readValue(resultString, CalculationResult.class);

                        return STR."Result: \{result.result()}";
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return "Error";
                } else {
                    return STR."Request failed. Status code: \{response.code()}\nResponse: \{ body.string()}";
                }
            }
        } catch (Exception e) {
            return STR."Error: \{e.getMessage()}";
        }
    }
}
