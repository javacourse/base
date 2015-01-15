package alvion;

/**
 * Created by Odour on 15.01.2015.
 */
public class Transliterator {

    public String transliterateString(String stringToTranslit) {
        if (!"".equals(stringToTranslit)) {
            StringBuilder transliteratedStringBuilder = new StringBuilder();
            char[] charArray = stringToTranslit.toCharArray();

            for (char character: charArray) {
                transliteratedStringBuilder.append(transliterateCharDifferentCase(character));
            }
            return transliteratedStringBuilder.toString();
        }
        else {
            return "";
        }
    }

    private String transliterateCharDifferentCase(char charToTranslit) {
        if (Character.isUpperCase(charToTranslit)) {
            String transliteratedCharLC = transliterateCharLowercase(Character.toLowerCase(charToTranslit));

           return toTitleCase(transliteratedCharLC);
        } else {
            return transliterateCharLowercase(Character.toLowerCase(charToTranslit));
        }
    }

    private String transliterateCharLowercase(char charToTranslit) {
        switch(charToTranslit) {
            case 'а': return "a";
            case 'б': return "b";
            case 'в': return "v";
            case 'г': return "g";
            case 'д': return "d";
            case 'е': return "e";
            case 'ё': return "e";
            case 'ж': return "zh";
            case 'з': return "z";
            case 'и': return "i";
            case 'й': return "y";
            case 'к': return "k";
            case 'л': return "l";
            case 'м': return "m";
            case 'н': return "n";
            case 'о': return "o";
            case 'п': return "p";
            case 'р': return "r";
            case 'с': return "s";
            case 'т': return "t";
            case 'у': return "u";
            case 'ф': return "f";
            case 'х': return "kh";
            case 'ц': return "ts";
            case 'ч': return "ch";
            case 'ш': return "sh";
            case 'щ': return "shh";
            case 'ъ': return "";
            case 'ы': return "y";
            case 'ь': return "";
            case 'э': return "e";
            case 'ю': return "yu";
            case 'я': return "ya";
            default: return String.valueOf(charToTranslit);
        }
    }

    private String toTitleCase(String inputString) {
        if (inputString.length() == 1) {
            return inputString.toUpperCase();
        } else {
            StringBuilder titleCaseStringBuilder = new StringBuilder();
            char[] charArray = inputString.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (i == 0) {
                    titleCaseStringBuilder.append(Character.toUpperCase(charArray[i]));
                }
                else {
                    titleCaseStringBuilder.append(charArray[i]);
                }
            }
            return titleCaseStringBuilder.toString();
        }
    }
}
