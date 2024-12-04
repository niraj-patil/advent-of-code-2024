package Day02;

import java.util.ArrayList;
import java.util.List;

import Utils.InputObjectifier;

public class Solution2 {

    public static void main(String[] args) {
        Long solution = 0l;
        List<List<Integer>> input = InputObjectifier.inputToMultipleListsHorizontal("Day02/input.txt");
        
        for(List<Integer> report : input){
            solution += isSafe(report,true);
        }
        System.out.println(solution);
    }

    private static int isSafe(List<Integer> report, boolean firstRound){
        if(report.size() == 1) return 1;
        boolean isAsc = report.get(1) > report.get(0);

        for(int level = 0 ; level < report.size() - 1 ; level++){
            if(report.get(level+1) == report.get(level)) return dampenProblem(report, level, 0, firstRound);
            if(Math.abs(report.get(level+1) - report.get(level)) > 3) return dampenProblem(report, level, 1, firstRound);
            if(!isAsc && report.get(level+1) > report.get(level)) return dampenProblem(report, level, 2, firstRound);
            if(isAsc && report.get(level+1) < report.get(level)) return dampenProblem(report, level, 2, firstRound);
        }
        return 1;
    }

    private static int dampenProblem(List<Integer> report, int problemLevel, int failureCode ,boolean firstRound){
        List<Integer>tempList;
        if(firstRound){
            tempList = new ArrayList<>(report);            
            tempList.remove(problemLevel);
            if(1 == isSafe(tempList, false)) return 1;
            if(0 != failureCode){
                tempList = new ArrayList<>(report);
                tempList.remove(problemLevel+1);
                if(1 == isSafe(tempList, false)) return 1;
            }
            if(2 == failureCode){
                tempList = new ArrayList<>(report);
                tempList.remove(problemLevel-1);
                if(1 == isSafe(tempList, false)) return 1;
            }
            return 0;
        } else {
            return 0;
        }
        
    }

}
