package fotballinfo.data;

import java.util.*;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class DateUtilities {
    public static Date getFirstDayOfYear(int year){
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        
        return cal.getTime();
    }
    
    public static Date getLastDayOfYear(int year){
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        
        return cal.getTime();
    }
}
