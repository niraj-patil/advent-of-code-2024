package Day04;

import java.util.List;

import Utils.InputObjectifier;

public class Solution1 {
    public static void main(String[] args) {
        List<List<Character>> crossword = InputObjectifier.inputToCharMatrix("Day04/input.txt");
        System.out.println(findXmas(crossword));
    }

    private static long findXmas(List<List<Character>> crossword) {
        long solution = 0l;
        for(int row=0;row<crossword.size();row++){
            for(int column=0;column<crossword.get(0).size();column++){
                if('X'==getCharacter(crossword, row, column)){
                    solution+=goNorth(crossword,row,column);
                    solution+=goNorthEast(crossword,row,column);
                    solution+=goNorthWest(crossword,row,column);
                    solution+=goSouth(crossword,row,column);
                    solution+=goSouthEast(crossword,row,column);
                    solution+=goSouthWest(crossword,row,column);
                    solution+=goEast(crossword,row,column);
                    solution+=goWest(crossword,row,column);
                }
            }
        }

        return solution;
    }

    private static byte goNorth(List<List<Character>> crossword,int xCoordinate,int yCoordinate) {
        if(xCoordinate<=2) return 0;
        if('M'== getCharacter(crossword, xCoordinate-1, yCoordinate)
            && 'A' == getCharacter(crossword, xCoordinate-2, yCoordinate)
            && 'S' == getCharacter(crossword, xCoordinate-3, yCoordinate))
            return 1;
        return 0;
    }

    private static byte goSouth(List<List<Character>> crossword,int xCoordinate,int yCoordinate) {
        if(xCoordinate>=crossword.size()-3) return 0;
        if('M'== getCharacter(crossword, xCoordinate+1, yCoordinate)
            && 'A' == getCharacter(crossword, xCoordinate+2, yCoordinate)
            && 'S' == getCharacter(crossword, xCoordinate+3, yCoordinate))
            return 1;
        return 0;
    }

    private static byte goEast(List<List<Character>> crossword,int xCoordinate,int yCoordinate) {
        if(yCoordinate>=crossword.size()-3) return 0;
        if('M'== getCharacter(crossword, xCoordinate, yCoordinate+1)
            && 'A' == getCharacter(crossword, xCoordinate, yCoordinate+2)
            && 'S' == getCharacter(crossword, xCoordinate, yCoordinate+3))
            return 1;
        return 0;
    }

    private static byte goWest(List<List<Character>> crossword,int xCoordinate,int yCoordinate) {
        if(yCoordinate<=2) return 0;
        if('M'== getCharacter(crossword, xCoordinate, yCoordinate-1)
            && 'A' == getCharacter(crossword, xCoordinate, yCoordinate-2)
            && 'S' == getCharacter(crossword, xCoordinate, yCoordinate-3))
            return 1;
        return 0;
    }

    private static byte goNorthEast(List<List<Character>> crossword,int xCoordinate,int yCoordinate) {
        if(xCoordinate>=crossword.size()-3 || yCoordinate>=crossword.size()-3) return 0;
        if('M'== getCharacter(crossword, xCoordinate+1, yCoordinate+1)
            && 'A' == getCharacter(crossword, xCoordinate+2, yCoordinate+2)
            && 'S' == getCharacter(crossword, xCoordinate+3, yCoordinate+3))
            return 1;
        return 0;
    }

    private static byte goNorthWest(List<List<Character>> crossword,int xCoordinate,int yCoordinate) {
        if(xCoordinate>=crossword.size()-3 || yCoordinate<=2) return 0;
        if('M'== getCharacter(crossword, xCoordinate+1, yCoordinate-1)
            && 'A' == getCharacter(crossword, xCoordinate+2, yCoordinate-2)
            && 'S' == getCharacter(crossword, xCoordinate+3, yCoordinate-3))
            return 1;
        return 0;
    }

    private static byte goSouthEast(List<List<Character>> crossword,int xCoordinate,int yCoordinate) {
        if(xCoordinate<=2 || yCoordinate>=crossword.size()-3) return 0;
        if('M'== getCharacter(crossword, xCoordinate-1, yCoordinate+1)
            && 'A' == getCharacter(crossword, xCoordinate-2, yCoordinate+2)
            && 'S' == getCharacter(crossword, xCoordinate-3, yCoordinate+3))
            return 1;
        return 0;
    }

    private static byte goSouthWest(List<List<Character>> crossword,int xCoordinate,int yCoordinate) {
        if(xCoordinate<=2||yCoordinate<=2) return 0;
        if('M'== getCharacter(crossword, xCoordinate-1, yCoordinate-1)
            && 'A' == getCharacter(crossword, xCoordinate-2, yCoordinate-2)
            && 'S' == getCharacter(crossword, xCoordinate-3, yCoordinate-3))
            return 1;
        return 0;
    }

    private static char getCharacter(List<List<Character>> crossword,int xCoordinate,int yCoordinate){
        return crossword.get(xCoordinate).get(yCoordinate);
    }
}
