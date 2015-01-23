package alvion;

import java.io.File;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Ilya Ten
 * Date: 1/22/2015
 */
public class FilesInDir {
    SortedSet<FileEntry> filesList;

    public FilesInDir() {
        filesList = new TreeSet<>();
    }

    public SortedSet<FileEntry> readDirectory(String path) throws NotDirectoryException {
        if (!filesList.isEmpty()) {
            // reset in case rereading
            filesList.clear();
        }

        Path dirToRead = Paths.get(path);
        if (!dirToRead.toFile().isDirectory()) {
            throw new NotDirectoryException(String.format("Path \"%s\" does not correspond to a directory", path));
        }

        for(File file : dirToRead.toFile().listFiles()) {
            filesList.add(new FileEntry(file));
        }

        return filesList;
    }

    public String[] getNames() {
        List<String> result = new ArrayList<>();
        for (FileEntry entry: filesList) {
            result.add(entry.getName());
        }
        return result.toArray(new String[0]);
    }


    public class FileEntry implements Comparable<FileEntry>{
        private String name;
        private boolean isDirectory;
        private long size;

        public FileEntry(File file) {
            name = file.getName();
            isDirectory = file.isDirectory();
            size = file.length();
        }


        public String getName () {
            return name;
        }

        public boolean getIsDirectory () {
            return isDirectory;
        }

        public long getSize() {
            return size;
        }

        @Override
        public String toString() {
            return (isDirectory ? "\\" : "") + name + (isDirectory ? "" : ", " + Long.toString(getSize()));
        }

        @Override
        public int compareTo (FileEntry fileEntry){
            if (isDirectory != fileEntry.getIsDirectory()) {
                if (isDirectory) {
                    return -1; // directories are always in the top
                }
                return 1;
            }

            return String.CASE_INSENSITIVE_ORDER.compare(name, fileEntry.getName());
        }
    }
}
