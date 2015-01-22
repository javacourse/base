package alvion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Ilya Ten
 * Date: 1/19/2015
 */
public class SearchEngine {

    private static String ct_delimiters = "_.";
    private static String ct_anyChars = ".*";

    // buffers
    private List<String> originalLines; // buffer to store original list of lines to search on
    private SortedMap<String, Integer> lowerCaseLines; // lines in lower case with reference to original list index
    private SortedMap<String, WordIndex> words; // single words with reference to to original list index


    public SearchEngine() {
        originalLines = new ArrayList<>();
        lowerCaseLines = new TreeMap<>();
        words = new TreeMap<>();
    }

    /**
     * Populates buffers to be used in search
     * @param stream input stream to read data from
     * @throws IOException in case a problem with reading data from the input stream
     */
    public void populate(InputStream stream) throws IOException {
        if (stream == null) {
            throw new NullPointerException("cannot read the data, input stream is not initialized");
        }

        if (!originalLines.isEmpty()) {
            // reset the buffer before repopulate
            originalLines.clear();
            lowerCaseLines.clear();
            words.clear();
        }


        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            addLine(line);
        }
        bufferedReader.close();
        streamReader.close();

    }

    /**
     * Splits the string specified into words provided that
     * words are delimited by either any character of ct_delimiters
     * or a character in upper case
     * @param line the string to split
     * @return a list of "words" as split result
     */
    public static List<String> splitLine(String line) {
        List<String> buffer = null;
        int indexToStartRecord = -1;
        boolean previousCharIsCapital = false;

        for (int i = 0; i < line.length(); i++) {
            if (Character.isUpperCase(line.charAt(i))) {
                if (!previousCharIsCapital) {
                    if (i > 0 && indexToStartRecord >= 0) {
                        if (buffer == null) {
                            buffer = new LinkedList<>();
                        }
                        buffer.add(line.substring(indexToStartRecord, i));
                    }
                    indexToStartRecord = i;
                    previousCharIsCapital = true;
                }
            }
            else {

                boolean delim = ct_delimiters.indexOf(line.charAt(i)) >= 0;
                if ((previousCharIsCapital && indexToStartRecord + 1 < i)
                                  || delim && indexToStartRecord >= 0) {
                    if (buffer == null) {
                        buffer = new LinkedList<>();
                    }
                    buffer.add(line.substring(indexToStartRecord, (delim ? i : i - 1)));
                }
                if (delim) {
                    indexToStartRecord = -1;
                }
                else if (previousCharIsCapital) {
                    indexToStartRecord = i - 1;
                }
                else if (indexToStartRecord < 0) {
                    indexToStartRecord = i;
                }
                previousCharIsCapital = false;
            }
        }
        if (indexToStartRecord > 0 && buffer != null) {
            buffer.add(line.substring(indexToStartRecord));
        }
        return buffer;
    }

    /**
     * Trims any of ct_anyChars characters at leftmost/rightmost position of the specified input string
     * @param line the string to trim
     * @return trimmed string
     */
    public static String trimDelimiters(String line) {
        StringBuilder result = new StringBuilder(line);
        while( ct_delimiters.indexOf(result.charAt(0)) >= 0)
            result.deleteCharAt(0); // trim left
        while( ct_delimiters.indexOf(result.charAt(result.length()-1)) >= 0)
            result.deleteCharAt(result.length()-1); // trim right
        return result.toString();
    }

    private void addLine(String line) {
        originalLines.add(line);
        int index = originalLines.size() - 1;
        lowerCaseLines.put(trimDelimiters(line.toLowerCase()), index);
        List<String> lineWords = splitLine(line);
        if (lineWords != null) {
            WordIndex wordIndex;
            int wordSequence = 0;
            for(String word: lineWords) {
                wordIndex = words.get(word.toLowerCase());
                if (wordIndex == null) {
                    wordIndex = new WordIndex();
                    words.put(word.toLowerCase(), wordIndex);
                }
                wordIndex.add(index, wordSequence++);
            }
        }
    }

    private String[] searchMainDict(String subStr) {
        Set<String> result = null;
        String toStr = subStr + "zzz";
        for(Map.Entry entry: lowerCaseLines.tailMap(subStr).headMap(toStr).entrySet()) {
            if (null == result) {
                result = new TreeSet<>();
            }
            result.add(originalLines.get((int) entry.getValue()));
        }
        if (null == result)
            return new String[] {};
        return result.toArray(new String[0]);
    }

    private String[] searchWords(List<String> lineWords) {
        SortedMap<Integer, Integer> wordBaseIndexMap = null;
        SortedSet<Integer> baseIndexesChecked = new TreeSet<>();
        boolean initStep;
        for (String word : lineWords) {
            String fromStr = word.toLowerCase();
            String toStr = fromStr + "zzz";
            initStep = (null == wordBaseIndexMap);
            baseIndexesChecked.clear();
            for(Map.Entry entry: words.tailMap(fromStr).headMap(toStr).entrySet()) {
                WordIndex wordIndexesFound = (WordIndex)entry.getValue();
                if (initStep) {
                    if (null == wordBaseIndexMap) {
                        wordBaseIndexMap = new TreeMap<>();
                    }
                    for (int i = 0; i < wordIndexesFound.length(); i++) {
                        if (!wordBaseIndexMap.containsKey(wordIndexesFound.getMainIndex(i))) {
                            wordBaseIndexMap.put(wordIndexesFound.getMainIndex(i), wordIndexesFound.getWordIndex(i));
                        }
                    }
                }
                else {
                    // the second word and others
                    for (int i = 0; i < wordIndexesFound.length(); i++) {
                        int baseIndex = wordIndexesFound.getMainIndex(i);
                        int wordIndex = wordIndexesFound.getWordIndex(i);
                        if (!baseIndexesChecked.contains(baseIndex)
                                && wordBaseIndexMap.containsKey(baseIndex)
                                && wordBaseIndexMap.get(baseIndex) < wordIndex) {
                            wordBaseIndexMap.put(baseIndex, wordIndex);
                            baseIndexesChecked.add(baseIndex);
                        }
                    }
                }
            }
            if (null == wordBaseIndexMap) break;
            if (!initStep) {
                if (baseIndexesChecked.isEmpty()) {
                    wordBaseIndexMap.clear();
                }
                else {
                    // removing all elements not checked
                    Iterator<Map.Entry<Integer, Integer>> it = wordBaseIndexMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<Integer,Integer> wordBaseIndexEntry = it.next();
                        if (!baseIndexesChecked.contains(wordBaseIndexEntry.getKey())) {
                            it.remove();
                        }
                    }
                }
            }
            if (wordBaseIndexMap.isEmpty()) break;
        }
        if (null == wordBaseIndexMap || wordBaseIndexMap.isEmpty())
            return new String[] {};
        Set<String> result = new TreeSet<>();
        for (int baseIndex : wordBaseIndexMap.keySet()) {
            result.add(originalLines.get(baseIndex));
        }
        return result.toArray(new String[0]);
    }

    /**
     * Searches for the string specified across internal buffers.
     * The buffers assumed being populated before calling the method.
     *
     * @param str string to search
     * @return array of lines found
     */
    public String[] searchBySubstring(String str) {
        List<String> lineWords = splitLine(str);
        String[] result;
        if (lineWords == null) {
            // a single word
            result = searchMainDict(str);
        }
        else {
            // multiple
            result = searchWords(lineWords);
        }
        if (null != result && result.length > 0)
            return result;


        return scanAll(lineWords == null ? patternOfString(str) : patternOfWords(lineWords));
    }

    private String patternOfString(String str) {
        return ct_anyChars + str + ct_anyChars;
    }

    private String patternOfWords(List<String> words) {
        StringBuilder result = new StringBuilder(ct_anyChars);
        for (String word : words) {
            result.append(word);
            result.append(ct_anyChars);
        }
        return result.toString();
    }

    private String[] scanAll(String pattern) {
        List<String> result = new ArrayList<>();
        for(String line : originalLines) {
            if (line.matches(pattern) )
                result.add(line);
        }
        return result.toArray(new String[result.size()]);
    }

    class WordIndex {
        List<Integer> mainIndex;
        List<Integer> wordIndex;
        public WordIndex() {
            mainIndex = new ArrayList<>();
            wordIndex = new ArrayList<>();
        }

        public void add(int base, int word) {
            mainIndex.add(base);
            wordIndex.add(word);
        }

        public int length() {
            return mainIndex.size();
        }

        public int getMainIndex(int itemIndex) {
            return mainIndex.get(itemIndex);
        }

        public int getWordIndex(int itemIndex) {
            return wordIndex.get(itemIndex);
        }

    }
}
