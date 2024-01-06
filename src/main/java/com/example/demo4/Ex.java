package com.example.demo4;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class Ex {
    public static void main(String[] args) {

                // JSON string representing an array of points
                String jsonString = "[{\"x\":126.4,\"y\":36.0,\"color\":\"0xffffffff\"}, {\"x\":112.8,\"y\":29.6,\"color\":\"0xffffffff\"}, {\"x\":109.6,\"y\":28.0,\"color\":\"0xffffffff\"}, {\"x\":105.6,\"y\":27.2,\"color\":\"0xffffffff\"}, {\"x\":101.6,\"y\":26.4,\"color\":\"0xffffffff\"}, {\"x\":98.4,\"y\":26.4,\"color\":\"0xffffffff\"}, {\"x\":97.6,\"y\":26.4,\"color\":\"0xffffffff\"}, {\"x\":96.0,\"y\":26.4,\"color\":\"0xffffffff\"}, {\"x\":95.2,\"y\":26.4,\"color\":\"0xffffffff\"}, {\"x\":94.4,\"y\":26.4,\"color\":\"0xffffffff\"}, {\"x\":93.6,\"y\":26.4,\"color\":\"0xffffffff\"}, {\"x\":92.8,\"y\":26.4,\"color\":\"0xffffffff\"}, {\"x\":92.0,\"y\":26.4,\"color\":\"0xffffffff\"}, {\"x\":91.2,\"y\":26.4,\"color\":\"0xffffffff\"}, {\"x\":89.6,\"y\":27.2,\"color\":\"0xffffffff\"}, {\"x\":89.6,\"y\":30.4,\"color\":\"0xffffffff\"}, {\"x\":89.6,\"y\":36.8,\"color\":\"0xffffffff\"}, {\"x\":90.4,\"y\":41.6,\"color\":\"0xffffffff\"}, {\"x\":91.2,\"y\":44.8,\"color\":\"0xffffffff\"}, {\"x\":95.2,\"y\":51.2,\"color\":\"0xffffffff\"}, {\"x\":104.8,\"y\":58.4,\"color\":\"0xffffffff\"}, {\"x\":115.2,\"y\":63.2,\"color\":\"0xffffffff\"}, {\"x\":122.4,\"y\":64.8,\"color\":\"0xffffffff\"}, {\"x\":130.4,\"y\":66.4,\"color\":\"0xffffffff\"}, {\"x\":140.0,\"y\":66.4,\"color\":\"0xffffffff\"}, {\"x\":152.0,\"y\":64.8,\"color\":\"0xffffffff\"}, {\"x\":157.6,\"y\":64.0,\"color\":\"0xffffffff\"}, {\"x\":164.0,\"y\":61.6,\"color\":\"0xffffffff\"}, {\"x\":172.0,\"y\":57.6,\"color\":\"0xffffffff\"}, {\"x\":178.4,\"y\":54.4,\"color\":\"0xffffffff\"}]";

                // Create a TypeToken to help Gson understand the generic type List<Point>
                Type listType = new TypeToken<List<Point>>() {}.getType();

                // Use Gson to parse the JSON string into a List of Point objects
                Gson gson = new Gson();
                List<Point> points = gson.fromJson(jsonString, listType);

                System.out.println(points);
            }
}
