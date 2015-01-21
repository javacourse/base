package alvion;

import junit.framework.TestCase;

public class TransliterationTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        System.out.println("setUp");

    }

    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    public void testConvert() throws Exception {
        Transliteration obj = new Transliteration();
        String message = obj.Convert("ПрОсТо тЕст!");
        assertEquals("Hello world!", message);
    }
}