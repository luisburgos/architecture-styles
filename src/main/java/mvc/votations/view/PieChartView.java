package mvc.votations.view;


import mvc.votations.events.Event;
import mvc.votations.misc.Observer;
import mvc.votations.model.Candidate;
import mvc.votations.model.Votations;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Created by luisburgos on 2/09/15.
 */
public class PieChartView implements Observer {

    private ChartFrame frame;
    private JFreeChart chart;
    private DefaultPieDataset data;

    public PieChartView(){
        draw();
    }

    private void draw(){
        data = new DefaultPieDataset();

        loadData();

        chart = ChartFactory.createPieChart(
                "Votaciones",
                data,
                true,
                true,
                false);

        frame = new ChartFrame("Pie Chart", chart);
        frame.pack();
        frame.setVisible(true);
    }

    private void loadData() {
        for(Candidate c : Votations.getInstance().getCandidates()){
            data.setValue(c.getName(), c.getVotes());
        }
    }

    public void display() {
        data.clear();
        loadData();
        frame.repaint();
    }

    public void update(Event event) {
        display();
    }
}
