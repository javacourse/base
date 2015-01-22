package alvion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest {

    private PatternFinder finder;
    private String testSting;
    private List<String> test;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSplitStringByUpperCaseLetter() throws Exception {

        testSting= "AaaBbb";
        List<String> test = new ArrayList<String>();
        test.add(testSting);
        finder = new PatternFinder(test);

        ArrayList<String> message = finder.MatchPatternList("Aa");
        assertEquals(message.size(),1);
        assertEquals(message.get(0), testSting);
        System.out.println("Test testSplitStringByUpperCaseLetter Succeed");
    }


    @Test
    public void testSplitStringByUpperCaseLetterAllLowerCase() throws Exception {

        testSting = "aaaaaaa";
        test = new ArrayList<String>();
        test.add(testSting);
        finder = new PatternFinder(test);

        ArrayList<String> message = finder.MatchPatternList("aa");
        assertEquals(message.size(),1);
        assertEquals(message.get(0), testSting);
        System.out.println("Test testSplitStringByUpperCaseLetterAllLowerCase Succeed");
    }

    @Test
    public void testSplitStringByUpperCaseLetterAllUpperCase() throws Exception {

        testSting = "AAAAA";
        test = new ArrayList<String>();
        test.add(testSting);
        finder = new PatternFinder(test);


        ArrayList<String> message = finder.MatchPatternList("AA");
        assertEquals(message.size(),1);
        assertEquals(message.get(0), testSting);
        System.out.println("Test testSplitStringByUpperCaseLetterAllUpperCase Succeed");
    }

    @Test
    public void testSplitStringByUpperCaseLetterStartWithUpperCase() throws Exception {

        testSting = "AaaaaaB";
        test = new ArrayList<String>();
        test.add(testSting);
        finder = new PatternFinder(test);


        ArrayList<String> message = finder.MatchPatternList("Aa");
        assertEquals(message.size(),1);
        assertEquals(message.get(0), testSting);
        System.out.println("Test testSplitStringByUpperCaseLetterStartWithUpperCase Succeed");
    }

    @Test
    public void testSplitStringByUpperCaseLetterStartWithLowerCase() throws Exception {

        testSting = "aaaaaB";
        test = new ArrayList<String>();
        test.add(testSting);
        finder = new PatternFinder(test);


        ArrayList<String> message = finder.MatchPatternList("aaB");
        assertEquals(message.size(),1);
        assertEquals(message.get(0), testSting);
        System.out.println("Test testSplitStringByUpperCaseLetterStartWithLowerCase Succeed");
    }


    @Test
    public void testSplitStringByUpperCaseLetterEndWithLowerCase() throws Exception {

        testSting = "aaaaaBa";
        test = new ArrayList<String>();
        test.add(testSting);
        finder = new PatternFinder(test);


        ArrayList<String> message = finder.MatchPatternList("aBa");
        assertEquals(message.size(),1);
        assertEquals(message.get(0), testSting);
        System.out.println("Test testSplitStringByUpperCaseLetterEndWithLowerCase Succeed");
    }


    @Test
    public void testSplitStringByUpperCaseLetterCantFind() throws Exception {

        testSting = "aaaaaBa";
        test = new ArrayList<String>();
        test.add(testSting);
        finder = new PatternFinder(test);


        ArrayList<String> message = finder.MatchPatternList("ab");
        assertEquals(message.size(),0);
        System.out.println("Test testSplitStringByUpperCaseLetterCantFind Succeed");
    }

    @After
    public void tearDown() throws Exception {
        testSting= null;
        finder = null;
        test = null;
    }

}

