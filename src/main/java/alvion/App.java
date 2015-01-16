package alvion;

/**
 * Hello world!
 *
 */
/**
 * Created by dma on 1/14/15.
 *
 */
public class App {
    public static void main (String ... arg){
        if (arg.length != 3) {
            System.out.println("Wrong params. Params: -i<input file name> -d<dictionary file name> -o<output file name>");
            return;
        }
        Dictionary dict = new Dictionary();
        Params params = new Params(arg);
        Translator trans;

        dict.setPath(params.getDictionaryFile());

        if (dict.readDictionary()) {
            trans = new Translator(params.getInputFile(), dict);
            trans.translate();
            if (trans.getConvertedText().size() != 0) {
                Utils.writeFile(params.getOutputFile(), trans.getConvertedText());
                System.out.println("Translation completed...");
            }
        }
    }
}
