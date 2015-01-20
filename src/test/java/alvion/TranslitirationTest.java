package alvion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TranslitirationTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void testTranslitirate() throws Exception {
        Translitiration app = new Translitiration();
        
        String[][] test = {
            {"",""},
            {"привет","privet"},
            {"Конь","Kon'"},
            {"ЖиМоЛоСтЬ","ZhiMoLoSt'"},
            {"оЗаРеНиЕ","oZaReNiE"},
            {"Привет С Большого Бодуна","Privet S Bol'shogo Boduna"},
            {"Хвалим Защищающихся Ужиков","Hvalim Zaschischayuschihsya Uzhikov"},
        };
        for (String[] test1 : test) {
            assertEquals(test1[1], app.translitirate(test1[0]));
        }
    }
}