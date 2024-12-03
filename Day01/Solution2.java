package Day01;

import java.util.Collections;
import java.util.List;

import Utils.InputObjectifier;
import Utils.Searches;

public class Solution2 {

    public static void main(String[] args) {
        Long solution = 0l;
        List<List<Integer>> input = InputObjectifier.inputToMultipleListsVertical("Day01/input.txt");
        
        Collections.sort(input.get(1));
        
        for(int i = 0 ; i < input.get(0).size() ; i++){
            int target = input.get(0).get(i) ;
            solution += target * Searches.countOccurrences(input.get(1), target);
        }

        System.out.println(solution);
    }

}
