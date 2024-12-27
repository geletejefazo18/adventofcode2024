package challenge;

import org.jetbrains.annotations.NotNull;

import java.util.*;

import static java.lang.Math.abs;

public class Day1 {

    public void printResult1(@NotNull List<String> input) {
        List<Integer> firstLocationList = new ArrayList<>();
        List<Integer> secondLocationList = new ArrayList<>();
        int totalDistance = 0;
        for(String line: input) {
            String[] locations = line.split("\\s+");
            firstLocationList.add(Integer.parseInt(locations[0]));
            secondLocationList.add(Integer.parseInt(locations[1]));
        }
        Collections.sort(firstLocationList);
        Collections.sort(secondLocationList);
        for(int i = 0; i< firstLocationList.size(); i++) {
          totalDistance = totalDistance + abs(firstLocationList.get(i) - secondLocationList.get(i));
        }
        System.out.printf("Total distance %d", totalDistance);
    }

    public void printResult2(@NotNull List<String> input) {
        List<Integer> firstLocationList = new ArrayList<>();
        List<Integer> secondLocationList = new ArrayList<>();
        int similarityScore = 0;
        Map<Integer, Integer> cacheMap = new HashMap<>();
        for (String line : input) {
            String[] locations = line.split("\\s+");
            firstLocationList.add(Integer.parseInt(locations[0]));
            secondLocationList.add(Integer.parseInt(locations[1]));
        }
        for (Integer locationFirstList : firstLocationList) {
            if (cacheMap.containsKey(locationFirstList)) {
                similarityScore = similarityScore + cacheMap.get(locationFirstList);
            } else {
                int counter = 0;
                for (Integer locationSecondList : secondLocationList) {
                    if (locationSecondList.equals(locationFirstList)) {
                        counter++;
                    }
                }
                int repeated = locationFirstList * counter;
                cacheMap.put(locationFirstList, repeated);
                similarityScore = similarityScore + repeated;
            }
        }
        System.out.printf("Similarity Score %d", similarityScore);
    }
}
