package com.example.app;

import challenge.Day3;
import reader.InputReader;

import java.util.List;

public class AdventRunner {

    public static void main(String... args) throws Exception {
        List<String> input = InputReader.getInput();
        new Day3().printResult2(input);
    }
}
