package alvion;

import java.util.HashMap;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by elazarchuk on 1/19/15.
 */
public class Translitiration {
    final private HashMap<Character,String> transMap;
//    private String[] rus      = {"а","б","в","г","д","е","ё","ж" ,"з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ц" ,"ч" ,"ш" ,"щ"  ,"ъ","ы","ь","э","ю" ,"я"};
//    private String[] translit = {"a","b","v","g","d","e","e","zh","z","i","y","k","l","m","n","o","p","r","s","t","u","f","h","ts","ch","sh","sch","'","y","'","e","yu","ya"};

    public Translitiration(){
        this.transMap = new HashMap<>();
        this.transMap.put('а', "a");
        this.transMap.put('б', "b");
        this.transMap.put('в', "v");
        this.transMap.put('г', "g");
        this.transMap.put('д', "d");
        this.transMap.put('е', "e");
        this.transMap.put('ё', "e");
        this.transMap.put('ж', "zh");
        this.transMap.put('з', "z");
        this.transMap.put('и', "i");
        this.transMap.put('й', "y");
        this.transMap.put('к', "k");
        this.transMap.put('л', "l");
        this.transMap.put('м', "m");
        this.transMap.put('н', "n");
        this.transMap.put('о', "o");
        this.transMap.put('п', "p");
        this.transMap.put('р', "r");
        this.transMap.put('с', "s");
        this.transMap.put('т', "t");
        this.transMap.put('у', "u");
        this.transMap.put('ф', "f");
        this.transMap.put('х', "h");
        this.transMap.put('ц', "ts");
        this.transMap.put('ч', "ch");
        this.transMap.put('ш', "sh");
        this.transMap.put('щ', "sch");
        this.transMap.put('ъ', "'");
        this.transMap.put('ы', "y");
        this.transMap.put('ь', "'");
        this.transMap.put('э', "e");
        this.transMap.put('ю', "yu");
        this.transMap.put('я', "ya");
        this.transMap.put('А', "A");
        this.transMap.put('Б', "B");
        this.transMap.put('В', "V");
        this.transMap.put('Г', "G");
        this.transMap.put('Д', "D");
        this.transMap.put('Е', "E");
        this.transMap.put('Ё', "E");
        this.transMap.put('Ж', "Zh");
        this.transMap.put('З', "Z");
        this.transMap.put('И', "I");
        this.transMap.put('Й', "Y");
        this.transMap.put('К', "K");
        this.transMap.put('Л', "L");
        this.transMap.put('М', "M");
        this.transMap.put('Н', "N");
        this.transMap.put('О', "O");
        this.transMap.put('П', "P");
        this.transMap.put('Р', "R");
        this.transMap.put('С', "S");
        this.transMap.put('Т', "T");
        this.transMap.put('У', "U");
        this.transMap.put('Ф', "F");
        this.transMap.put('Х', "H");
        this.transMap.put('Ц', "Ts");
        this.transMap.put('Ч', "Ch");
        this.transMap.put('Ш', "Sh");
        this.transMap.put('Щ', "Sch");
        this.transMap.put('Ъ', "'");
        this.transMap.put('Ы', "Y");
        this.transMap.put('Ь', "'");
        this.transMap.put('Э', "E");
        this.transMap.put('Ю', "Yu");
        this.transMap.put('Я', "Ya");
    }
    
    public String translitirate(String input){
        StringBuilder output = new StringBuilder();
        Set keys = this.transMap.keySet();
        for (int i = 0; i < input.length(); i++) {
            char currentLetter = input.charAt(i);
            output.append(
                keys.contains(currentLetter) ? this.transMap.get(currentLetter) :currentLetter
            );
        }
        return output.toString();
    }

}
