package pipesandfilters.kwic.filters;

import pipesandfilters.kwic.main.Data;

import java.util.Arrays;
import java.util.List;

/**
 * Created by luisburgos on 20/08/15.
 */
public class Separate extends Filter {

    @Override
    public void processData(Data data) {
        separateWords(data);
        getPipe().send(data);
    }

    public void separateWords(Data data){
        String phrase = data.getPhrase();
        String[] words = phrase.split(" ");
        List<String> list = Arrays.asList(words);
        data.setWords(list);
    }

}
