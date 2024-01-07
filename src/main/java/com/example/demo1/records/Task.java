package com.example.demo1.records;

import java.sql.Timestamp;

public record Task(String text, int id, Timestamp timestamp, boolean isShown){
}
