package alvion.task3;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.*;

/**
 * Created by Toshiba on 22.01.2015.
 */
public class FileManager {
    private File path;

    public FileManager(String pathname) throws Exception {
        path = new File(pathname);
        if(!path.exists()){
            throw new Exception("Such directory or file does not exist on this server");
        }
    }

    public List<FileDto> getDirectoryInfo(){

        List<FileDto> filesList = new LinkedList<>();
        File[] files = path.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                filesList.add(new FileDto(file.getName(), file.isDirectory(), file.length()));
            }else if(file.isDirectory()){
                filesList.add(new FileDto(file.getName(), file.isDirectory()));
            }
        }
        sortFileList(filesList);

        return filesList;
    }

    private void sortFileList(List<FileDto> filesList) {
        Collections.sort(filesList, new Comparator<FileDto>() {
            @Override
            public int compare(FileDto o1, FileDto o2) {
                if(o1.isDir()&&o2.isDir()){
                    return 0;
                }else if(o1.isDir()){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
    }
}
