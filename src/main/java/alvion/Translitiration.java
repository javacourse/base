package alvion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by elazarchuk on 1/19/15.
 */
public class Translitiration {
    private String[] rus      = {"а","б","в","г","д","е","ё","ж" ,"з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ц" ,"ч" ,"ш" ,"щ"  ,"ъ","ы","ь","э","ю" ,"я"};
    private String[] translit = {"a","b","v","g","d","e","e","zh","z","i","y","k","l","m","n","o","p","r","s","t","u","f","h","ts","ch","sh","sch","'","y","'","e","yu","ya"};

    public String translitirate(String input){
        for (int i = 0; i < this.rus.length; i++) {
            input = input.replace(this.rus[i], this.translit[i]);
            input = input.replace(this.rus[i].toUpperCase(), StringUtils.capitalize(this.translit[i]));
        }
        return input;
    }

}
