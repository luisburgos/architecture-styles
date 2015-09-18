package mvc.votations.controller;


import mvc.votations.events.Event;
import mvc.votations.events.Vote;
import mvc.votations.misc.EventTypes;
import mvc.votations.model.Candidate;
import mvc.votations.model.Model;
import mvc.votations.model.Votations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Created by luisburgos on 2/09/15.
 */
public class VotesController extends Controller {

    private JFrame mainFrame;
    private JPanel mainPanel;

    public VotesController(Model model, Event event){
        super(model, event);
        prepareGUI();
    }

    private void prepareGUI(){
        mainFrame = new JFrame("Vote Panel");
        mainFrame.setSize(450, 200);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        loadDatGUI();

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    private void loadDatGUI() {
        ArrayList<Candidate> candidates = ((Votations)mModel).getCandidates();

        for(final Candidate candidate : candidates){
            JPanel panelHolder = new JPanel();
            JButton buttonHolder = new JButton("Vote for " + candidate.getFullName());
            buttonHolder.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    handleEvent(new Vote(), candidate.getId());
                }
            });
            panelHolder.add(buttonHolder);
            panelHolder.setLayout(new BoxLayout(panelHolder, BoxLayout.X_AXIS));
            mainPanel.add(panelHolder);
        }
    }

    @Override
    public void handleEvent(Event event, Object... params) {
        int eventType = event.getType();
        if(eventType == EventTypes.VOTE){
            mModel.callFunctionByName(Votations.class, int.class, "addVoteToCandidateById", params);
        }
    }

    public void update(Event event) {
        if(event.getType() == EventTypes.NEW_CANDIDATE){
            System.out.println("Updating votes controller...");
            final int index = Votations.getInstance().getCandidates().size();
            Candidate candidate = Votations.getInstance().getCandidates().get(index - 1);

            JPanel newCandidate = new JPanel();
            JButton button = new JButton("Vote for " + candidate.getFullName());
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    handleEvent(new Vote(), index);
                }
            });

            newCandidate.add(button);
            newCandidate.setLayout(new GridLayout(1, 2));

            mainPanel.add(newCandidate);
            mainFrame.validate();
        }
    }
}
