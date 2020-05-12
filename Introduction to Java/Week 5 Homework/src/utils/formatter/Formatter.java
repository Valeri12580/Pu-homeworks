package utils.formatter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class Formatter {
    private static DecimalFormat decimalFormat;

    static {
        // използвам new DecimalFormatSymbols(Locale.US),защото при някои може да изкарва ',',вместо '.' като десетична точка...
       decimalFormat= new DecimalFormat("#.##",new DecimalFormatSymbols(Locale.US));
    }


    public static String format(double number){
        return decimalFormat.format(number);
    }

}
