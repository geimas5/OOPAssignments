package fotballinfo.data;

import java.util.*;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class ErrorOccuredEventListener implements EventListener {
    public IErrorAware aware;
    
    public ErrorOccuredEventListener(IErrorAware aware) {
        this.aware = aware;
    }
    
    public void errorOccured(ErrorEvent event){
        aware.reportError(event.getMessage(), event.getException());
    }
}
