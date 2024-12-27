package challenge;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

import static java.lang.Math.abs;

public class Day2 {

    public void printResult1(@NotNull List<String> input) {
        int counter = 0;
        for(String line: input) {
            boolean safe = true;
            String[] levels = line.split("\\s+");
            Optional<Boolean> descending = Optional.empty();
            for(int i = 0; i < levels.length - 1; i++) {
                int security = Integer.parseInt(levels[i]) - Integer.parseInt(levels[i +1]);
                if(abs(security) > 3 || security == 0) {
                    //unsafe
                    safe = false;
                    break;
                } else if(descending.isEmpty()) {
                    descending = security > 0 ? Optional.of(true) : Optional.of(false);
                } else if((security > 0 && !descending.get()) || (security < 0 && descending.get())){
                    safe = false;
                    break;
                }
            }
            if(safe) {
                counter++;
            }
        }
        System.out.printf("Number of safe reports %d", counter);
    }

    public void printResult2(@NotNull List<String> input) {
        int counter = 0;
        for(String line: input) {
            int index;
            String[] levels = line.split("\\s+");
            index = isSafeByIndexReturned(levels);
            if(index < 0) {
                counter++;
            } else {
                for(int i = 0 ; i<levels.length; i++) {
                    String[] newLevels = getNewLevel(levels, i);
                    index = isSafeByIndexReturned(newLevels);
                    if (index < 0) {
                        counter++;
                        break;
                    }
                }
            }
        }
        System.out.printf("Number of safe reports %d", counter);
    }

    private static String[] getNewLevel(String[] levels, int index) {
        final String[] newLevel = new String[levels.length-1];
        for(int i = 0, k = 0; i< levels.length; i++){
            if(i != index){
                newLevel[k]= levels[i];
                k++;
            }
        }
        return newLevel;
    }

    private int isSafeByIndexReturned(String[] levels) {
        int index = -1;
        Optional<Boolean> descending = Optional.empty();
        for(int i = 0; i < levels.length - 1; i++) {
            int security = Integer.parseInt(levels[i]) - Integer.parseInt(levels[i +1]);
            if(abs(security) > 3 || security == 0) {
                //unsafe
                index = i;
                break;
            } else if(descending.isEmpty()) {
                descending = security > 0 ? Optional.of(true) : Optional.of(false);
            } else if((security > 0 && !descending.get()) || (security < 0 && descending.get())){
                index = i;
                break;
            }
        }
        return index;
    }
}
