package alvion;
/**
 * Created by egetman on 1/15/2015.
 */
public class RusToEng {
    public static String rusToEng (String text){
        char[] abcCyr = {'а', 'б', 'в','г','д','ё','ж','з','и','к','л','м','н','п','р','с','т','у','ў','ф','х','ц','ш','щ','ы','э','ю','я'};
        String[] abcLat = {"a","b","v","g","d","jo","zh","z","i","k","l","m","n","p","r","s","t","u","w","f","h","ts","sh","sch","","e","ju","ja"};

        StringBuilder builder = new StringBuilder();
        boolean isFound = false;
        int symbolnumber = -1;//comment

        for (int i = 0; i < text.length(); i++) {
            for(int x = 0; x < abcCyr.length; x++ ) {
                isFound = false;
                symbolnumber = -1;
                if (text.charAt(i) == abcCyr[x]) {
                    isFound = true;
                    symbolnumber = x;
                    break;
                }
            }
            if (isFound == true) {
                builder.append(abcLat[symbolnumber]);
            } else {
                builder.append(text.charAt(i));
            }
        }

        return builder.toString();
    }
}
