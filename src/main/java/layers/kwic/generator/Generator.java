package layers.kwic.generator;

import layers.kwic.alphabetizer.Alphabetize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luisburgos on 17/08/15.
 */
public class Generator {

    private Alphabetize alphabetize;

    public void setLayer(Alphabetize alphabetize) {
        this.alphabetize = alphabetize;
    }

    public List<String> generateCombinations(String phrase) {
        return alphabetize.sortAlphabetic(permuteWords(phrase));
    }

    private List<String> permuteWords(String phrase){

        List<String> permutedList = new ArrayList<>();

        String actualPhrase = phrase;
        int N = phrase.split(" ").length;
        int count = 0;
        while(count <= N-1){
            permutedList.add(actualPhrase);
            actualPhrase = swap(actualPhrase);
            count++;
        }
        return permutedList;
    }

    private String swap(String toSwap){

        String[] array = toSwap.split(" ");
        int size = array.length;
        String last = array[size-1];
        int N = size -1;
        while(N > 0){
            array[N] = array[N-1];
            N--;
        }
        array[0] = last;
        String finalString = "";
        for(String s : array){
           finalString = finalString + " " + s;
        }
        return finalString.trim();
    }

}
