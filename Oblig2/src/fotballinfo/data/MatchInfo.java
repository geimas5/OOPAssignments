package fotballinfo.data;

import java.util.*; 

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class MatchInfo {
    private Date date;
    private String homeTeam;
    private String awayTeam;
    private int homeGoals;
    private int awayGoals;
    
    public MatchInfo(Date date, String homeTeam, String awayTeam, int homeGoals, int awayGoals ) {
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public String getHomeTeam() {
        return this.homeTeam;
    }
    
    public String getAwayTeam() {
        return this.awayTeam;
    }
    
    public int getHomeGoals() {
        return this.homeGoals;
    }
    
    public int getAwayGoals() {
        return this.awayGoals;
    }
    
    public int getPoints() {
        if(this.homeGoals != this.awayGoals)
            return 3;
       
        return 1;
    }
}
