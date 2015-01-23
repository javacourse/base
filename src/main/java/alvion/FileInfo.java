package alvion;

import java.io.File;
import java.util.Comparator;

/**
 * Created by dma on 1/22/15.
 */
public class FileInfo {
    private String name;
    private boolean isDir;
    private long size;
    private File file;

    FileInfo(File file) {
        this.file = file;
        this.name = file.getName();
        this.isDir = file.isDirectory();
        this.size = file.length();
    }

    public String getName() {
        return name;
    }

    public boolean isDir() {
        return isDir;
    }

    public long getSize() {
        return size;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        if (isDir) {
            return "\\" + name;
        } else {
            return " " + name + " (" + size + ")";
        }
    }
}

