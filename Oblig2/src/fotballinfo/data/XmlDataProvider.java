package fotballinfo.data;

import com.sun.org.apache.xpath.internal.NodeSet;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class XmlDataProvider implements IDataProvider {
    private String address;
    private List<ErrorOccuredEventListener> errorOccuredEventListeners = new ArrayList<>();
    
    public XmlDataProvider(String address){
        this.address = address;
    }
    
    @Override
    public SeasonInfo[] findSeasons() {
        List<SeasonInfo> seasons = new ArrayList<>();
        
        try {
            
            for(int year : DataAvailability.getAvailableSeasons()) {
                MatchInfo[] matches = findMatches(DateUtilities.getFirstDayOfYear(year), DateUtilities.getLastDayOfYear(year));
                
                seasons.add(new SeasonInfo(year, matches.length));
            }
        }
        catch (Exception ex){
            reportError(ex);
            seasons.clear();
        }
        
        return seasons.toArray(new SeasonInfo[seasons.size()]);
    }

    @Override
    public MatchInfo[] findMatches(Date from, Date to) {
        
        List<MatchInfo> matches = new ArrayList<>();
        
        try {
            if(from.after(to))
                throw new IllegalArgumentException("From must be before to");
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(from);
            
            Document doc = loadDocument(cal.get(Calendar.YEAR));
            NodeList matchNodes = evaluateXPath(doc, "/kamper/kamp");
            for(int i = 0; i < matchNodes.getLength(); i++) {
                MatchInfo match = createMatchInfo(matchNodes.item(i));
                if(match.equals(to) || match.equals(from) || (match.getDate().before(to) && match.getDate().after(from)))
                    matches.add(match);
            }
        }
        catch(Exception ex){
            reportError(ex);
            matches.clear();
        }
        
        return matches.toArray(new MatchInfo[matches.size()]);
    }

    @Override
    public TeamSeasonInfo[] findTeams(Date from, Date to) {
        HashMap<String, TeamSeasonInfo> teams = new HashMap();
        
        MatchInfo[] matches = findMatches(from, to);
        
        for(MatchInfo match : matches) {
            TeamSeasonInfo winnerTeam = getOrCreateTeamSeasonInfo(teams, match.getWinnerTeam());
            TeamSeasonInfo awayTeam = getOrCreateTeamSeasonInfo(teams, match.getAwayTeam());
            TeamSeasonInfo homeTeam = getOrCreateTeamSeasonInfo(teams, match.getHomeTeam());
            
            if(winnerTeam != null) {
                winnerTeam.setPoints(winnerTeam.getPoints() + match.getPoints());
            }
            else
            {
                awayTeam.setPoints(awayTeam.getPoints() + match.getPoints());
                homeTeam.setPoints(homeTeam.getPoints() + match.getPoints());
            }
            
            awayTeam.setMatches(awayTeam.getMatches() + 1);
            homeTeam.setMatches(homeTeam.getMatches() + 1);
        }
        
        return teams.values().toArray(new TeamSeasonInfo[teams.size()]);
    }
    
    @Override
    public void addEventListener(ErrorOccuredEventListener listener) {
        errorOccuredEventListeners.add(listener);
    }
    
    private TeamSeasonInfo getOrCreateTeamSeasonInfo(AbstractMap<String, TeamSeasonInfo> teams, String team) {
        if(team == null)
            return null;
        
        if(teams.containsKey(team))
            return (TeamSeasonInfo)teams.get(team);
        
        TeamSeasonInfo teamInfo = new TeamSeasonInfo(team, 0, 0);
        teams.put(team, teamInfo);
        
        return teamInfo;
    }
    
    private void reportError(Exception ex){
        for(ErrorOccuredEventListener listener : errorOccuredEventListeners){
            listener.errorOccured(new ErrorEvent(this, ex.getMessage(), ex));
        }
    }
    
    private MatchInfo createMatchInfo(Node node) {
        Date date = parseDate(getChildNodeValue(node, "dato"));
        String homeTeam = getChildNodeValue(node, "hlag");
        String awayTeam = getChildNodeValue(node, "blag");
        int homeGoals = Integer.parseInt(getChildNodeValue(node, "hmaal"));
        int awayGoals = Integer.parseInt(getChildNodeValue(node, "bmaal"));
        
        return new MatchInfo(date, homeTeam, awayTeam, homeGoals, awayGoals);
    }
    
    private Date parseDate(String dateString) {
        String[] parts = dateString.trim().split(":");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        
        return cal.getTime();
    }
    
    private NodeList evaluateXPath(Document doc, String expr){
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        try {
            XPathExpression expression = xpath.compile(expr);
            return (NodeList)expression.evaluate(doc, XPathConstants.NODESET);
        }
        catch (Exception ex) {
            System.out.println(ex);
            return new NodeSet();
        }
    }
    
    private String getChildNodeValue(Node node, String nodeName){
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        try {
            XPathExpression expression = xpath.compile("./" + nodeName);
            return ((Node)expression.evaluate(node, XPathConstants.NODE)).getTextContent();
        }
        catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    private Document loadDocument(int year) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder;
        dBuilder = factory.newDocumentBuilder();
        return dBuilder.parse(String.format(address, year));
    }
}
