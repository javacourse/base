package alvion;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by dma on 1/20/15.
 */
public class SearchProcessor {
    private List<String> searchSource;
    private List<String> searchResult = new ArrayList<String>();
    private String searchPattern;

    public void setSearchSource(List<String> searchSource) {
        this.searchSource = searchSource;
    }

    public void setSearchPattern(String searchPattern) {
        this.searchPattern = searchPattern;
    }

    public List<String> getSearchResult() {
        return searchResult;
    }

    public SearchProcessor() {
    }

    public SearchProcessor(List<String> s, String p) {
        searchSource = s;
        searchPattern = p;
    }

    public void process() {
        searchResult.clear();
        if (searchPattern.equals("")) {
            searchResult.addAll(searchSource);
        } else {
            Pattern p = Pattern.compile(searchPattern);
            for (String s : searchSource) {
                if (p.matcher(s).find()) {
                    searchResult.add(s);
                }
            }
        }
    }

    public static String getSearchPattern(String userPattern) {
        String s  = (userPattern == null ? "" : userPattern);
        StringBuilder result = new StringBuilder();
        if (s.equals("")) {
            return s;
        }
        if (Character.isUpperCase(s.charAt(0))) {
            for (char c : s.toCharArray()) {
                result.append("(.*)([" + Character.toUpperCase(c));
                if (Character.isLetter(c)) {
                    result.append("|" + Character.toLowerCase(c));
                }
                result.append("])");
            }
            result.append("(.*)");
        } else {
            result.append("(.*)" + s + "(.*)");
        }
        return result.toString();
    }

}
