package fotballinfo;

import fotballinfo.data.*;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class LoadSeasonTask extends SwingWorker<LoadSeasonTaskResult, String> {
    
    private SeasonView seasonView;
    private IDataProvider dataProvider;
    private Date from;
    private Date to;
    
    public LoadSeasonTask(SeasonView seasonView, IDataProvider dataProvider, Date from, Date to) {
        this.seasonView = seasonView;
        this.dataProvider = dataProvider;
        this.from = from;
        this.to = to;
    }

    @Override
    protected LoadSeasonTaskResult doInBackground() throws Exception {
        TeamSeasonInfo[] teams = dataProvider.findTeams(from, to);
        MatchInfo[] matches = dataProvider.findMatches(from, to);
        
        return new LoadSeasonTaskResult(matches, teams);
    }
    
    @Override
    protected void done() {
        LoadSeasonTaskResult result = new LoadSeasonTaskResult(new MatchInfo[0], new TeamSeasonInfo[0]);
        
        try {
            result = get();
        } catch (InterruptedException ignore) {}
        catch (ExecutionException exception) {
            JOptionPane.showMessageDialog(seasonView, "An error occured while loading the info, pleace try again");
            System.out.println(exception.getMessage());
        }
        
        seasonView.setMatches(result.getMatches());
        seasonView.setTeams(result.getTeams());
    }
}
