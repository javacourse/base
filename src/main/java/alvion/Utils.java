package alvion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by dma on 1/16/15.
 */
public class Utils {
    public static final String SEPARATOR = "=";
    public static final String INPUT_FILE_KEY = "-i";
    public static final String OUPUT_FILE_KEY = "-o";
    public static final String DICT_FILE_KEY = "-d";
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void writeFile(String path, List<String> buff){
        Path pathSource = Paths.get(path);
        if (Files.exists(pathSource, LinkOption.NOFOLLOW_LINKS)) {
            try {
                Files.delete(pathSource);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try (FileOutputStream wr = new FileOutputStream(path)) {
            for (String s : buff) {
                wr.write(s.getBytes());
                wr.write(LINE_SEPARATOR.getBytes());
                wr.flush();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
