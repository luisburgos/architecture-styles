package layers.kwic.alphabetizer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by luisburgos on 17/08/15.
 */
public class Alphabetize {

    public List<String> sortAlphabetic(List<String> combinations){

        Collections.sort(combinations, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.toLowerCase()).compareToIgnoreCase(o2.toLowerCase());
            }
        });


        return combinations;
    }

}
