package alvion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class AppTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void testHelloWorld() throws Exception {
        App app = new App();
        final String message = app.helloWorld();
        System.out.println("Hello world!");
        assertEquals("Hello world!", message);
    }

    @Test
    public void testPaths() throws Exception {
        Path path = Paths.get("D:/test/testfile.txt");
        Files.createFile(path);
        assertTrue(Files.exists(path));
    }

    @Test
    public void testFiles() throws Exception {
        File file = new File("D:\\test\\testfile2.txt");
        file.createNewFile();
        assertTrue(file.exists());
    }
}