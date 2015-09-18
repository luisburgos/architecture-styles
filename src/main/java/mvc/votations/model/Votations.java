package mvc.votations.model;


import mvc.votations.events.NewCandidate;
import mvc.votations.events.Vote;
import mvc.votations.misc.CandidatesToJSON;
import mvc.votations.misc.JSONtoCandidates;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by luisburgos on 10/09/15.
 */
public class Votations extends Model {

    static Votations votations;

    private ArrayList<Candidate> candidates;

    private Votations(){
        super();
        candidates = JSONtoCandidates.loadCandidates();
    }

    public synchronized static Votations getInstance(){
        if(votations == null){
            votations = new Votations();
        }
        return votations;
    }

    public void addVoteToCandidateById(int id){
        candidates.get(id - 1).incrementVotes();
        //System.out.println("Votes to " + candidates.get(id - 1).getFullName());
        CandidatesToJSON.saveCandidates(candidates);
        notify(new Vote());
    }

    public void addCandidate(Candidate candidate){
        int newId = candidates.size();
        candidate.setId(newId + 1);
        candidates.add(candidate);
        CandidatesToJSON.saveCandidates(candidates);
        notify(new NewCandidate());

    }

    public void clearVotes(){
        //Clean votes
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }
}
