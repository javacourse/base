package alvion;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransliterationTest2 extends TestCase {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConvert() throws Exception {
        Transliteration obj = new Transliteration();
        String message = obj.Convert("ПрОсТо тЕст!");
        assertEquals("PrOsTo tYest!", message);
    }
}