package alvion;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        Translitiration translitiration = new Translitiration();
        if(args.length != 0) {
            String str = args[0];
            for (int i = 1; i < args.length; i++) {
                str = str.concat(" ").concat(args[i]);
            }
            System.out.println( str );
            System.out.println( translitiration.Translitirate(str) );
        }else{
            System.out.println( "Не хватает аргумента" );
        }

    }

    String helloWorld()
    {
        return "Hello world!";
    }
}
