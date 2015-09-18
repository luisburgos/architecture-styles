package mvc.votations.model;

/**
 * Created by luisburgos on 2/09/15.
 */
public class Candidate {

    private int id;
    private String name;
    private String lastname;
    private String party;
    private int votes;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void incrementVotes(){
        votes++;
    }

    public String getFullName(){
        return getName() + " " + getLastname();
    }

    @Override
    public String toString() {
        return id + " " + name + " " + lastname + " " + party+ " "  + votes;
    }

}
