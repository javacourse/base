package alvion;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Collection {
    public static final String ANSI_GREEN = "\033[42m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static Set<String> search(Set<String> set, String findString) {
        Set<String> newSet = new TreeSet();

        for (String item : set) {
            if (item.toLowerCase().contains(findString.toLowerCase())) {
                Pattern pattern = Pattern.compile("(?i)" + findString);
                Matcher matcher = pattern.matcher(item);

                String substring = matcher.find() ? matcher.group() : "";

                item = item.replaceAll(substring, ANSI_GREEN + substring + ANSI_RESET);
                newSet.add(item);
            }
        }
        return newSet;
    }

    public static void printSet(Set<String> set) {
        if (set.size() > 0) {
            for (String i : set){
                System.out.println(i);
            }
        }
    }
}
