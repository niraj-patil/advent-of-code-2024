package Day04;

import java.util.List;

import Utils.InputObjectifier;

public class Solution1 {
    public static void main(String[] args) {
        Long solution = 0l;
        List<List<Character>> crossword = InputObjectifier.inputToCharMatrix("Day04/input.txt");
        solution += findXmas(crossword);
    }

    private static byte findXmas(List<List<Character>> crossword) {
        Integer xCoordinate = 0;
        Integer yCoordinate = 0;

        return 0;
    }

    private static boolean goNorth(char currentCharacter) {
        return false;
    }

    private static boolean goSouth(char currentCharacter) {
        return false;
    }

    private static boolean goEast(char currentCharacter) {
        return false;
    }

    private static boolean goWest(char currentCharacter) {
        return false;
    }

    private static boolean goNorthEast(char currentCharacter) {
        return false;
    }

    private static boolean goNorthWest(char currentCharacter) {
        return false;
    }

    private static boolean goSouthEast(char currentCharacter) {
        return false;
    }

    private static boolean goSouthWest(char currentCharacter) {
        return false;
    }
}
