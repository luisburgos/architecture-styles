package mvc.votations;

import mvc.votations.controller.Controller;
import mvc.votations.controller.NewCandidateController;
import mvc.votations.controller.VotesController;
import mvc.votations.events.Event;
import mvc.votations.events.NewCandidate;
import mvc.votations.events.Vote;
import mvc.votations.model.Model;
import mvc.votations.model.Votations;
import mvc.votations.view.BarChartView;
import mvc.votations.view.PieChartView;

/**
 * Created by luisburgos on 2/09/15.
 */
public class Main {

    public static void main(String[] args) {

        Event voteEvent         = new Vote("New vote");
        Event newCandidateEvent = new NewCandidate("New candidate");

        //Votations
        Model votations = Votations.getInstance(); //Initialize the model loads the data.

        //Views
        PieChartView pieChartView = new PieChartView();
        BarChartView barChartView = new BarChartView();

        //Controllers
        Controller votesController = new VotesController(votations, voteEvent);
        Controller newCandidateController = new NewCandidateController(votations, newCandidateEvent);

        //Register
        votations.register(voteEvent, pieChartView);
        votations.register(voteEvent, barChartView);

        votations.register(newCandidateEvent, pieChartView);
        votations.register(newCandidateEvent, barChartView);
        votations.register(newCandidateEvent, votesController);

    }
}
