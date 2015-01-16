package alvion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by dma on 1/16/15.
 */
public class Dictionary {
    private String path;

    private HashMap<String, String> dict = new HashMap<>();

    public void setPath(String path) {
        this.path = path;
    }

    public HashMap getDictionary () {
        return dict;
    }

    public boolean readDictionary() {
        String s;
        int idx;
        boolean result = true;

        try(FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr)) {
            dict.clear();
            while ((s = br.readLine()) != null) {
                idx = s.indexOf(Utils.SEPARATOR);
                if (idx != -1) {
                    dict.put(s.substring(0, idx), s.substring(idx + 1).trim());
                }
            }
        }
        catch (FileNotFoundException fnf) {
            result = false;
            System.out.println("Dictionary file not found: " + path);
        }
        catch (IOException ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }

}
