package fotballinfo.data;

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
    public MatchInfo[] findMatches(int year) {
        MatchInfo[] matches = new MatchInfo[2];
        matches[0] = new MatchInfo();
        matches[1] = new MatchInfo();
        
        return matches;
    }
}
