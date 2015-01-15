package alvion;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if (args.length == 0)
        {
            System.out.println( "Enter your text as program parameter" );
            return;
        }

        StringBuilder  resultString = new StringBuilder();

        for (int i = 0; i < args.length ; i++) {
            resultString.append(transiterateArgument(args[i]));
            resultString.append(" ");
        }

        System.out.println( "transleterated result : "+ resultString.toString());
    }


    private static String transiterateArgument(String arg)
    {
        StringBuilder  resultString = new StringBuilder();
        for (int i = 0; i < arg.length() ; i++) {
            char symbol = Character.toLowerCase(arg.charAt(i));

            switch (symbol)
            {
                case 'а':
                    resultString.append("a");
                    break;
                case 'б':
                    resultString.append("b");
                    break;
                case 'в':
                    resultString.append("v");
                    break;
                case 'г':
                    resultString.append("g");
                    break;
                case 'д':
                    resultString.append("d");
                    break;
                case 'е':
                    resultString.append("e");
                    break;
                case 'ё':
                    resultString.append("e");
                    break;
                case 'ж':
                    resultString.append("dj");
                    break;
                case 'з':
                    resultString.append("z");
                    break;
                case 'и':
                    resultString.append("i");
                    break;
                case 'й':
                    resultString.append("yi");
                    break;
                case 'к':
                    resultString.append("k");
                    break;
                case 'л':
                    resultString.append("l");
                    break;
                case 'м':
                    resultString.append("m");
                    break;
                case 'н':
                    resultString.append("n");
                    break;
                case 'о':
                    resultString.append("o");
                    break;
                case 'п':
                    resultString.append("p");
                    break;
                case 'р':
                    resultString.append("r");
                    break;
                case 'с':
                    resultString.append("s");
                    break;
                case 'т':
                    resultString.append("t");
                    break;
                case 'У':
                    resultString.append("u");
                    break;
                case 'ф':
                    resultString.append("f");
                    break;
                case 'х':
                    resultString.append("h");
                    break;
                case 'ц':
                    resultString.append("c");
                    break;
                case 'ч':
                    resultString.append("ch");
                    break;
                case 'ш':
                    resultString.append("sh");
                    break;
                case 'щ':
                    resultString.append("sh");
                    break;
                case 'ъ':
                    resultString.append("");
                    break;
                case 'ы':
                    resultString.append("i");
                    break;
                case 'ь':
                    resultString.append("");
                    break;
                case 'э':
                    resultString.append("e");
                    break;
                case 'ю':
                    resultString.append("u");
                    break;
                case 'я':
                    resultString.append("ya");
                    break;
                default:
                    resultString.append(arg.charAt(i));
                    break;
            }
        }

        return resultString.toString();
    }
}
