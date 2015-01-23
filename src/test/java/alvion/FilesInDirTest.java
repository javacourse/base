package alvion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FilesInDirTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void testReadDirectory() throws Exception {
        //

        FilesInDir filesInDir = new FilesInDir();
        String appPath = App.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        StringBuilder testPath = new StringBuilder(appPath.substring(0, appPath.indexOf("target")));
        // removing possible leading slash
        while(testPath.toString().indexOf('/')==0) testPath.deleteCharAt(0);

        System.out.println( testPath );
        for (FilesInDir.FileEntry file : filesInDir.readDirectory(testPath.toString())) {
            System.out.println(file);
        }

        String[] expectedResult = new String[] {
                ".git",
                ".idea",
                "out",
                "src",
                "target",
                ".gitignore",
                "maven-core-project.iml",
                "pom.xml"
        };

        String[] filesRead = filesInDir.getNames();

        assertArrayEquals(expectedResult, filesRead);
    }
}