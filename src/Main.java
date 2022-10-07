//Student loan calculator!
//Author: Seth/Sheriff John Brown
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    private static double PV; private static double I; private static double T; private static double OT;
    static void setP(double newpv) {
        PV = newpv;
    }
    static double getP() {
        return PV;
    }
    static void setI(double newI) {
        I = (newI/12)/100;
        //Takes the interest as a percent then divides by 12(period) of the loan payments and divides by 100 to get decimal value
    }
    static double getI() {
        return I;
    }
    static void setT(double newT) {
        T = newT*12;
        OT = newT;
        //sets t = to years(term) of debt times the number of payments(monthly/12)
        //sets ot = to years(term) of the debt
    }
    static double getT() {
        return T;
    }
    static double getOT() {
        return OT;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to student debt calculator! Hit any key to use default values when prompted");
        studentDebt();
    }
    public static void studentDebt() {
        try {
            System.out.print("Type the amount College will cost you:");
            Scanner UserDebt = new Scanner(System.in);
            setP(UserDebt.nextDouble());
            studentInterest();
        }
        catch(InputMismatchException ex) {
            //If user does not input an integer it will set the debt to 80k
            System.out.println("Setting Student debt Debt to $80,000");
            setP(80000);
            studentInterest();
        }
    }
    public static void studentInterest() {
        try {
            System.out.print("Type in interest rate as a percent(APY):");
            Scanner interestrate = new Scanner(System.in);
            setI(interestrate.nextDouble());
            studentYears();
        } catch (InputMismatchException ex) {
            //If user does not input an integer it will set the APY to 4.99%(current federal student debt interest rate)
            System.out.println("Setting Interest rate to 4.99% APY");
            setI(4.99);
            studentYears();
        }
    }
    public static void studentYears(){
        try {
            System.out.print("Type the number of years you wish to be debt free by:");
            Scanner years = new Scanner(System.in);
            setT(years.nextDouble());
            printStudent();
        }
        catch(InputMismatchException ex) {
            //If user does not input an integer it will set the years to 30(Being debt free by ~50 years old)
            System.out.println("Setting debt free time to 30 years");
            setT(30);
            printStudent();
        }
    }
    public static void seeYears() {
        try {
            System.out.println("\nWould you like to see how this debt based on the years taken to pay it off?(True or false)");
            Scanner input = new Scanner(System.in);
            boolean userInput = input.nextBoolean();
            if (userInput) {
                System.out.println();
                for (int x=5;x <= 50;x+=5) {
                    setT(x);
                    System.out.println("When you take "+x+" years "+"Your monthly payments will be: $"+StringFormat.decimalformat(studentPayments()));
                }
                System.out.println();
                for (int x=5;x <= 50;x+=5) {
                    setT(x);
                    System.out.println("When you take "+x+" years "+"Your yearly payments will be: $"+StringFormat.decimalformat(studentPayments()*12));
                }
                System.out.println();
                for (int x=5;x <= 50;x+=5) {
                    setT(x);
                    System.out.println("When you take "+x+" years "+"The total paid will be: $"+StringFormat.decimalformat(studentPayments()*12*getOT()));
                }
                System.out.println();
                for (int x=5;x <= 50;x+=5) {
                    setT(x);
                    System.out.println("When you take "+x+" years "+"The total interest paid will be: $"+StringFormat.decimalformat((studentPayments()*12*getOT())-getP()));
                }
                //will calculate monthly/yearly payments,Total interest cost, total cost, total interest cost every 5 years from 5 to 50
                //Used 50 years as max because if you graduate college at 21 then you will be 71 when you are debt free
                anotherOne();
            }
            else {
                anotherOne();
            }
        }
        catch(InputMismatchException ex) {
            //If user does not input an integer goes back to ask the user if they want to calculate more loans
            //Goes back the place the user started
            anotherOne();
        }
    }
    public static void anotherOne() {
        try {
            System.out.println("\nWould you like to calculate more loans?(True or False)");
            Scanner input = new Scanner(System.in);
            boolean UserInput = input.nextBoolean();
            if (UserInput) {
                studentDebt();
            }
            else {
                System.out.println("See you next time!");
            }
        }
        catch(InputMismatchException ex) {
            System.out.println("See you next time!");
        }
    }
    public static Double studentPayments() {
        return getP()*((getI()*Math.pow((1+getI()),getT()))/(Math.pow((1+getI()),getT())-1));
        //The PMT formula - basically modified Present Value Annuity Formula(PVA) A.K.A the formula that determines loan costs
        // Principle is times by [Interest is times by (interest +1) raised to the power of years, divided by (interest +1) raised to the power of (time-1)]
        // Your monthly payments will be lowered on a reverse inverse exponential curve based on years taken to pay off
        // Total cost/interest will be exponential increased based on the time to take off
    }
    public static void printStudent() {
        //Formats the outputted numbers to have commas and go the second decimal place(money format)
        System.out.print("Your monthly payments will be: $"+StringFormat.decimalformat(studentPayments()));
        System.out.print("\nYour yearly payments will be: $"+StringFormat.decimalformat(studentPayments()*12));
        System.out.print("\nTotal amount paid will be: $"+StringFormat.decimalformat(studentPayments()*12*getOT()));
        System.out.print("\nTotal Interest paid will be: $"+StringFormat.decimalformat((studentPayments()*12*getOT())-getP()));
        seeYears();
    }
}
//Created by SJB/Seth :D