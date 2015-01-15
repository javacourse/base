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
    public static void main( String[] args )
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String income = null;

        try {
            income = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }

        Translit translit = new Translit();
        System.out.println(translit.convertString(income));
        System.out.println();
        System.out.println("Exit.");
    }
}
