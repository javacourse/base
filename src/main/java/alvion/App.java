package alvion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Initial program.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Enter something here : ");

        try{
            Transliteration newObj = new Transliteration();
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String str = bufferRead.readLine();

           System.out.println(newObj.Convert(str));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    String helloWorld()
    {
        return "Hello world!";
    }
}
