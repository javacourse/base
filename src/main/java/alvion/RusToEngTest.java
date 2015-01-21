package alvion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RusToEngTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testRusToEng() throws Exception {

            RusToEng app = new RusToEng();
            final String message = app.rusToEng("тест");
            //System.out.println("Hello world!");
            assertEquals("test", message);

    }
}