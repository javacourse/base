package alvion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        BufferedReader consoleLineReader = new BufferedReader(new InputStreamReader(System.in));
        FileList fl = new FileList();
        String currentLine;

        System.out.println("Please enter path for searching...");

        try {
            currentLine = consoleLineReader.readLine();
            List<FileInfo> filesArray = fl.getFileList(currentLine);
            for (FileInfo curFile : filesArray) {
                System.out.println(curFile.getFileName() + " " + curFile.isDir());
            }
            System.out.println("Tap Enter to finish...");
            consoleLineReader.readLine();
        } catch (Exception e) {
            System.out.println("Error reading console line...");
            System.exit(1);
        }
    }
}
