import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.DecimalFormat;

public class Main {
    private static double PV; private static double I; private static double T; private static double OT;
    static void setpv(double newpv) {
        PV = newpv;
    }
    static double getPV() {
        return PV;
    }
    static void setI(double newI) {
        I = (newI/12)/100;
    }
    static double getI() {
        return I;
    }
    static void setT(double newT) {
        T = newT*12;
        OT = newT;
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
            setpv(UserDebt.nextDouble());
            studentInterest();
        }
        catch(InputMismatchException ex) {
            System.out.println("Setting Student debt Debt to $80,000");
            setpv(80000);
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
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                decimalFormat.setGroupingUsed(true);
                decimalFormat.setGroupingSize(3);
                for (int x=5;x <= 50;x+=5) {
                    setT(x);
                    System.out.println("When you take "+x+" years "+"Your monthly payments will be: $"+decimalFormat.format(studentPayments()));
                }
                System.out.println();
                for (int x=5;x <= 50;x+=5) {
                    setT(x);
                    System.out.println("When you take "+x+" years "+"Your yearly payments will be: $"+decimalFormat.format(studentPayments()*12));
                }
                System.out.println();
                for (int x=5;x <= 50;x+=5) {
                    setT(x);
                    System.out.println("When you take "+x+" years "+"The total paid will be: $"+decimalFormat.format(studentPayments()*12*getOT()));
                }
                System.out.println();
                for (int x=5;x <= 50;x+=5) {
                    setT(x);
                    System.out.println("When you take "+x+" years "+"The total interest paid will be: $"+decimalFormat.format((studentPayments()*12*getOT())-getPV()));
                }
                anotherOne();
            }
            else {
                anotherOne();
            }
        }
        catch(InputMismatchException ex) {
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
        return getPV()*((getI()*Math.pow((1+getI()),getT()))/(Math.pow((1+getI()),getT())-1));
    }
    public static void printStudent() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        System.out.print("Your monthly payments will be: $"+decimalFormat.format(studentPayments()));
        System.out.print("\nYour yearly payments will be: $"+decimalFormat.format(studentPayments()*12));
        System.out.print("\nTotal amount paid will be: $"+decimalFormat.format(studentPayments()*12*getOT()));
        System.out.print("\nTotal Interest paid will be: $"+decimalFormat.format((studentPayments()*12*getOT())-getPV()));
        seeYears();
    }
}
//Created by SJB/Seth :D