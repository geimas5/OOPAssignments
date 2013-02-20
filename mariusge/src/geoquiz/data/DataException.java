/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz.data;

/**
 *
 * @author Marius Geitle
 */
public class DataException extends Exception {

    public DataException(String message) {
        super(message);
    }
    
    public DataException(String message, Throwable cause) {
        super(message, cause);
    }
}
