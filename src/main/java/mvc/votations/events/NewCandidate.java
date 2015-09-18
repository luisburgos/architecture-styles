package mvc.votations.events;


import mvc.votations.misc.EventTypes;

/**
 * Created by luisburgos on 10/09/15.
 */
public class NewCandidate extends Event {

    public NewCandidate() {
        super(EventTypes.NEW_CANDIDATE, "New candidate added");
    }

    public NewCandidate(String eventInformation) {
        super(EventTypes.NEW_CANDIDATE, eventInformation);
    }
}
