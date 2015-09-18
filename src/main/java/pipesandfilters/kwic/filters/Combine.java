package pipesandfilters.kwic.filters;

import pipesandfilters.kwic.main.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luisburgos on 20/08/15.
 */
public class Combine extends Filter {

    @Override
    public void processData(Data data) {
        permuteWords(data);
        getPipe().send(data);
    }

    private void permuteWords(Data data){

        List<String> permutedList = new ArrayList<>();

        String actualPhrase = data.getPhrase();
        int N = actualPhrase.split(" ").length;
        int count = 0;
        while(count <= N-1){
            permutedList.add(actualPhrase);
            actualPhrase = swap(actualPhrase);
            count++;
        }

        data.setPermutedList(permutedList);
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
