package ca.clinicbook.java.vanilla_sky.util;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Reilly
 * Date: 05/03/13
 * Time: 4:58 PM
 *
 * Inspired by Ruby's nil?, present?, blank?, any? methods.
 */

public class Emptiness {
    public interface CouldBeBlank {
        public boolean isBlank();
    }

    public static boolean isNull(Object o) {
        return null == o;
    }

    public static boolean isPresent(Object o) {
        return !isNull(o);
    }

    public static boolean isBlank(Object o) {
        if ( isNull(o) )
            return true;
        if ( o instanceof Collection )
            return ((Collection) o).size() == 0;
        if ( o instanceof String )
            return ((String) o).length() == 0;
        if ( o instanceof CouldBeBlank ) {
            return ((CouldBeBlank) o).isBlank();
        }

        return false;
    }

    // An alias whose name might make a bit more sense sometimes
    public static boolean isEmpty(Object o) {
        return isBlank(o);
    }

    public static boolean hasAny(Object o) {
        return !isBlank(o);
    }
}
