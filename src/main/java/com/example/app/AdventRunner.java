package com.example.app;

import challenge.Day1;
import reader.InputReader;

import java.util.List;

public class AdventRunner {

    public static void main(String... args) throws Exception {
        List<String> input = InputReader.getInput();
        new Day1().printResult2(input);
    }
}
