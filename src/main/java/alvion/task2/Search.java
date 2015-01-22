package alvion.task2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Toshiba on 19.01.2015.
 */
public class Search {
    private Set<String> searchResults;

    private final String camelCasePattern = "(?<!^)(?=[A-Z])";
    private final String upperCasePattern = "[A-Z]";

    private void searchByWord(String str, String query){
        if(str.toLowerCase().contains(query)){
            searchResults.add(str);
        }
    }
    private void searchByCapitalLetters(String string, String query){
        Pattern pattern = buildSearchPattern(query);
        if(pattern.matcher(string).find()){
            searchResults.add(string);
        }
    }
    private boolean checkIfQueryHasUpperCase(String query){
        Pattern pattern = Pattern.compile(this.upperCasePattern);
        return pattern.matcher(query).find();
    }

    private Pattern buildSearchPattern(String string){
        StringBuilder builder = new StringBuilder();
        String[] parts = string.split(this.camelCasePattern);

        for (int i = 0 ; i < parts.length; i++){
            builder.append(parts[i]).append(".*");
        }

        return Pattern.compile(builder.toString());

    }

    public Set<String> search(String query, Set<String> strings){
        searchResults = new TreeSet<>();

        for(String string : strings){
            if(checkIfQueryHasUpperCase(query)){
                searchByCapitalLetters(string, query);
            }else{
                searchByWord(string, query);
            }

        }

        return searchResults;
    }
}
