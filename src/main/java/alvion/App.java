package alvion;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class App {

    public static void main (String args[]) throws IOException {

        Scanner scanner   = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String out =  scanner.nextLine();

            if (out.isEmpty()) {

                continue;
            }
            if(out.equals("stop")){
                break;
            }

            File pathName = new File(out);
            if(pathName.exists()) {
                TreeSet<String> files = FileSystem.scanFileSystem(out);
                for(String c : files) {
                    System.out.println(c);
                }
            }
            else {
                System.out.println("Path not found");
            }
        }


    }
}