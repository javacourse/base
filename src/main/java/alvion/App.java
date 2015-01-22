package alvion;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ilya Ten
 * Date: 1/14/2015
 * The running class
 */

public class App {
    public static void main(String[] args) {

        // Transliteration
        if (args.length > 0) {
             System.out.println(doTransliteration(args[0]));
        }
        else {
            System.out.println("Please provide text to transliterate as an argument");
        }

        // Find class(es) by provided substring
        if (args.length > 1) {
            String toFind = args[1];
            String[] found = doSearch(toFind);
            if (found == null) {
                // probably something is wrong during buffers population
                return;
            }
            switch (found.length) {
                case 0:
                    System.out.printf("Nothing is found for pattern \"%s\"\n", toFind);
                    break;
                case 1:
                    System.out.printf("The only class containing \"%s\" is \"%s\"", toFind, found[0]);
                    break;
                default:
                    System.out.printf("The following classes contain \"%s\":\n", toFind);
                    for (String stringFound : found) {
                        System.out.println(stringFound);
                    }
            }
        }


    }

    static String doTransliteration(String sample) {
        return Translit.transliterateCyrToLat(sample.toCharArray());
    }

    public static String[] doSearch(String toFind) {
        String[] result = null;
        SearchEngine search = new SearchEngine();
        App app = new App();
        try {
            search.populate(app.openResourceFileStream("/some_java_classes.txt"));
            result = search.searchBySubstring(toFind);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public InputStream openResourceFileStream(String resPath) {
        return getClass().getResourceAsStream(resPath);
    }
}

