package alvion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {

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
        App app = new App();
        final String message = app.helloWorld();
        System.out.println("Hello world!");
        assertEquals("Hello world!", message);
    }
}