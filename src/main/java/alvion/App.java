package alvion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Transliterator transliterator  = new Transliterator();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();


        System.out.println(transliterator.translate(text));

    }

    String helloWorld()
    {
        return "Hello world!";
    }
}
