package pipesandfilters.kwic.pipes;

import pipesandfilters.kwic.filters.Filter;
import pipesandfilters.kwic.main.Data;

/**
 * Created by luisburgos on 20/08/15.
 */
public class Pipe {

    private Filter filter;

    public void setFilter(Filter filter){
        this.filter = filter;
    }

    public void send(Data data){
        if(filter != null){
            filter.processData(data);
        }else{
            System.out.println(data.toString());
        }
    }

}
