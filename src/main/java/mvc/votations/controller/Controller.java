package mvc.votations.controller;


import mvc.votations.events.Event;
import mvc.votations.misc.Observer;
import mvc.votations.model.Model;

public abstract class Controller implements Observer {

    protected Model mModel;

    public Controller(Model model, Event event){
        mModel = model;
        mModel.register(event, this);
    }

    public abstract void handleEvent(Event event, Object... params);

}
