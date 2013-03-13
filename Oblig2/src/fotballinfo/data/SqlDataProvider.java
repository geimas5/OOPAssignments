package fotballinfo.data;


import java.util.*;
import java.sql.*;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class SqlDataProvider implements IDataProvider {
    private List<ErrorOccuredEventListener> errorOccuredEventListeners = new ArrayList<>();
    private String connectionString;
    
    public SqlDataProvider(String connectionString) {
        this.connectionString = connectionString;
    }
    
    
    @Override
    public void addEventListener(ErrorOccuredEventListener listener) {
        errorOccuredEventListeners.add(listener);
    }

    @Override
    public SeasonInfo[] findSeasons() {
        List<SeasonInfo> seasons = new ArrayList<>();
        
        try {
            ResultSet result = executeQuery("select sesong as year, count(*) as matches from resultater group by sesong", new String[0]);
            
            while(result.next()) {
                seasons.add(new SeasonInfo(result.getInt("year"), result.getInt("matches")));
            }
        }
        catch(Exception ex){
            reportError(ex);
            seasons.clear();
        }
        
        return seasons.toArray(new SeasonInfo[seasons.size()]);
    }

    @Override
    public MatchInfo[] findMatches(java.util.Date from, java.util.Date to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TeamSeasonInfo[] findTeams(java.util.Date from, java.util.Date to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        
    private void reportError(Exception ex){
        for(ErrorOccuredEventListener listener : errorOccuredEventListeners){
            listener.errorOccured(new ErrorEvent(this, ex.getMessage(), ex));
        }
    }
    
    private ResultSet executeQuery(String sql, String[] parameters) throws Exception {
        
      Class.forName("com.mysql.jdbc.Driver");
      
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      
      try{
        connection = DriverManager.getConnection(this.connectionString);
        

        preparedStatement = connection.prepareStatement(sql);

        for(int i = 1; i <= parameters.length; i++) {
            preparedStatement.setString(i, parameters[i]);
        }

        return preparedStatement.executeQuery();
      }
      finally {
          if(preparedStatement != null)
            preparedStatement.close();
          
          if(connection != null)
            connection.close();
      }
    }
}
