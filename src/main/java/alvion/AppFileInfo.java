package alvion;

import java.util.Set;

/**
 * Created by dma on 1/23/15.
 */
public class AppFileInfo {
    public static void main(String ... args) {
        Set<FileInfo> dl = FilesList.getDirContent("C:\\");
        for (FileInfo fi : dl) {
            System.out.println(fi.toString());
        }

    }
}
