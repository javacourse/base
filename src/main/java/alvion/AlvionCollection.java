package alvion;

import java.util.HashSet;

/**
 * Created by dmitroza on 19.01.15.
 */
public class AlvionCollection extends HashSet <String> {
    public AlvionCollection findStr(String s) {
        String re = ".*";
        for (int i = 0; i<s.length(); i++) {
            re += s.toLowerCase().toCharArray()[i]+".*";
        }
        AlvionCollection res = new AlvionCollection();
        for(String cs : this) {
            if (cs.toLowerCase().matches(re))
            res.add(cs);
        }
        return res;
    }
}
