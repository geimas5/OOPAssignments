/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz;

/**
 *
 * @author mariusg
 */
public interface IDataSource {
    Country[] findAllCountries() throws DataException;
}
