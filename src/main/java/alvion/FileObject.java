package alvion;

/**
 * Created by dmitroza on 22.01.15.
 */
public class FileObject {
    private String name;
    private boolean isDir;
    private long size;
    public FileObject(String name, boolean isDir, long size){
        this.name = name;
        this.isDir = isDir;
        this.size = size;
    }
    public String getName(){
        return name;
    }
    public boolean getIsDir(){
        return isDir;
    }
    public long getSize(){
        return size;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setIsDir(boolean isDir){
        this.isDir = isDir;
    }
    public void setSize(long size){
        this.size = size;
    }
}
