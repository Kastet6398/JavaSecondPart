package com.example.demo1;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class CheckProcessRunning {

    public static void main(String[] args) {
        String processName = "java";  // Replace with the name of your process

        boolean isProcessRunning = isProcessRunning(processName);
        System.out.println(STR."Is process running? \{isProcessRunning}");
    }

    public static boolean isProcessRunning(String processName) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String jvmName = runtimeMXBean.getName();

        // The format of the process ID may vary across platforms,
        // For example, on Unix-like systems, it may be "1234@hostname"
        // On Windows, it may be a numerical value like "1234"

        // Check if the process name is present in the JVM name
        return jvmName.contains(processName);
    }
}
