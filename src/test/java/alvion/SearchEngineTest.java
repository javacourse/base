package alvion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SearchEngineTest {

    private App appToTest;
    private SearchEngine srchEngToTest;


    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
        appToTest = new App();
        srchEngToTest = new SearchEngine();
        srchEngToTest.populate(appToTest.openResourceFileStream("/some_java_classes.txt"));
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void testSearchBySubstringOneStrFound() throws Exception {
        String expected = "MissingFormatArgumentException";
        String toFind = "missForArg";
        String[] foundStrings = srchEngToTest.searchBySubstring(toFind);

        assertEquals(1, (long)foundStrings.length);

        assertEquals(expected, foundStrings[0]);
    }

    @Test
    public void testSearchBySubstringMulStrFound() throws Exception {
        String[] expectedResult = new String[] {
                "ClosedFileSystemException",
                "FileSystemAlreadyExistsException",
                "FileSystemException",
                "FileSystemLoopException",
                "FileSystemNotFoundException",
                "ReadOnlyFileSystemException",
                "SystemException"};

        String toFind = "temExc";
        String[] foundStrings = srchEngToTest.searchBySubstring(toFind);

        assertArrayEquals(expectedResult, foundStrings);
    }

    @Test
    public void testSplitLine() throws Exception {
        String[] expectedResult = new String[] {
                "miss",
                "URL",
                "For",
                "Arg"};
        String toSplit = "missURLForArg";
        List<String> splited = SearchEngine.splitLine(toSplit);
        assertArrayEquals(expectedResult, splited.toArray(new String[0]));

    }

    @Test
    public void testTrimDelimiters() throws Exception {

        assertEquals("DynEnumStub", SearchEngine.trimDelimiters("_DynEnumStub_._"));

    }

}