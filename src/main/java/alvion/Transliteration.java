package alvion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bob on 16.01.15.
 */
public class Transliteration {
    static Map<Character, String> codes = new HashMap<Character, String>();
    static {
        codes.put('А', "A");
        codes.put('Б', "B");
        codes.put('В', "V");
        codes.put('Г', "G");
        codes.put('Д', "D");
        codes.put('Е', "Ye");
        codes.put('Ж', "Zh");
        codes.put('З', "Z");
        codes.put('И', "I");
        codes.put('Й', "Y");
        codes.put('К', "K");
        codes.put('Л', "L");
        codes.put('М', "M");
        codes.put('Н', "N");
        codes.put('О', "O");
        codes.put('П', "P");
        codes.put('Р', "R");
        codes.put('С', "S");
        codes.put('Т', "T");
        codes.put('У', "U");
        codes.put('Ф', "F");
        codes.put('Х', "Kh");
        codes.put('Ц', "Ts");
        codes.put('Ч', "Ch");
        codes.put('Ш', "Sh");
        codes.put('Щ', "Shch");
        codes.put('Э', "E");
        codes.put('Ю', "Yu");
        codes.put('Я', "Ya");
        codes.put('а', "a");
        codes.put('б', "b");
        codes.put('в', "v");
        codes.put('г', "g");
        codes.put('д', "d");
        codes.put('е', "ye");
        codes.put('ж', "zh");
        codes.put('з', "z");
        codes.put('и', "i");
        codes.put('й', "y");
        codes.put('к', "k");
        codes.put('л', "l");
        codes.put('м', "m");
        codes.put('н', "n");
        codes.put('о', "o");
        codes.put('п', "p");
        codes.put('р', "r");
        codes.put('с', "s");
        codes.put('т', "t");
        codes.put('у', "u");
        codes.put('ф', "f");
        codes.put('х', "kh");
        codes.put('ц', "ts");
        codes.put('ч', "ch");
        codes.put('ш', "sh");
        codes.put('щ', "shch");
        codes.put('ъ', "\"");
        codes.put('ы', "y");
        codes.put('ь', "'");
        codes.put('э', "e");
        codes.put('ю', "yu");
        codes.put('я', "ya");
    }

    public String Convert(String inputStr){
        StringBuffer result = new StringBuffer();
        char[] charArray = inputStr.toCharArray();
        String symbol;

        for (char i: charArray){
            symbol = codes.get(i);
            result.append((null == symbol) ? i: symbol);
        }

        return result.toString();
    }
}
