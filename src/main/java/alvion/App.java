package alvion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Transliterator transliterator = new Transliterator();
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
            }
        }
    }

