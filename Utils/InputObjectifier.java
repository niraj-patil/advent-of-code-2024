package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputObjectifier {

    public static String inputToString(String path){
        return readFile(path);
    }

    public static List<List<Integer>> inputToMultipleListsVertical(String path){
        String input = readFile(path);
        List<String[]> rows = Arrays.stream(input.trim().split("\\n"))
                .map(line -> line.trim().split("\\s+")) // Split each line into columns
                .collect(Collectors.toList());

        // Determine the number of columns
        int numColumns = rows.get(0).length;

        // Create lists for each column
        List<List<Integer>> columnLists = IntStream.range(0, numColumns)
                .mapToObj(colIndex -> rows.stream()
                .map(row -> Integer.parseInt(row[colIndex])) // Extract column values
                .collect(Collectors.toList()))
                .collect(Collectors.toList());

        return columnLists;
    }

    public static List<List<Integer>> inputToMultipleListsHorizontal(String path){

        String input = readFile(path);
        List<List<Integer>> rowLists = new ArrayList<>();
        
        String[] lines = input.trim().split("\\n");
        for (String line : lines) {
            // Split each line into columns and convert to integers
            List<Integer> row = Arrays.stream(line.trim().split("\\s+"))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());
            rowLists.add(row);
        }

        return rowLists;
    }

    public static List<List<Character>> inputToCharMatrix(String path){
        int line = 0, letter =0;
        String input = readFile(path);
        List<List<Character>> charMatrix = new ArrayList<>();
        if(input.length()>0) charMatrix.add(new ArrayList<Character>());
        while(letter<input.length()-1){
            if(input.charAt(letter) == '\n') {
                charMatrix.add(new ArrayList<Character>());
                line++;
                letter++;
                continue;
            }
            charMatrix.get(line).add(input.charAt(letter));
            letter++;
        }
        return charMatrix;
    }

    private static String readFile(String file)  {
        try (BufferedReader reader = new BufferedReader(new FileReader (file))) {
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");
   
            try {
                while((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }
   
                return stringBuilder.toString();
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Exception while reading file";
    }
}
