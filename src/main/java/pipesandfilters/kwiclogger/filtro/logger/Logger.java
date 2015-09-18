package pipesandfilters.kwiclogger.filtro.logger;

import java.util.ArrayList;

/**
 * Created by luisburgos on 27/08/15.
 */
public class Logger {

    private ArrayList<LogHandler> handlers;
    static Logger logger;

    private Logger(){
        handlers = new ArrayList<>();
    }

    public synchronized static Logger getLogger(){
        if(logger == null){
            logger = new Logger();
            //logger.addHandler(new ConsoleHandler());
            logger.addHandler(new FileHandler());
        }
        return logger;
    }

    public void setSimpleHandler(LogHandler newHandler){
        this.handlers.add(newHandler);
    }

    public void addHandler(LogHandler handlerToAdd){
        if(handlers != null){
            this.handlers.add(handlerToAdd);
        }
    }

    public void log(Class className, String message){
        for(LogHandler handler : handlers){
            handler.log(className, message);
        }
    }

}
