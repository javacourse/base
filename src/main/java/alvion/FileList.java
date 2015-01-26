package alvion;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by ragham on 22.01.15.
 */
public class FileList {
    public static ArrayList<FileInfo> getFiles(String path) throws Exception{
        ArrayList<FileInfo> fO = new ArrayList<FileInfo>();
        File dir = new File(path);
        File[] fList = dir.listFiles();
        for(File f: fList) {
            FileInfo fObj = new FileInfo(f.getName(), f.isDirectory(),f.length(),f.getAbsolutePath());
            fO.add(fObj);
        }
        //Collections.sort(fO);
        return fO;
    }
    public static ArrayList<String> showFiles(ArrayList<FileInfo> files) throws Exception{
        ArrayList<String> s = new ArrayList<String>();
        String s1;
        for(FileInfo f: files) {
            s.add(f.getIsDir()+"|"+f.getName()+"|"+f.getSize());
            //System.out.println(f.getName()+"|"+f.getIsDir()+"|"+f.getSize()+"|"+f.getabsolutePath());
        }
        //Collections.reverse(s);
        return s;
    }
}