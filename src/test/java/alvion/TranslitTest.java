package alvion;

import org.junit.Test;

import static org.junit.Assert.*;

public class TranslitTest {

    @Test
    public void testHelloWorld() throws Exception {
        Translit translit = new Translit();
        String result = translit.translit("Привет мир!");
        assertEquals("Privet mir!", result);
    }
}