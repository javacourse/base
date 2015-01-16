package alvion;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by dma on 1/16/15.
 */
public class Params {
    private String[] params;

    private String inputFile;

    private String outputFile;

    private String dictionaryFile;

    Params (String ... params) {
        this.params = params;
        parseParams();
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public String getDictionaryFile() {
        return dictionaryFile;
    }

    private void parseParams() {
        for (String s : params) {
            if (s.indexOf(Utils.INPUT_FILE_KEY) != -1) {
                inputFile = s.substring(Utils.INPUT_FILE_KEY.length()).trim();
            }
            if (s.indexOf(Utils.OUPUT_FILE_KEY) != -1) {
                outputFile = s.substring(Utils.OUPUT_FILE_KEY.length()).trim();
            }
            if (s.indexOf(Utils.DICT_FILE_KEY) != -1) {
                dictionaryFile = s.substring(Utils.DICT_FILE_KEY.length()).trim();
            }
        }
    }

}
