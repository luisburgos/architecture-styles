package layers.kwic.main;

import layers.kwic.alphabetizer.Alphabetize;
import layers.kwic.generator.Generator;
import layers.kwic.io.IO;

/**
 * Created by luisburgos on 17/08/15.
 */
public class Main {
    public static void main(String[] args) {

        //Layers declarations
        IO io                   = new IO();
        Generator generator     = new Generator();
        Alphabetize alphabetize = new Alphabetize();

        //Layers setup
        io.setLayer(generator);
        generator.setLayer(alphabetize);

        //Actions
        io.generateOutput(Words.LACASAAZUL.toString());
        io.showOutput();

        io.generateOutput(Words.LACASAVERDE.toString());
        io.showOutput();

        io.generateOutput(Words.RANDOM.toString());
        io.showOutput();

        //io.generateOutput(Words.BIGSTRING.toString());
        //io.showOutput();
    }
}
