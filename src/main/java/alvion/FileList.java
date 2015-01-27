package alvion;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Odour on 23.01.2015.
 */
public class FileList {

    public List<FileInfo> getFileList(String pathname) {
        File rootDir = new File(pathname);
        List<FileInfo> foundFiles = new ArrayList<>();
        List<FileInfo> files = new ArrayList<>();
        List<FileInfo> dirs = new ArrayList<>();

        if (rootDir.isDirectory()) {
            File[] filesArray = rootDir.listFiles();
            for (File curFile: filesArray) {
                if (curFile.isFile()) {
                    FileInfo file = new FileInfo(curFile.getName(), curFile.isDirectory(), curFile.length());
                    files.add(file);
                } else if (curFile.isDirectory()) {
                    FileInfo file = new FileInfo(curFile.getName(), curFile.isDirectory(), 0);
                    dirs.add(file);
                }
            }

        }

        Collections.sort(files);
        Collections.sort(dirs);

        foundFiles.addAll(dirs);
        foundFiles.addAll(files);

        return foundFiles;
    }
}
