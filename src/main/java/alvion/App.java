package alvion;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class App {

    public static void main (String args[]) throws IOException {

        Scanner scanner   = new Scanner(System.in);
        String mainPath = System.getProperty("user.home");

        System.out.print(mainPath + ">");

        while (scanner.hasNextLine()) {
            String out =  scanner.nextLine();
            String[] outString = out.split("\\s+");

            if (out.isEmpty()) {
                System.out.print(mainPath + ">");
                continue;
            }

            if (out.equals("stop")){
                break;
            }

            if (outString.length == 1 ) {
                if (outString[0].equals("cd")) {
                    System.out.println("path is requirement (cd pathname)");
                    System.out.print(mainPath + ">");
                    continue;
                }
                else if (outString[0].equals("ls")) {
                    File pathName = new File(mainPath);
                    if (pathName.exists()) {
                        TreeSet<String> files = FileSystem.scanFileSystem(mainPath);
                        for (String c : files) {
                            System.out.println(c);
                        }
                    }
                    else {
                        System.out.println("Path not found");
                    }

                    System.out.print(mainPath + ">");
                    continue;
                }
                else {
                    System.out.println("Command not found.");
                    System.out.print(mainPath + ">");
                    continue;
                }
            }
            else if (outString.length >= 2 && outString[0].equals("cd")) {
                String path = outString[1];
                File tempPath = new File(path);

                if (path.charAt(0) == '/') {
                    if (tempPath.exists()) {
                        mainPath = path;
                        System.out.print(mainPath + ">");
                    }
                    continue;
                }
                else {
                    tempPath = new File(mainPath + "/" + path);

                    if (tempPath.exists()) {
                        mainPath += "/" + path;
                    }
                    else {
                        System.out.println("Path not found");
                    }

                    System.out.print(mainPath + ">");
                    continue;
                }
            }
            else {
                System.out.println("Command not found.");
                System.out.print(mainPath + ">");
            }
        }
    }

}