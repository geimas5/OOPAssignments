package fotballinfo.data;

import java.util.*;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public interface IDataProvider {
    public void addEventListener(ErrorOccuredEventListener listener);
    public SeasonInfo[] findSeasons();
    public MatchInfo[] findMatches(Date from, Date to);
    public TeamSeasonInfo[] findTeams(Date from, Date to);
}
