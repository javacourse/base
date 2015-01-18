package alvion;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransliteratorTest {


    private Transliterator transliterator;

    @Before
    public void setUp(){
        transliterator = new Transliterator();
    }

    @Test
    public void testTranslate(){
        assertEquals(
                "ABVGDEEZhZIIKLMNOPRSTUFHCChShSch'Y'EUYaabvgdeezhziiklmnoprstufhcchshsch'y'euya",
                transliterator.translate("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя")
        );
    }


}
