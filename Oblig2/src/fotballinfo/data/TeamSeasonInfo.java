package fotballinfo.data;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class TeamSeasonInfo implements Comparable<TeamSeasonInfo> {
    private String name;
    private int matches;
    private int points;
    
    public TeamSeasonInfo(String name, int matches, int points) {
        this.name = name;
        this.matches = matches;
        this.points = points;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getMatches() {
        return this.matches;
    }
    
    public void setMatches(int matches) {
        this.matches = matches;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(TeamSeasonInfo o) {
        return this.points - o.getPoints();
    }
}
