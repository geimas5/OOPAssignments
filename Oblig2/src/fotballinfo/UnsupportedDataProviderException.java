/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fotballinfo;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class UnsupportedDataProviderException extends Exception {
    public UnsupportedDataProviderException(String dataProvider) {
        super(String.format("The data provider %s is not supported", dataProvider));
    }
}
