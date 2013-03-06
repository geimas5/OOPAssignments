package fotballinfo;

import fotballinfo.data.*;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class LoadSeasonTaskResult {
    private MatchInfo[] matches;
    private TeamSeasonInfo[] teams;
    
    public LoadSeasonTaskResult(MatchInfo[] matches, TeamSeasonInfo[] teams) {
        this.matches = matches;
        this.teams = teams;
    }
    
    public MatchInfo[] getMatches() {
        return matches;
    }
    
    public TeamSeasonInfo[] getTeams() {
        return this.teams;
    }
}
