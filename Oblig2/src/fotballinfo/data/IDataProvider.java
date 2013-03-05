package fotballinfo.data;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public interface IDataProvider {
    public SeasonInfo[] findSeasons();
    public MatchInfo[] findMatches(int year);
}
