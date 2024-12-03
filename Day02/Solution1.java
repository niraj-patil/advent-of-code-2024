package Day02;

import java.util.List;

import Utils.InputObjectifier;

public class Solution1 {

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
            if(report.get(level+1) == report.get(level)) return 0;
            if(Math.abs(report.get(level+1) - report.get(level)) > 3) return 0;
            if(report.get(level+1) > report.get(level) && !isAsc) return 0;
            if(report.get(level+1) < report.get(level) && isAsc) return 0;
        }
        return 1;
    }
}
