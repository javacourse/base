package alvion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class App 
{
    public static void main( String[] args ) throws IOException {
        Set<String> set = new TreeSet();

        set.add("Focus on Africa");
        set.add("MindGames Magazine");
        set.add("Who is on duty today?");
        set.add("Sky at Night");
        set.add("Doctor Who Adventures");

        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(stream);

        Set resultSet = Collection.search(set, in.readLine());

        Collection.printSet(resultSet);
    }
}
