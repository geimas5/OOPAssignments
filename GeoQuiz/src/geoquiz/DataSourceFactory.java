/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz;

/**
 *
 * @author mariusg
 */
public class DataSourceFactory {
    public static IDataSource createDataSource() {
        return new GeonamesDataSource();
    }
}
