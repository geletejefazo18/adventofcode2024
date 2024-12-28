package challenge;

import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public void printResult1(@NotNull List<String> input) {
        Pattern pattern = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");
        Pattern patternInt = Pattern.compile("\\d+");
        List<Integer> integers = new ArrayList<>();
        long result = 0;
        for(String line: input) {
            Matcher m = pattern.matcher(line);
            while(m.find()) {
                //mul(44,46)
                // Compile the regex to match integers
                Matcher matcher = patternInt.matcher(m.group());
                integers.clear();
                while(matcher.find()) {
                    integers.add(Integer.parseInt(matcher.group()));
                }
                result = result + integers.get(0) * integers.get(1);
            }
        }
        System.out.printf("Total result %d", result);
    }

    public void printResult2(@NotNull List<String> input) {
        Pattern pattern = Pattern.compile("do\\(\\)|mul\\(\\d{1,3},\\d{1,3}\\)|don't\\(\\)");
        Pattern patternInt = Pattern.compile("\\d+");
        List<Integer> integers = new ArrayList<>();
        long result = 0;
        boolean enabled = true;
        for(String line: input) {
            Matcher m = pattern.matcher(line);
            while(m.find()) {
                String match = m.group();
                if(match.equals("do()")) {
                    enabled = true;
                } else if (match.equals("don't()")) {
                    enabled = false;
                } else if(enabled) {
                    //mul(44,46)
                    // Compile the regex to match integers
                    Matcher matcher = patternInt.matcher(m.group());
                    integers.clear();
                    while(matcher.find()) {
                        integers.add(Integer.parseInt(matcher.group()));
                    }
                    result = result + integers.get(0) * integers.get(1);
                }
            }
        }
        System.out.printf("Total result %d", result);
    }
}
