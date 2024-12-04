package Day03;

import java.util.List;

import Utils.InputObjectifier;
import Utils.Searches;

public class Solution1 {
    public static void main(String[] args) {
        Long solution = 0l;
        String input = InputObjectifier.inputToString("Day03/input.txt");
        List<String> realInstructions = Searches.findAllSubStrRegex(input, "mul\\([0-9]{1,3},[0-9]{1,3}\\)");
        for(String instruction:realInstructions){
            int commaLoc = instruction.indexOf(",");
            solution += Integer.parseInt(instruction.substring(4, commaLoc)) * 
                        Integer.parseInt(instruction.substring(commaLoc+1,instruction.length()-1));
        }
        System.out.println(solution);
    }
}
