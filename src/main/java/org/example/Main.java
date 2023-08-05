package org.example;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        String name = "bhavitha"; // replace with your own name or use user input
        LocalTime now = LocalTime.now();
        String message;

        if (now.isBefore(LocalTime.NOON)) {
            message = "Good morning, " + name + ", Welcome to COMP367";
        } else {
            message = "Good afternoon, " + name + ", Welcome to COMP367";
        }

        System.out.println(message);
    }
}