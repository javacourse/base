package alvion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bob on 21.01.15.
 */
public class AppSearch {
    public static void main( String[] args ) {
        System.out.println("Enter text for search : ");

        try{
            Search newObj = new Search();
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String str = bufferRead.readLine();

            System.out.println(newObj.Find(str));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
