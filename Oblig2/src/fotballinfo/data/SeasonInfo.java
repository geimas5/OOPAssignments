package fotballinfo.data;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class SeasonInfo {
    private int year;
    private int matches;
    
    public SeasonInfo(int year, int matches) {
        this.year = year;
        this.matches = matches;
    }
    
    public int getYear(){
        return year;
    }
    
    public int getMatches(){
        return matches;
    }
}
