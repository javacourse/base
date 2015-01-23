package alvion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class FileListTest {

    private FileList fileList;
    private File testFile;

    @Before
    public void setUp() throws Exception {
        fileList = new FileList();
    }

    @After
    public void tearDown() throws Exception {
        testFile.delete();
    }

    @Test
    public void testGetFileListFile() throws Exception {
        System.out.println("testGetFileListFile");
        testFile= new File("C:\\Users\\Odour\\Documents\\Test\\TestFile.txt");
        testFile.createNewFile();
        final long actualFileSize = testFile.length();
        final boolean actualFileDirStatus = false;
        final String actualFileName = "TestFile.txt";

        List<FileInfo> checkFileCollection = fileList.getFileList("C:\\Users\\Odour\\Documents\\Test\\");

        assertEquals(checkFileCollection.size(), 1);
        assertEquals(checkFileCollection.get(0).getFileName(), actualFileName);
        assertEquals(checkFileCollection.get(0).getSize(), actualFileSize);
        assertEquals(checkFileCollection.get(0).isDir(), actualFileDirStatus);
    }

    @Test
    public void testGetFileListDir() throws Exception {
        System.out.println("testGetFileListDir");
        testFile= new File("C:\\Users\\Odour\\Documents\\Test\\TestDir");
        testFile.mkdir();
        final long actualFileSize = 0;
        final boolean actualFileDirStatus = true;
        final String actualFileName = "TestDir";

        List<FileInfo> checkFileCollection = fileList.getFileList("C:\\Users\\Odour\\Documents\\Test\\");

        assertEquals(checkFileCollection.size(), 1);
        assertEquals(checkFileCollection.get(0).getFileName(), actualFileName);
        assertEquals(checkFileCollection.get(0).getSize(), actualFileSize);
        assertEquals(checkFileCollection.get(0).isDir(), actualFileDirStatus);
    }
}