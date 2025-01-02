package challenge;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Day4 {

    public void printResult1(@NotNull List<String> input) {
        char[][] matrix = new char[input.size()][input.get(0).length()];
        int counter = 0;
        for(int i = 0; i < matrix.length; i++) {
            char[] line = input.get(i).toCharArray();
            System.arraycopy(line, 0, matrix[i], 0, matrix[i].length);
        }
        char[] xmas = {'X','M','A','S'};
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == xmas[0]) {
                    //candidate! we can move left, up, right,down and diagonal(up right, up left, down right, down left)
                    if(findXmasToLeft(xmas, matrix, i, j)) {
                        counter++;
                    }
                    if(findXmasToRight(xmas, matrix, i, j)) {
                        counter++;
                    }
                    if(findXmasUp(xmas, matrix, i, j)) {
                        counter++;
                    }
                    if(findXmasDown(xmas, matrix, i, j)) {
                        counter++;
                    }
                    if(findXmasUpRight(xmas, matrix, i, j)) {
                        counter++;
                    }
                    if(findXmasUpLeft(xmas, matrix, i, j)) {
                        counter++;
                    }
                    if(findXmasDownLeft(xmas, matrix, i, j)) {
                        counter++;
                    }
                    if(findXmasDownRight(xmas, matrix, i, j)) {
                        counter++;
                    }
                }
            }
        }
        System.out.printf("Total %d", counter);
    }

    private boolean findXmasToLeft(char[] xmas, char[][]matrix, int initialRow, int initialColumn) {
        int counter = 1;
        while(initialColumn -1 >= 0 && counter < 4) {
            if(xmas[counter] == matrix[initialRow][initialColumn - 1]) {
                initialColumn--;
                counter++;
            } else {
                break;
            }
        }
        return counter == 4;
    }
    private boolean findXmasToRight(char[] xmas, char[][]matrix, int initialRow, int initialColumn) {
        int counter = 1;
        while(initialColumn + 1 <= matrix[0].length - 1 && counter < 4) {
            if(xmas[counter] == matrix[initialRow][initialColumn + 1]) {
                initialColumn++;
                counter++;
            } else {
                break;
            }
        }
        return counter == 4;
    }
    private boolean findXmasDown(char[] xmas, char[][]matrix, int initialRow, int initialColumn) {
        int counter = 1;
        while(initialRow + 1 <= matrix.length - 1 && counter < 4) {
            if(xmas[counter] == matrix[initialRow + 1][initialColumn]) {
                initialRow++;
                counter++;
            } else {
                break;
            }
        }
        return counter == 4;
    }
    private boolean findXmasUp(char[] xmas, char[][]matrix, int initialRow, int initialColumn) {
        int counter = 1;
        while(initialRow - 1 >= 0 && counter < 4) {
            if(xmas[counter] == matrix[initialRow - 1][initialColumn]) {
                initialRow--;
                counter++;
            } else {
                break;
            }
        }
        return counter == 4;
    }
    private boolean findXmasUpRight(char[] xmas, char[][]matrix, int initialRow, int initialColumn) {
        int counter = 1;
        while(initialRow - 1 >= 0 && initialColumn + 1 <= matrix[0].length - 1 && counter < 4) {
            if(xmas[counter] == matrix[initialRow - 1][initialColumn + 1]) {
                initialRow--;
                initialColumn++;
                counter++;
            } else {
                break;
            }
        }
        return counter == 4;
    }
    private boolean findXmasUpLeft(char[] xmas, char[][]matrix, int initialRow, int initialColumn) {
        int counter = 1;
        while(initialRow - 1 >= 0 && initialColumn - 1 >= 0 && counter < 4) {
            if(xmas[counter] == matrix[initialRow - 1][initialColumn - 1]) {
                initialRow--;
                initialColumn--;
                counter++;
            } else {
                break;
            }
        }
        return counter == 4;
    }
    private boolean findXmasDownLeft(char[] xmas, char[][]matrix, int initialRow, int initialColumn) {
        int counter = 1;
        while(initialRow + 1 <= matrix.length - 1 && initialColumn - 1 >= 0 && counter < 4) {
            if(xmas[counter] == matrix[initialRow + 1][initialColumn - 1]) {
                initialRow++;
                initialColumn--;
                counter++;
            } else {
                break;
            }
        }
        return counter == 4;
    }
    private boolean findXmasDownRight(char[] xmas, char[][]matrix, int initialRow, int initialColumn) {
        int counter = 1;
        while(initialRow + 1 <= matrix.length - 1 && initialColumn + 1 <= matrix[0].length - 1 && counter < 4) {
            if(xmas[counter] == matrix[initialRow + 1][initialColumn + 1]) {
                initialRow++;
                initialColumn++;
                counter++;
            } else {
                break;
            }
        }
        return counter == 4;
    }

    private boolean findMasOrSamDownLeft(char[] xmas,char[] sam, char[][]matrix, int initialRow, int initialColumn) {
        int counter = 0;
        boolean samDir = false;
        boolean masDir = false;
        while(initialRow >= 0 && initialRow < matrix.length  && initialColumn < matrix[initialRow].length && initialColumn >= 0 && counter < 3) {
            if(xmas[counter] == matrix[initialRow][initialColumn]) {
                initialRow++;
                initialColumn--;
                if(counter != 1) {
                    masDir = true;
                }
                counter++;
            } else if(sam[counter] == matrix[initialRow][initialColumn]) {
                initialRow++;
                initialColumn--;
                if(counter != 1) {
                    samDir = true;
                }
                counter++;
            } else {
                break;
            }
        }
        if(samDir && masDir) return false;
        return counter == 3;
    }

    private boolean findMasOrSamDownRight(char[] xmas, char[]sam, char[][]matrix, int initialRow, int initialColumn) {
        int counter = 0;
        boolean samDir = false;
        boolean masDir = false;
        while(initialRow >= 0 && initialRow < matrix.length  && initialColumn < matrix[initialRow].length && initialColumn >= 0 && counter < 3) {
            if(xmas[counter] == matrix[initialRow][initialColumn]) {
                initialRow++;
                initialColumn++;
                if(counter != 1) {
                    masDir = true;
                }
                counter++;
            } else if(sam[counter] == matrix[initialRow][initialColumn]) {
                initialRow++;
                initialColumn++;
                if (counter != 1) {
                    samDir = true;
                }
                counter++;
            }else {
                break;
            }
        }
        if(samDir && masDir) return false;
        return counter == 3;
    }

    public void printResult2(@NotNull List<String> input) {
        char[][] matrix = new char[input.size()][input.get(0).length()];
        int counter = 0;
        for(int i = 0; i < matrix.length; i++) {
            char[] line = input.get(i).toCharArray();
            System.arraycopy(line, 0, matrix[i], 0, matrix[i].length);
        }
        char[] xmas = {'M','A','S'};
        char[] sam = {'S','A','M'};
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == xmas[1]) {
                    //candidate!
                    //Mirror diagonal
                    if(findMasOrSamDownLeft(xmas, sam, matrix, i-1, j+1) && findMasOrSamDownRight(xmas, sam, matrix, i-1, j-1)) {
                        counter++;
                    }
                }
            }
        }
        System.out.printf("Totaaaal %d", counter);
    }
}
