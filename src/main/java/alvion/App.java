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
        translitirate();
    }
    
    public static void translitirate() {
        Translitiration translitiration = new Translitiration();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите текст для транслитерации : ");
        String username = null;
        try {
            username = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(translitiration.translitirate(username));
        
        System.out.println();
    }

    String helloWorld() {
        return "Hello world!";
    }
}
