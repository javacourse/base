package alvion;

/**
 * Created by Odour on 23.01.2015.
 */
public class FileInfo implements Comparable{

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

    public FileInfo(String fileName, boolean dirFlag, long size) {
        this.fileName = fileName;
        this.isDir = dirFlag;
        this.size = size;
    }

    @Override
    public int compareTo(Object o) {
        FileInfo obj = (FileInfo) o;
        return fileName.compareTo(obj.getFileName());
    }
}
