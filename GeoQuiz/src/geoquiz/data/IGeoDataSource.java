/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz.data;

import geoquiz.Country;

/**
 *
 * @author Marius Geitle
 */
public interface IDataSource {
    Country[] findAllCountries() throws DataException;
}
