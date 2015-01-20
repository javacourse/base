package alvion;

import junit.framework.TestCase;

public class AlvionCollectionTest extends TestCase {

    public void testFindStr() throws Exception {
        AlvionCollection ac = new AlvionCollection();
        ac.add("FirstString");
        ac.add("Fisrt String");
        ac.add("fstring");
        ac.add("offset");
        ac.add("blabla");
        AlvionCollection ac1 = new AlvionCollection();
        ac1.add("FirstString");
        ac1.add("Fisrt String");
        ac1.add("fstring");
        ac1.add("offset");
        assertEquals(ac.findStr("fs"),ac1);

    }
}