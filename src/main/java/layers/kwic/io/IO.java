package layers.kwic.io;

import layers.kwic.generator.Generator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luisburgos on 17/08/15.
 */
public class IO {

    private Generator generator;
    private List<String> output;

    public void setLayer(Generator generator) {
        this.generator = generator;
    }

    public void generateOutput(String phrase){
        output = generator.generateCombinations(phrase);
    }

    public void showOutput(){
        if(output != null){ System.out.println(output); }
    }
}
