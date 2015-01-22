package alvion;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;
import static org.junit.Assert.*;

public class CollectionTest {

    @Test
    public void testSearch() throws Exception {
        String string = "Who";

        TreeSet<String> set = new TreeSet();

        assertTrue(set.add("Focus on Africa"));
        assertTrue(set.add("MindGames Magazine"));
        assertTrue(set.add("Who is on duty today?"));
        assertTrue(set.add("Sky at Night"));
        assertTrue(set.add("Doctor Who Adventures"));

        Set resultSet = Collection.search(set, string);

        assertTrue(resultSet.contains("Doctor Who Adventures"));
        assertFalse(resultSet.contains("Sky at Night"));


    }

}