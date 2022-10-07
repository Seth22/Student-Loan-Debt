import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class OutputNumberTest {

    @Test
    @DisplayName("Test 1")
    void Test1() {
        //testing to see if program output matches output from https://www.calculator.net/
        Main.setI(4.99);
        Main.setP(50000);
        Main.setT(20);

        assertEquals("329.7",StringFormat.decimalformat(Main.studentPayments()));
        assertEquals("29,128.41",StringFormat.decimalformat((Main.studentPayments()*12*Main.getOT())-Main.getP()));
        assertEquals("79,128.41",StringFormat.decimalformat(Main.studentPayments()*12*Main.getOT()));
        System.out.println("Test 1 passed!");
    }
    @Test
    @DisplayName("Test 2")
    void Test2() {
        //testing to see if program output matches output from PMT formula in Google Sheets
        Main.setI(8);
        Main.setP(61292);
        Main.setT(45);

        assertEquals("420.23",StringFormat.decimalformat(Main.studentPayments()));
        assertEquals("165,634.19",StringFormat.decimalformat((Main.studentPayments()*12*Main.getOT())-Main.getP()));
        assertEquals("226,926.19",StringFormat.decimalformat(Main.studentPayments()*12*Main.getOT()));
        System.out.println("Test 2 passed!");
    }

    @Test
    @DisplayName("Test 3: Decimal format")
    void Test3() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);

        assertEquals (decimalFormat.format(Main.studentPayments()),StringFormat.decimalformat(Main.studentPayments()));
        System.out.println("Test 3 passed!");
    }


}