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
        expectedPatten = "(.*)([A|a])(.*)";
        expectedList.clear();
        expectedList.add("A...");
        expectedList.add("A...B...");
        expectedList.add("A...B...C...");
        expectedList.add("xxxxAbcxxxxxxxxx");
        expectedList.add("xxxxAbcxxxxxxxxxAbc");
        expectedList.add("Fake 1");
        expectedList.add("Fake 2");
        doCase("case 1");
    }

    public void case2() {
        userPatten = null;
        expectedPatten = "";
        expectedList.clear();
        expectedList.addAll(sourceList);
        doCase("case 2");
    }

    public void case3() {
        userPatten = "Ab";
        expectedPatten = "(.*)([A|a])(.*)([B|b])(.*)";
        expectedList.clear();
        expectedList.add("A...B...");
        expectedList.add("A...B...C...");
        expectedList.add("xxxxAbcxxxxxxxxx");
        expectedList.add("xxxxAbcxxxxxxxxxAbc");
        doCase("case 3");
    }

    public void doCase(String msg){
        assertEquals(msg, expectedPatten, SearchProcessor.getSearchPattern(userPatten));
        sp.setSearchPattern(SearchProcessor.getSearchPattern(userPatten));
        sp.process();
        System.out.println(msg + "=" + SearchProcessor.getSearchPattern(userPatten));
        System.out.println(msg + "=" + sp.getSearchResult());
        assertArrayEquals(msg, expectedList.toArray(), sp.getSearchResult().toArray());
    }

    @Test
    public void test() {
        init();
        case1();
        case2();
        case3();
    }
}