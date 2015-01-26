package alvion;

/**
 * Created by inn on 22.01.2015.
 */
public class FileInfo implements Comparable<FileInfo>
{

    public String name;
    public long size;
    public boolean isFile;

    /* @Override*/
    public int compareTo(FileInfo other) {
        return name.compareTo(other.name);
    }

    public String getName()
    {
        if (isFile)
            return ".." + name;
        else
            return name;
    }
}