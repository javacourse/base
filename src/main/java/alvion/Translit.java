package alvion;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by ifrey on 14.01.2015.
 * This class transliterate input string to latin characters using TYP (Traveller's Yellow Pages Transliteration) system
 * http://www.avantec.ru/?hti=41&ti=1
 */
public class Translit {
    private static final Map<Character, String> trMap = new HashMap<Character, String>();
    static {
        trMap.put('а', "a");
        trMap.put('б', "b");
        trMap.put('в', "v");
        trMap.put('г', "g");
        trMap.put('д', "d");
        trMap.put('е', "e");
        trMap.put('ё', "yo");
        trMap.put('ж', "zh");
        trMap.put('з', "z");
        trMap.put('и', "i");
        trMap.put('й', "y");
        trMap.put('к', "k");
        trMap.put('л', "l");
        trMap.put('м', "m");
        trMap.put('н', "n");
        trMap.put('о', "o");
        trMap.put('п', "p");
        trMap.put('р', "r");
        trMap.put('с', "s");
        trMap.put('т', "t");
        trMap.put('у', "u");
        trMap.put('ф', "f");
        trMap.put('х', "kh");
        trMap.put('ц', "ts");
        trMap.put('ч', "ch");
        trMap.put('ш', "sh");
        trMap.put('щ', "shch");
        trMap.put('ъ', "\"");
        trMap.put('ы', "y");
        trMap.put('ь', "'");
        trMap.put('э', "e");
        trMap.put('ю', "yu");
        trMap.put('я', "ya");
    }

    public static StringBuilder convert(String sIn) {
        StringBuilder sb = new StringBuilder();
        int i;
        char c, l;
        String s;
        for (i=0; i < sIn.length(); i++) {
            c = sIn.charAt(i);
            l = Character.toLowerCase(c);
            if (trMap.containsKey(l)) {
                s = trMap.get(l);
                if (Character.isLowerCase(c)) sb.append(s);
                else sb.append(s.toUpperCase());
            }
            else sb.append(c);
        }
        return sb;
    }
}
