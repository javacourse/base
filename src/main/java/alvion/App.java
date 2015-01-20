package alvion;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AlvionCollection ac = new AlvionCollection();
        ac.add("FirstString");
        ac.add("2stString");
        ac.add("3rdString");
        ac.add(" String");
        ac.add("Nth String");
        System.out.println(ac.findStr("FS"));
    }
}
