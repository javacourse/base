package alvion;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by dmitroza on 22.01.15.
 */
public class FileList {
    public static ArrayList<FileObject> getFiles(String path) throws Exception{
        ArrayList<FileObject> fO = new ArrayList<FileObject>();
        File dir = new File(path);
        File[] fList = dir.listFiles();
        for(File f: fList) {
            FileObject fObj = new FileObject(f.getName(),f.isDirectory(),f.length());
            fO.add(fObj);
        }
        return fO;
    }
    public static ArrayList<String> showFiles(ArrayList<FileObject> files) throws Exception{
        ArrayList<String> s = new ArrayList<String>();
        for(FileObject f: files) {
            s.add(f.getName()+"|"+f.getIsDir()+"|"+f.getSize());
        }
        return s;
    }
}
