package alvion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Translitiration translitiration = new Translitiration();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter user name : ");
        String username = null;
/*        try {
            username = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        username = "Это пример русского текста для транслитерации";
        System.out.println(translitiration.translitirate(username));
        
        System.out.println();
    }

    String helloWorld() {
        return "Hello world!";
    }
}
