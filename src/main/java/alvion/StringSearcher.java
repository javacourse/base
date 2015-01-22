package alvion;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Odour on 21.01.2015.
 */
public class StringSearcher {

    private Set<String> originalCollection;
    private Set<String> foundElements;

    public StringSearcher(Set<String> originalCollection) {
        this.originalCollection = originalCollection;
        }

    public Set<String> findElements(String inputString) {
        foundElements = new HashSet();
        lookForElements(inputString);

        return foundElements;
    }

    private void lookForElements(String stringToFind) {
        for (String currentElement: originalCollection) {
            if (currentElement.toLowerCase().contains(stringToFind.toLowerCase())) {
                foundElements.add(currentElement);
                continue;
            } else if (lookForByTitleChars(stringToFind, currentElement)) {
                foundElements.add(currentElement);
                continue;
            }
        }
    }

    private boolean lookForByTitleChars(String stringForSearching, String elementToMatch) {
        char[] stringForSearchingChars = stringForSearching.toCharArray();

        if (stringForSearching.length() > elementToMatch.length()) {
            return false;
        }

        for (char curChar: stringForSearchingChars) {
            if (!Character.isUpperCase(curChar)) {
                return false;
            }
        }

        return matchTitleCaseCharToString(elementToMatch, stringForSearching);
    }

    private boolean matchTitleCaseCharToString(String stringForSearching, String charsForSearching) {
        StringBuilder strBuilder = new StringBuilder();

        for (char curChar: stringForSearching.toCharArray()) {
            if (Character.isUpperCase(curChar)) {
                strBuilder.append(curChar);
            }
        }

        String charsToMatch = strBuilder.toString();

        for (int i = 0; i < charsForSearching.length(); i++) {
            if (charsToMatch.charAt(i) == charsForSearching.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
