package alvion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransliteratorTest {

    private Transliterator transliterator;

    @Before
    public void setUp() throws Exception {
     //   System.out.println("setUp");
        transliterator = new Transliterator();
    }

    @After
    public void tearDown() throws Exception {
      //  System.out.println("tearDown");
    }

    @Test
    public void testTransliterateString() throws Exception {
        System.out.println("testTransliterateString");
        String messageToTransliterate = "Щука. КАРАСЬ. ЛоСоСЬ. Whale. $#&%.";
        String correctMessage = "Shhuka. KARAS. LoSoS. Whale. $#&%.";

        String transliteratedMessage = transliterator.transliterateString(messageToTransliterate);

        assertEquals(transliteratedMessage, correctMessage);
    }
}