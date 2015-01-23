package alvion;

import java.io.IOException;
import java.nio.file.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by dma on 1/22/15.
 */
public class FilesList {
    public static Set<FileInfo> getDirContent(String path) {
        Set<FileInfo> result = new TreeSet<>(new FileInfoComparator());
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(path))) {
            for (Path file: stream) {
                result.add(new FileInfo(file.toFile()));
            }
            return result;
        } catch (IOException | DirectoryIteratorException e) {
            System.err.println(e);
            return result;
        }
    }
}
