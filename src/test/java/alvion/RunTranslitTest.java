package alvion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RunTranslitTest {

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
    public void testHelloWorld() throws Exception {
        final String reply = RunTranslit.doTransliteration(ct_sample);
        System.out.println(ct_sample);
        System.out.println(reply);
        assertEquals(ct_correct_reply, reply);
    }
}