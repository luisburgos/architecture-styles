package pipesandfilters.kwic.filters;

import pipesandfilters.kwic.main.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by luisburgos on 20/08/15.
 */
public class Alphabetize extends Filter {

    @Override
    public void processData(Data data) {
        sortAlphabetic(data);
        getPipe().send(data);
    }

    private void sortAlphabetic(Data data){
        Collections.sort(data.getPermutedList(),new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.compareToIgnoreCase(o2));
            }
        });
    }

}
