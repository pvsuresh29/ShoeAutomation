package utilities;

import java.util.Calendar;

/**
 * Created by Suresh Venkata on 9/27/16.
 */
public class CommonUtils {

    public int getExpYear() {
        return Calendar.getInstance().get(Calendar.YEAR) + 1;
    }

}
