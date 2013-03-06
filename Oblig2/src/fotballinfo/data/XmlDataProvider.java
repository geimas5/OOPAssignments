package fotballinfo.data;

import java.util.Date;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class XmlDataProvider implements IDataProvider {

    @Override
    public SeasonInfo[] findSeasons() {
        SeasonInfo[] seasons = new SeasonInfo[2];
        seasons[0] = new SeasonInfo(2008, 3);
        seasons[1] = new SeasonInfo(2009, 32);
        
        return seasons;
    }

    @Override
    public MatchInfo[] findMatches(Date from, Date to) {
        MatchInfo[] matches = new MatchInfo[4];
        matches[0] = new MatchInfo(new Date(), "dfsdf", "dsffs", 3, 4);
        matches[1] = new MatchInfo(new Date(), "dfsdf", "dsffs", 3, 4);
        matches[2] = new MatchInfo(new Date(), "dfsdf", "dsffs", 3, 4);
        matches[3] = new MatchInfo(new Date(), "dfsdf", "dsffs", 3, 4);
        return matches;
    }

    @Override
    public TeamSeasonInfo[] findTeams(Date from, Date to) {
        TeamSeasonInfo[] teams = new TeamSeasonInfo[4];
        
        teams[0] = new TeamSeasonInfo("Tdfgs", 32, 32);
        teams[1] = new TeamSeasonInfo("Tdfgs", 32, 32);
        teams[2] = new TeamSeasonInfo("Tdfgs", 32, 32);
        teams[3] = new TeamSeasonInfo("Tdfgs", 32, 32);
        
        return teams;
    }
}
