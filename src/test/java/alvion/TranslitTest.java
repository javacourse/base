package alvion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TranslitTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("Start Test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Finish Test");
    }

    @Test
    public void testTranslit() throws Exception {
        Translit translit = new Translit();
        final String message = translit.convertString("привет");
        System.out.println("privet");
        assertEquals("privet", message);
    }
}