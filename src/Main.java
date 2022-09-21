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
        StudentDebt();
    }
    public static void StudentDebt() {
        try {
            System.out.print("Type the amount College will cost you:");
            Scanner UserDebt = new Scanner(System.in);
            setpv(UserDebt.nextDouble());
            studentinterest();
        }
        catch(InputMismatchException ex) {
            System.out.println("Setting Student debt Debt to $80,000");
            setpv(80000);
            studentinterest();
        }
    }
    public static void studentinterest() {
        try {
            System.out.print("Type in interest rate as a percent(APY):");
            Scanner interestrate = new Scanner(System.in);
            setI(interestrate.nextDouble());
            studentyears();
        } catch (InputMismatchException ex) {
            System.out.println("Setting Interest rate to 4.99% APY");
            setI(4.99);
            studentyears();
        }
    }
    public static void studentyears(){
        try {
            System.out.print("Type the number of years you wish to be debt free by:");
            Scanner years = new Scanner(System.in);
            setT(years.nextDouble());
            printstudent();
        }
        catch(InputMismatchException ex) {
            System.out.println("Setting debt free time to 30 years");
            setT(30);
            printstudent();
        }
    }
    public static void anotherone() {
        try {
            System.out.println("\nWould you like to calculate more loans?(True or False)");
            Scanner input = new Scanner(System.in);
            boolean UserInput = input.nextBoolean();
            if (UserInput) {
                StudentDebt();
            }
            else {
                System.out.println("See you next time!");
            }
        }
        catch(InputMismatchException ex) {
            System.out.println("See you next time!");
        }
    }
    public static Double studentpayments() {
        return getPV()*((getI()*Math.pow((1+getI()),getT()))/(Math.pow((1+getI()),getT())-1));
    }
    public static void printstudent() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        System.out.print("Your monthly payments will be: $"+decimalFormat.format(studentpayments()));
        System.out.print("\nYour yearly payments will be: $"+decimalFormat.format(studentpayments()*12));
        System.out.print("\nTotal amount paid will be: $"+decimalFormat.format(studentpayments()*12*getOT()));
        System.out.print("\nTotal Interest paid will be: $"+decimalFormat.format((studentpayments()*12*getOT())-getPV()));
        anotherone();
        //testing git commit
    }
}
//testing git commit from jetbrain