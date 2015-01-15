package alvion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tsavranskiy on 15.01.15.
 */
public class Translit {
    private static final Map<String, String> chars = new HashMap<String, String>();
    static {
        chars.put("а", "a");
        chars.put("б", "b");
        chars.put("в", "v");
        chars.put("г", "g");
        chars.put("д", "d");
        chars.put("е", "e");
        chars.put("ё", "e");
        chars.put("ж", "j");
        chars.put("з", "z");
        chars.put("и", "i");
        chars.put("й", "i");
        chars.put("к", "k");
        chars.put("л", "l");
        chars.put("м", "m");
        chars.put("н", "n");
        chars.put("о", "o");
        chars.put("п", "p");
        chars.put("р", "r");
        chars.put("с", "s");
        chars.put("т", "t");
        chars.put("у", "u");
        chars.put("ф", "f");
        chars.put("х", "h");
        chars.put("ц", "c");
        chars.put("ч", "ch");
        chars.put("ш", "sh");
        chars.put("щ", "");
        chars.put("ъ", "");
        chars.put("ы", "");
        chars.put("ь", "");
        chars.put("э", "e");
        chars.put("ю", "u");
        chars.put("я", "ya");
    }

    public String convertString(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            String l = str.substring(i, i+1);
            if (chars.containsKey(l)) {
                sb.append(chars.get(l));
            } else {
                sb.append(l);
            }
        }
        return sb.toString();
    }
}
