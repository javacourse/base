package alvion;

/**
 * Created by egetman on 1/15/2015.
 */
import java.util.ArrayList;
import java.util.Scanner;

public  class  App{

    public  static void  main(String[] args)  {
        Scanner  input=  new  Scanner(System.in);
        ArrayList<String> tree= new ArrayList();
        SearchString searchString = new SearchString();//
        RusToEng rusToEng = new RusToEng();//Class transliteration

        tree.add("Appendable");
        tree.add("ArithmetricException");
        tree.add("ArrayndexOfBoundsException");
        tree.add("ArrayStoreException");
        tree.add("AssertionError");
        tree.add("AutoCloseable");
        tree.add("Boolean");

        do  {
            System.out.println ("\n  Enter phrase for search:  "  );
            String phrase =  RusToEng.rusToEng(input.nextLine());//Read Line and transliterate
            //if line isEmpty Exit
            if (!phrase.equals("")) {
                int totalElem = tree.size();

                for (int i=0; i<totalElem; i++) {
                        if (true == searchString.SearchString(tree.get(i),phrase)) {
                            System.out.println("  Array element[" + i + "] contains " + tree.get(i));// output result
                        }else{
                            System.out.println("  Array element[" + i + "] doesn't contain: " + tree.get(i));
                        }
                    }
                //String engPhrase = RusToEng.rusToEng(phrase);//Use method RusToEng class rusToEng
                //System.out.println("  You phrase in Eng : \n" + engPhrase);// output result
            }else       {
                break;
            }
        }  while  (true);
    }
}
