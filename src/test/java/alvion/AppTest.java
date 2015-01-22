package alvion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AppTest {

    static String ct_sample = "А роза упала на лапу азора Ё ё that's all 12367!";
    static String ct_correct_reply = "A roza upala na lapu azora JO jo that's all 12367!";


    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void testTransliteration() throws Exception {
        final String reply = App.doTransliteration(ct_sample);
        System.out.println(ct_sample);
        System.out.println(reply);
        assertEquals(ct_correct_reply, reply);
    }

    @Test
    public void testDoSearch() throws Exception {
        String[] expectedResult = new String[] {
                "DynValueBoxOperations",
                "DynValueCommonOperations",
                "DynValueOperations"};

        String[] foundStrings = App.doSearch("dynValOp");

        System.out.println(foundStrings.length);

        assertArrayEquals(expectedResult, foundStrings);
    }

}