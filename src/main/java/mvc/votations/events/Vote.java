package mvc.votations.events;


import mvc.votations.misc.EventTypes;

/**
 * Created by luisburgos on 10/09/15.
 */
public class Vote extends Event {

    public Vote(){
        super(EventTypes.VOTE, "New vote");
    }

    public Vote(String eventInformation) {
        super(EventTypes.VOTE, eventInformation);
    }

    @Override
    public String toString() {
        return getType() + getEventInformation();
    }
}
