package pipesandfilters.kwic.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luisburgos on 20/08/15.
 */
public class Data {

    private List<String> words;
    private String phrase;
    private List<String> permutedList;

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public List getPermutedList() {
        return permutedList;
    }

    public void setPermutedList(List permutedList) {
        this.permutedList = permutedList;
    }

    @Override
    public String toString() {
        return getPermutedList().toString();
    }
}
