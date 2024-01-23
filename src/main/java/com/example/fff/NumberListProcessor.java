package com.example.fff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberListProcessor {
    private static final Scanner scanner = new Scanner(System.in);
    private final List<Integer> numbers = new ArrayList<>();

    public void addNumber(int number) {
        numbers.add(number);
    }

    public void processNumbers() {
        System.out.println(STR."Sum of even numbers: \{processSumOfEvenNumbers()}");

        System.out.println(STR."Multiplied numbers by 2: \{processMultiplicationBy2()}");

        System.out.println(STR."Max number: \{processMaximumNumber()}");

        System.out.println(STR."Odd numbers: \{processOddNumbersAsString()}");

        System.out.println(STR."Average: \{processAverage()}");
    }

    public static void main(String[] args) {
        NumberListProcessor instance = new NumberListProcessor();
        outer: while (true) {

            System.out.println("Enter numbers (type 'done' to finish) or clear them (type 'clear') or exit (type 'exit'):");
            String input;
            while (!(input = scanner.nextLine()).equalsIgnoreCase("done")) {
                if (input.equals("exit")) {
                    break outer;
                }

                if (input.equals("clear")) {
                    instance.numbers.clear();
                    System.out.println("Cleared!");
                    continue;
                }

                try {
                    int number = Integer.parseInt(input);
                    instance.addNumber(number);
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer or 'done' to finish.");
                }
            }

            instance.processNumbers();
            System.out.println("You can add more numbers by typing them splitting by new lines (type 'done' to finish) or clear them (type 'clear') or exit (type 'exit'):");
        }
    }
    public int processSumOfEvenNumbers() {
        return numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public List<Integer> processMultiplicationBy2() {
        return numbers.stream().map(n -> n * 2).collect(Collectors.toList());
    }

    public int processMaximumNumber() {
        return numbers.stream().max(Integer::compareTo).orElse(0);
    }

    public String processOddNumbersAsString() {
        return numbers.stream().filter(n -> n % 2 != 0).map(Object::toString).collect(Collectors.joining(", "));
    }

    public double processAverage() {
        return numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
    }

}
