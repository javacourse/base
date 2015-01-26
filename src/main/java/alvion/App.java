package alvion;

/**
 * Created by egetman on 1/15/2015.
 */

import java.io.IOException;
import java.util.*;


public  class  App{

    public  static void  main(String[] args) throws IOException {
        Scanner  input=  new  Scanner(System.in);
        //ArrayList<String> tree= new ArrayList();
        //SearchString searchString = new SearchString();//
        //RusToEng rusToEng = new RusToEng();//Class transliteration
        /*tree.add("Appendable");
        tree.add("ArithmetricException");
        tree.add("ArrayndexOfBoundsException");
        tree.add("ArrayStoreException");
        tree.add("AssertionError");
        tree.add("AutoCloseable");
        tree.add("Boolean");*/
        ArrayList<FileInfo> list1 = new ArrayList<FileInfo>();

        do  {
            System.out.println ("\n  Enter phrase for search:  "  );
            String phrase =  input.nextLine();//Read Line

           //if line isEmpty Exit
            if (!phrase.equals("")) {
                try {
                    list1 = FileList.getFiles(phrase);
                    Collections.sort(list1);
                    for (FileInfo s : list1) {
                        System.out.println(s.toString());
                    }
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }

                //Search phrase
                //int totalElem = tree.size();

                //for (int i=0; i<totalElem; i++) {
                //        if (true == searchString.SearchString(tree.get(i),phrase)) {
                //            System.out.println("  Array element[" + i + "] contains " + tree.get(i));// output result
                //        }else{
                //            System.out.println("  Array element[" + i + "] doesn't contain: " + tree.get(i));
                //        }
                //    }
                //Translitiration
                //String engPhrase = RusToEng.rusToEng(phrase);//Use method RusToEng class rusToEng
                //System.out.println("  You phrase in Eng : \n" + engPhrase);// output result
            }else       {
                System.exit(0);
            }
        }  while  (true);
    }
}
