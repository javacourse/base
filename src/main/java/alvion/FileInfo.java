package alvion;

/**
 * Created by Odour on 23.01.2015.
 */
public class FileInfo {

    private String fileName;
    private boolean isDir;
    private long size;

    public String getFileName() {
        return fileName;
    }

    public boolean isDir() {
        return isDir;
    }

    public long getSize() {
        return size;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDir(boolean isDir) {
        this.isDir = isDir;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
