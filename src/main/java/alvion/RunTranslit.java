package alvion;
/**
 * Created by Ilya Ten
 * Date: 1/14/2015
 * The running class
 */

public class RunTranslit {
    public static void main(String[] args) {
        if (args.length > 0) {
             System.out.println(Translit.transliterateCyrToLat(args[0].toCharArray()));
        }
        else {
            System.out.println("Please provide text to transliterate as an argument");
        }
    }
}

