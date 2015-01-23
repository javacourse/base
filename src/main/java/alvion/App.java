package alvion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       /* Transliterator transliterator = new Transliterator();
        BufferedReader consoleLineReader = new BufferedReader(new InputStreamReader(System.in));
        String transliteratedText;
        String currentLine;

        System.out.println("Please enter message to transliterate...");

            try {
                currentLine = consoleLineReader.readLine();
                transliteratedText = transliterator.transliterateString(currentLine);
                System.out.println(transliteratedText);
                System.out.println("Tap Enter to finish...");
                consoleLineReader.readLine();
            } catch(Exception e) {
                System.out.println("Error reading console line...");
                System.exit(1);
            }*/

        BufferedReader consoleLineReader = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;
        Set<String> inputValues = getOriginalCollection();
        StringSearcher stringSearcher = new StringSearcher(inputValues);

        System.out.println("Please enter message for searching...");

        try {
            currentLine = consoleLineReader.readLine();
            for (String curElem: stringSearcher.findElements(currentLine)) {
                System.out.println(curElem);
            }
            System.out.println("Tap Enter to finish...");
            consoleLineReader.readLine();
        } catch(Exception e) {
            System.out.println("Error reading console line...");
            System.exit(1);
        }
        }

    private static Set<String> getOriginalCollection() {
        Set<String> inputValues = new HashSet<String>();
        inputValues.add("StringBuilder");
        inputValues.add("StringBuffer");
        inputValues.add("HashMap");
        inputValues.add("TreeMap");
        inputValues.add("TreeSet");
        inputValues.add("LinkedHashSet");
        inputValues.add("ArrayList");

        return inputValues;
    }
    }

