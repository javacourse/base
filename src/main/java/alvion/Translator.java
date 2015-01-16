package alvion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dma on 1/16/15.
 */
public class Translator {
    private String path;

    private Dictionary dict;

    private List<String> outBuffer = new ArrayList<>();

    public void setPath(String path) {
        this.path = path;
    }

    public void setDict(Dictionary dict) {
        this.dict = dict;
    }

    Translator(String path, Dictionary dict) {
        this.path = path;
        this.dict = dict;
    }

    public List<String> getConvertedText () {
        return outBuffer;
    }

    public void translate() {
        String s;

        StringBuffer sb = new StringBuffer();

        try(FileReader fr = new FileReader(path);

            BufferedReader br = new BufferedReader(fr)) {

            while ((s = br.readLine()) != null) {
                sb.setLength(0);
                for (int i = 0; i < s.length(); i++) {
                    if (dict.getDictionary().containsKey(s.substring(i, i + 1))) {
                        sb.append(dict.getDictionary().get(s.substring(i, i + 1)));
                    } else {
                        sb.append(s.substring(i, i + 1));
                    }
                }
                outBuffer.add(sb.toString());
            }
        }
        catch (FileNotFoundException fnf) {
            System.out.println("Input file not found: " + path);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
