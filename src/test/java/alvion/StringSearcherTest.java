package alvion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class StringSearcherTest {

    StringSearcher strSearcher;
    Set<String> setForTest;

    @Before
    public void setUp() throws Exception {
        setForTest = new HashSet<String>();
        setForTest.add("StringBuffer");
        setForTest.add("StringBuilder");
        setForTest.add("Testsb");
        setForTest.add("Wont be found");

        strSearcher = new StringSearcher(setForTest);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindElements() throws Exception {
        System.out.println("testFindElements started...");
        final String[] actual = {"Testsb", "StringBuffer", "StringBuilder"};
        final String strToFind = "SB";
        Object[] found = null;

        Set<String> foundElements = strSearcher.findElements(strToFind);
        found = foundElements.toArray();

        assertArrayEquals(found, actual);
    }
}