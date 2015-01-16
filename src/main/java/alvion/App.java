package alvion;

/**
 * Created by egetman on 1/15/2015.
 */
import java.util.Scanner;

public  class  App{

    public  static void  main(String[] args)  {
        Scanner  input=  new  Scanner(System.in);

        //RusToEng rte =  new RusToEng();

        do  {
            System.out.println ("\n  Enter  Rus phrase :  "  );
            String phrase =  input.nextLine();//Read Line
            if (!phrase.equals("")) {
                String engPhrase = RusToEng.rusToEng(phrase);//Use method RusToEng class rusToEng
                System.out.println("  You phrase in Eng : \n" + engPhrase);// output result
            }else       {
                break;
            }
        }  while  (true);
    }
}
