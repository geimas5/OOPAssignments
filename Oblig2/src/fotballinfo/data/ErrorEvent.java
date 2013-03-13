package fotballinfo.data;

import java.util.*;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class ErrorEvent extends EventObject {
    private String message;
    private Exception exception;
    
    public ErrorEvent(Object source, String message, Exception ex){
        super(source);
        
        this.message = message;
        this.exception = ex;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public Exception getException(){
        return this.exception;
    }
}
