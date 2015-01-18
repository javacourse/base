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
        String resultLetter;

        switch(charToTranslit) {
            case 'а': resultLetter = "a"; break;
            case 'б': resultLetter = "b"; break;
            case 'в': resultLetter = "v"; break;
            case 'г': resultLetter = "g"; break;
            case 'д': resultLetter = "d"; break;
            case 'е': resultLetter = "e"; break;
            case 'ё': resultLetter = "e"; break;
            case 'ж': resultLetter = "zh"; break;
            case 'з': resultLetter = "z"; break;
            case 'и': resultLetter = "i"; break;
            case 'й': resultLetter = "y"; break;
            case 'к': resultLetter = "k"; break;
            case 'л': resultLetter = "l"; break;
            case 'м': resultLetter = "m"; break;
            case 'н': resultLetter = "n"; break;
            case 'о': resultLetter = "o"; break;
            case 'п': resultLetter = "p"; break;
            case 'р': resultLetter = "r"; break;
            case 'с': resultLetter = "s"; break;
            case 'т': resultLetter = "t"; break;
            case 'у': resultLetter = "u"; break;
            case 'ф': resultLetter = "f"; break;
            case 'х': resultLetter = "kh"; break;
            case 'ц': resultLetter = "ts"; break;
            case 'ч': resultLetter = "ch"; break;
            case 'ш': resultLetter = "sh"; break;
            case 'щ': resultLetter = "shh"; break;
            case 'ъ': resultLetter = ""; break;
            case 'ы': resultLetter = "y"; break;
            case 'ь': resultLetter = ""; break;
            case 'э': resultLetter = "e"; break;
            case 'ю': resultLetter = "yu"; break;
            case 'я': resultLetter = "ya"; break;
            default: resultLetter = String.valueOf(charToTranslit);
        }
        return resultLetter;
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
