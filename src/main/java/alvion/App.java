package alvion;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        while ( true ) {
            System.out.print("Enter input line: ");
            String str = scanner.nextLine();
            if ( "".equals(str) )
                break;
            System.out.println("Transliterated  : " + Translit.convert(str) );
        }
    }
}
