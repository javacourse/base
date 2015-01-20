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

    SearchProcessor(List<String> s, String p) {
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
        String result;
        String s  = (userPattern == null ? "" : userPattern);
        Pattern p = Pattern.compile("[A-Z]*");
        if (!s.equals("") && p.matcher(s).matches()) {
            result = "[" + s + "]";
        } else {
            result = s;
        }
        return result;
    }

}
