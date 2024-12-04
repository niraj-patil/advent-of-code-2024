package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searches {
    public static int countOccurrences(List<Integer> sortedList, int target) {
        int first = findFirstIndex(sortedList, target);
        if (first == -1) {
            return 0; // Target not found
        }
        int last = findLastIndex(sortedList, target);
        return last - first + 1;
    }

    // Helper method to find the first index of the target
    public static int findFirstIndex(List<Integer> sortedList, int target) {
        int low = 0, high = sortedList.size() - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedList.get(mid) == target) {
                result = mid;
                high = mid - 1; // Continue searching in the left half
            } else if (sortedList.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Helper method to find the last index of the target
    public static int findLastIndex(List<Integer> sortedList, int target) {
        int low = 0, high = sortedList.size() - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedList.get(mid) == target) {
                result = mid;
                low = mid + 1; // Continue searching in the right half
            } else if (sortedList.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static List<String> findAllSubStrRegex(String text, String regex) {
        List<String> matches = new ArrayList<String>();
        Matcher m = Pattern.compile("(?=(" + regex + "))").matcher(text);
        while(m.find()) {
            matches.add(m.group(1));
        }
        return matches;
    }
}
