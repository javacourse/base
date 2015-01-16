package alvion;

import java.lang.reflect.Array;

/**
 * Created by ifrey on 14.01.2015.
 * This class transliterate input string to latin characters using TYP (Traveller's Yellow Pages Transliteration) system
 * http://www.avantec.ru/?hti=41&ti=1
 */
public class Translit {
    private static char[] rr = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
    private static String[] tr = {"a","b","v","g","d","e","yo","zh","z","i","y","k","l","m","n","o","p","r","s","t","u","f","kh","ts","ch","sh","shch","\"","y","'","e","yu","ya"};

    public static StringBuffer convert(String sIn) {
        StringBuffer sOut = new StringBuffer();
        int i, j;
        char c;
        boolean isRussionLetter;
        for (i=0; i < sIn.length(); i++) {
            c = sIn.charAt(i);
            isRussionLetter = false;
            j = 0;
            for (j=0; j < rr.length; j++) {
                if (Character.toLowerCase(c)==rr[j]) {
                    isRussionLetter = true;
                    if (Character.isLowerCase(c)) sOut.append(tr[j]);
                    else sOut.append(tr[j].toUpperCase());
                    break;
                }
            }
            if (!isRussionLetter) sOut.append(c);   // not russian letter -> copy input character to output buffer
        }
        return sOut;
    }
}
