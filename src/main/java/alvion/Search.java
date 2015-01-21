package alvion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bob on 21.01.15.
 */
public class Search {
    static String[] codes = {"BufferedReader","IOException","InputStreamReader","Ioexception"};

    public String Find(String inputStr){
        StringBuilder result = new StringBuilder();
        boolean modificationRequiredFlag = inputStr.toUpperCase() == inputStr;
        Pattern pattern = Pattern.compile(new StringBuilder().append(".*?").append(inputStr).append(".*?").toString(), Pattern.CASE_INSENSITIVE);
        Matcher match;

        for (String item : codes) {
            match = (modificationRequiredFlag) ? pattern.matcher(item.replaceAll("[a-z]", "")) : pattern.matcher(item);
            if (match.find()) result.append(item).append(", ");
        }
        return result.toString();
    }
}
