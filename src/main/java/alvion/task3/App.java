package alvion.task3;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Toshiba on 19.01.2015.
 */
public class App {

    public static void main(String[] args) throws Exception {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String path = reader.readLine();
        FileManager fileManager= new FileManager(path);

        List<FileDto> fileList = fileManager.getDirectoryInfo();


        String leftAlignFormat = "| %-50s |  %-16s  |  %-12s |%n";
        System.out.format(leftAlignFormat, "Name", "Size", "Is Directory");
        System.out.println();
        for (FileDto file : fileList) {
            System.out.format(leftAlignFormat, file.getName(), file.getSize(), file.isDir());
        }

    }
}
