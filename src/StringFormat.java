import java.text.DecimalFormat;

public class StringFormat {
    //Formats the outputted numbers to have commas and go the second decimal place(money format)
    public static String decimalformat(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        return decimalFormat.format(value);
    }
}
