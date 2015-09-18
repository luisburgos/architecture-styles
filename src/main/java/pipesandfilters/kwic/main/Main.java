package pipesandfilters.kwic.main;

import pipesandfilters.kwic.filters.Alphabetize;
import pipesandfilters.kwic.filters.Combine;
import pipesandfilters.kwic.filters.Filter;
import pipesandfilters.kwic.filters.Separate;
import pipesandfilters.kwic.pipes.Pipe;

/**
 * Created by luisburgos on 20/08/15.
 */
public class Main {

    public static void main(String[] args) {

        //Filters
        Filter separate    = new Separate();
        Filter combine     = new Combine();
        Filter alphabetize = new Alphabetize();

        //Pipes
        Pipe pipeOne, pipeTwo, pipeThree, pipeFour;
        pipeOne   = new Pipe();
        pipeTwo   = new Pipe();
        pipeThree = new Pipe();
        pipeFour  = new Pipe();

        ///Setup pipeline
        pipeOne.setFilter(separate);
        separate.setPipe(pipeTwo);
        pipeTwo.setFilter(combine);
        combine.setPipe(pipeThree);
        pipeThree.setFilter(alphabetize);
        alphabetize.setPipe(pipeFour);

        //Input
        Input in = new Input();

        //The data stream
        Data data = new Data();
        data.setPhrase(in.getInput());

        //Send data through the pipe
        in.sendThroughPipe(data, pipeOne);

    }

}
