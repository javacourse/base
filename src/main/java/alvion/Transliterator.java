package alvion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Transliterator{
    private static Map<Character, String> letters = new HashMap<>();
    private String text;

    public Transliterator(){
        this.setChars();
    }

    private void setChars(){
        letters.put('А', "A");
        letters.put('Б', "B");
        letters.put('В', "V");
        letters.put('Г', "G");
        letters.put('Д', "D");
        letters.put('Е', "E");
        letters.put('Ё', "E");
        letters.put('Ж', "Zh");
        letters.put('З', "Z");
        letters.put('И', "I");
        letters.put('Й', "I");
        letters.put('К', "K");
        letters.put('Л', "L");
        letters.put('М', "M");
        letters.put('Н', "N");
        letters.put('О', "O");
        letters.put('П', "P");
        letters.put('Р', "R");
        letters.put('С', "S");
        letters.put('Т', "T");
        letters.put('У', "U");
        letters.put('Ф', "F");
        letters.put('Х', "H");
        letters.put('Ц', "C");
        letters.put('Ч', "Ch");
        letters.put('Ш', "Sh");
        letters.put('Щ', "Sh");
        letters.put('Ъ', "'");
        letters.put('Ы', "Y");
        letters.put('Ь', "'");
        letters.put('Э', "E");
        letters.put('Ю', "U");
        letters.put('Я', "Ya");
        letters.put('а', "a");
        letters.put('б', "b");
        letters.put('в', "v");
        letters.put('г', "g");
        letters.put('д', "d");
        letters.put('е', "e");
        letters.put('ё', "e");
        letters.put('ж', "zh");
        letters.put('з', "z");
        letters.put('и', "i");
        letters.put('й', "i");
        letters.put('к', "k");
        letters.put('л', "l");
        letters.put('м', "m");
        letters.put('н', "n");
        letters.put('о', "o");
        letters.put('п', "p");
        letters.put('р', "r");
        letters.put('с', "s");
        letters.put('т', "t");
        letters.put('у', "u");
        letters.put('ф', "f");
        letters.put('х', "h");
        letters.put('ц', "c");
        letters.put('ч', "ch");
        letters.put('ш', "sh");
        letters.put('щ', "sh");
        letters.put('ъ', "'");
        letters.put('ы', "y");
        letters.put('ь', "'");
        letters.put('э', "e");
        letters.put('ю', "u");
        letters.put('я', "ya");
    }

    public String translate(){
        StringBuilder builder = new StringBuilder();
        char [] chars = this.text.toCharArray();
        for (char aChar : chars) {
            if(letters.get(aChar)==null){
                builder.append(aChar);
            }else{
                builder.append(letters.get(aChar));
            }
        }
        return builder.toString();
    }

    public void readLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.text = reader.readLine();
    }

    public void writeLine(){
        System.out.println(translate());
    }
}