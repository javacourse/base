
package alvion;/**

 * Created by ragham on 21.01.2015.
 */

public class SearchString {

    public static boolean SearchString (String item , String text){

       char[] linetext = text.toCharArray();
       char[] lineitem = item.toCharArray();
       boolean flag;


        if(Character.isUpperCase(linetext[0])){
            StringBuilder builder = new StringBuilder();
            String line; // = new char[10];
            String str;

            for(int i = 0; i < lineitem.length; i++) {

                if (Character.isUpperCase(lineitem[i])) {
                    builder.append(lineitem[i]);

                }
            }

            line = builder.toString();
            flag = line.toUpperCase().contains(text.toUpperCase());
            //System.out.print(" line = "+line.toString()+" text= "+text +" Flag= "+flag);
        }else{
            flag = item.toLowerCase().contains(text.toLowerCase());
        }

        return flag;

    }
}
