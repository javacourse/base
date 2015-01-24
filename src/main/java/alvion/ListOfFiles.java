package alvion;

import java.io.File;
import java.io.IOException;


public class ListOfFiles {
    static Boolean isFile;
    static String fileName;
    static String absolutePath;

    public static File[] findFiles(String Path, boolean isTest) throws IOException{
        //ArrayList<String> List= new ArrayList();
        //String list[] = new File(Path).list();

        File f = new File(Path);
        String[] list;
        File[] listOfFiles;

        if (!f.exists()) {
            throw new IOException("File doesn't exist " + Path + ": No such file or directory");
        } else {
            if (f.isFile()){
                isFile = true;
                fileName = f.getName();
                absolutePath = f.getAbsolutePath();

                listOfFiles = f. listFiles();
            }else {
                listOfFiles = f.listFiles();
            }
        //list = f.list();

        }
        return listOfFiles;//f.listFiles();
    }
}
