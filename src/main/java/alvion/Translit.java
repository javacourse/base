package alvion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Translit {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public String translit(String inputString)
    {
        String outputString = "";

        Map<Character, String> charMap = new HashMap();

        charMap.put('А', "A");
        charMap.put('Б', "B");
        charMap.put('В', "V");
        charMap.put('Г', "G");
        charMap.put('Д', "D");
        charMap.put('Е', "E");
        charMap.put('Ё', "E");
        charMap.put('Ж', "Zh");
        charMap.put('З', "Z");
        charMap.put('И', "I");
        charMap.put('Й', "I");
        charMap.put('К', "K");
        charMap.put('Л', "L");
        charMap.put('М', "M");
        charMap.put('Н', "N");
        charMap.put('О', "O");
        charMap.put('П', "P");
        charMap.put('Р', "R");
        charMap.put('С', "S");
        charMap.put('Т', "T");
        charMap.put('У', "U");
        charMap.put('Ф', "F");
        charMap.put('Х', "H");
        charMap.put('Ц', "C");
        charMap.put('Ч', "Ch");
        charMap.put('Ш', "Sh");
        charMap.put('Щ', "Sh");
        charMap.put('Ъ', "'");
        charMap.put('Ы', "Y");
        charMap.put('Ь', "'");
        charMap.put('Э', "E");
        charMap.put('Ю', "U");
        charMap.put('Я', "Ya");
        charMap.put('а', "a");
        charMap.put('б', "b");
        charMap.put('в', "v");
        charMap.put('г', "g");
        charMap.put('д', "d");
        charMap.put('е', "e");
        charMap.put('ё', "e");
        charMap.put('ж', "zh");
        charMap.put('з', "z");
        charMap.put('и', "i");
        charMap.put('й', "i");
        charMap.put('к', "k");
        charMap.put('л', "l");
        charMap.put('м', "m");
        charMap.put('н', "n");
        charMap.put('о', "o");
        charMap.put('п', "p");
        charMap.put('р', "r");
        charMap.put('с', "s");
        charMap.put('т', "t");
        charMap.put('у', "u");
        charMap.put('ф', "f");
        charMap.put('х', "h");
        charMap.put('ц', "c");
        charMap.put('ч', "ch");
        charMap.put('ш', "sh");
        charMap.put('щ', "sh");
        charMap.put('ъ', "'");
        charMap.put('ы', "y");
        charMap.put('ь', "'");
        charMap.put('э', "e");
        charMap.put('ю', "u");
        charMap.put('я', "ya");

        for (int i = 0; i < inputString.length(); i++) {
            Character currentChar = inputString.charAt(i);
            String symbol = charMap.get(currentChar);

            if (symbol == null) {
                outputString += currentChar;
            }
            else {
                outputString += symbol;
            }
        }
        return outputString;
    }

    public void run() throws IOException {
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(stream);
        String strLine = "";

        System.out.println(ANSI_GREEN + "Enter lines of text." + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Enter 'stop' to quit." + ANSI_RESET);
        System.out.print(ANSI_GREEN + "~" + ANSI_RESET);

        while (!strLine.equals("stop")) {
            strLine = in.readLine();

            if (strLine.equals("stop")) {
                break;
            }
            if (strLine.isEmpty()) {
                System.out.print(ANSI_GREEN + "~" + ANSI_RESET);
            }
            else {
                System.out.println(ANSI_YELLOW + " " + translit(strLine) + ANSI_RESET);
                System.out.print(ANSI_GREEN + "~" + ANSI_RESET);
            }
        }
    }
}
