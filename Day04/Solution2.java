package Day04;

import java.util.List;

import Utils.InputObjectifier;

public class Solution2 {
    public static void main(String[] args) {
        List<List<Character>> crossword = InputObjectifier.inputToCharMatrix("Day04/input.txt");
        System.out.println(findX_mas(crossword));
    }

    private static long findX_mas(List<List<Character>> crossword) {
        long solution = 0l;
        for(int row=1;row<crossword.size()-1;row++){
            for(int column=1;column<crossword.get(0).size()-1;column++){
                if('A'==getCharacter(crossword, row, column) && firstMas(crossword, row, column) && secondMas(crossword, row, column)) solution+=1;
            }
        }
        return solution;
    }

    private static boolean firstMas(List<List<Character>> crossword,int xCoordinate,int yCoordinate) {
        if('M' == getCharacter(crossword, xCoordinate-1, yCoordinate-1) && 'S' == getCharacter(crossword, xCoordinate+1, yCoordinate+1)) return true;
        if('S' == getCharacter(crossword, xCoordinate-1, yCoordinate-1) && 'M' == getCharacter(crossword, xCoordinate+1, yCoordinate+1)) return true;
        return false;
    }

    private static boolean secondMas(List<List<Character>> crossword,int xCoordinate,int yCoordinate) {
        if('M' == getCharacter(crossword, xCoordinate+1, yCoordinate-1) && 'S' == getCharacter(crossword, xCoordinate-1, yCoordinate+1)) return true;
        if('S' == getCharacter(crossword, xCoordinate+1, yCoordinate-1) && 'M' == getCharacter(crossword, xCoordinate-1, yCoordinate+1)) return true;
        return false;
    }

    private static char getCharacter(List<List<Character>> crossword,int xCoordinate,int yCoordinate){
        return crossword.get(xCoordinate).get(yCoordinate);
    }
}
