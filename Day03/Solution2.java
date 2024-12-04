package Day03;

import java.util.List;

import Utils.InputObjectifier;
import Utils.Searches;

public class Solution2 {
    public static void main(String[] args) {
        Long solution = 0l;
        boolean toBeAdded = true;
        String input = InputObjectifier.inputToString("Day03/input.txt");
        List<String> realInstructions = Searches.findAllSubStrRegex(input, "don\\'t\\(\\)|do\\(\\)|mul\\([0-9]{1,3},[0-9]{1,3}\\)");
        for(String instruction:realInstructions){
            if(toBeAdded && instruction.startsWith("m")){
                int commaLoc = instruction.indexOf(",");
                solution += Integer.parseInt(instruction.substring(4, commaLoc)) * 
                        Integer.parseInt(instruction.substring(commaLoc+1,instruction.length()-1));
            } else if(instruction.startsWith("don")){
                toBeAdded = false;
            } else if(instruction.startsWith("do(")){
                toBeAdded= true;
            }
        }
        System.out.println(solution);
    }
}
