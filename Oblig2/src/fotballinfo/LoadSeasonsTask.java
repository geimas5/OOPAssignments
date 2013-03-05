package fotballinfo;

import fotballinfo.data.*;
import java.util.concurrent.ExecutionException;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class LoadSeasonsTask extends SwingWorker<SeasonInfo[], String> {

    private YearView yearView;
    private IDataProvider dataProvider;
    
    public LoadSeasonsTask(YearView yearView, IDataProvider dataProvider) {
        this.yearView = yearView;
        this.dataProvider = dataProvider;
    }
    
    @Override
    protected SeasonInfo[] doInBackground() throws Exception {
        return this.dataProvider.findSeasons();
    }
    
    @Override
    protected void done() {
        SeasonInfo[] seasons = new SeasonInfo[0];
        
        try {
            seasons = get();
        } catch (InterruptedException ignore) {}
        catch (ExecutionException exception) {
            JOptionPane.showMessageDialog(yearView, "An error occured while loading the info, pleace try again");
            System.out.println(exception.getMessage());
        }
        
        yearView.SetSeasons(seasons);
    }
}
