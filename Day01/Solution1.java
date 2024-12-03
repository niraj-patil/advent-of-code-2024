package Day01;

import java.util.Collections;
import java.util.List;
import Utils.InputObjectifier;

public class Solution1{
    public static void main(String[] args) {
        Long solution = 0l;
        List<List<Integer>> input = InputObjectifier.inputToMultipleListsVertical("Day01/input.txt");
        
        for(List<Integer> list : input){
            Collections.sort(list);
        }
        for(int i = 0 ; i < input.get(0).size() ; i++){
            solution += Math.abs(input.get(0).get(i) - input.get(1).get(i));
        }

        System.out.println(solution);
    }
}