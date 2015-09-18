package pipesandfilters.kwic.filters;

import pipesandfilters.kwic.main.Data;
import pipesandfilters.kwic.pipes.Pipe;

/**
 * Created by luisburgos on 20/08/15.
 */
public abstract class Filter {

    private Pipe pipe;

    public void setPipe(Pipe pipe){
        this.pipe = pipe;
    }

    public Pipe getPipe(){return pipe;}

    public abstract void processData(Data data);

}
