package alvion;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class SearchProcessorTest extends TestCase {
    private List<String> sourceList = new ArrayList<>();
    private List<String> expectedList = new ArrayList<>();
    private String userPatten;
    private String expectedPatten;
    private SearchProcessor sp = new SearchProcessor();
    private List<String> resultList;

    @BeforeClass
    public void init() {
        sourceList.clear();
        sourceList.add("A...");
        sourceList.add("A...B...");
        sourceList.add("A...B...C...");
        sourceList.add("xxxxAbcxxxxxxxxx");
        sourceList.add("xxxxAbcxxxxxxxxxAbc");
        sourceList.add("1234567890");
        sourceList.add("Fake 1");
        sourceList.add("Fake 2");
        sp.setSearchSource(sourceList);
        System.out.println(sourceList);
    }

    public void case1() {
        userPatten = "A";
        expectedPatten = "[A]";
        expectedList.clear();
        expectedList.add("A...");
        expectedList.add("A...B...");
        expectedList.add("A...B...C...");
        expectedList.add("xxxxAbcxxxxxxxxx");
        expectedList.add("xxxxAbcxxxxxxxxxAbc");
        doCase();
    }

    public void case2() {
        userPatten = null;
        expectedPatten = "";
        expectedList.clear();
        expectedList.addAll(sourceList);
        doCase();
    }

    public void case3() {
        userPatten = "Ab";
        expectedPatten = "Ab";
        expectedList.clear();
        expectedList.add("xxxxAbcxxxxxxxxx");
        expectedList.add("xxxxAbcxxxxxxxxxAbc");
        doCase();
    }

    public void doCase(){
        assertEquals(expectedPatten, SearchProcessor.getSearchPattern(userPatten));
        sp.setSearchPattern(SearchProcessor.getSearchPattern(userPatten));
        sp.process();
        assertArrayEquals(expectedList.toArray(), sp.getSearchResult().toArray());
        System.out.println(sp.getSearchResult());
    }

    @Test
    public void test() {
        init();
        case1();
        case2();
        case3();
    }
}