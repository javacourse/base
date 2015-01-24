package alvion;

/**
 * Created by egetman on 1/15/2015.
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


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

        do  {
            System.out.println ("\n  Enter phrase for search:  "  );
            String phrase =  input.nextLine();//Read Line
            //if line isEmpty Exit
            if (!phrase.equals("")) {

                File[] list = ListOfFiles.findFiles(phrase, true);
                if (list != null){
                    for(int i = 0; i < list.length; i++) {
                        if (list[i].isDirectory()) {
                            System.out.println("DirName " + list[i].getAbsolutePath());
                        }
                    }
                    for(int i = 0; i < list.length; i++) {
                        if (list[i].isFile()) {
                            System.out.println("FileName " + list[i].getAbsolutePath());
                        }
                    }
                }else {
                    System.out.println("FileName " +ListOfFiles.absolutePath);
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
                break;
            }
        }  while  (true);
    }
}
