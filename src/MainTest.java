import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class OutputNumberTest {

    @Test
    @DisplayName("Test 1")
    void Test1() {
        //testing to see if program output matches output from https://www.calculator.net/
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        Main.setI(4.99);
        Main.setP(50000);
        Main.setT(20);

        assertEquals("329.7",decimalFormat.format(Main.studentPayments()));
        assertEquals("29,128.41",decimalFormat.format((Main.studentPayments()*12*Main.getOT())-Main.getP()));
        assertEquals("79,128.41",decimalFormat.format(Main.studentPayments()*12*Main.getOT()));
    }
    @Test
    @DisplayName("Test 2")
    void Test2() {
        //testing to see if program output matches output from PMT formula in Google Sheets
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        Main.setI(8);
        Main.setP(61292);
        Main.setT(45);

        assertEquals("420.23",decimalFormat.format(Main.studentPayments()));
        assertEquals("165,634.19",decimalFormat.format((Main.studentPayments()*12*Main.getOT())-Main.getP()));
        assertEquals("226,926.19",decimalFormat.format(Main.studentPayments()*12*Main.getOT()));
    }

}