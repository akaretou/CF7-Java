package gr.aueb.cf.ch5;

import java.util.Scanner;


/**
 * Εφαρμογή που εμφανίζει ένα μενού με 6 επιλογές και ο χρήστης επιλέγει. Υλοποιείται με μεθόδους.
 */
public class StarsAndMethods {
   static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        int num = 0;

        menu();
        choice = in.nextInt();

        while (choice != 6) {
            switch (choice) {
                case 1:
                    num = getNum();
                    horizontalStars(num);
                    break;
                case 2:
                    num = getNum();
                    verticalStars(num);
                    break;
                case 3:
                    num = getNum();
                    horizontalVerticalNStars(num);
                    break;
                case 4:
                    num = getNum();
                    ascendingNStars(num);
                    break;
                case 5:
                    num = getNum();
                    descendingNStars(num);
                    break;
                default:
                    System.out.println("Παρακαλώ δώστε αριθμό απο το 1 έως το 5.");
                    break;
            }
            System.out.println();
            menu();
            choice = in.nextInt();
        }

        System.out.println("See you next time!");
    }


    public static void menu(){
        System.out.println("Επιλέξτε μία από τις παρακάτω επιλογές δίνοντας έναν ακέραιο αριθμό από 1 έως 5. Πατήστε 6 για έξοδο.");
        System.out.println("1. Εμφάνισε n αστεράκια οριζόντια\n" +
                "2. Εμφάνισε n αστεράκια κάθετα\n" +
                "3. Εμφάνισε n γραμμές με n αστεράκια\n" +
                "4. Εμφάνισε n γραμμές με αστεράκια 1 έως n\n" +
                "5. Εμφάνισε n γραμμές με αστεράκια n έως 1\n" +
                "6. Έξοδος από το πρόγραμμα\n");
    }

    public static int getNum() {
        System.out.println("Παρακαλώ δώστε αριθμό αστεριών");
        return in.nextInt();
    }

    public static void horizontalStars(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
    }

    public static void verticalStars(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("*");
        }
    }

    public static void horizontalVerticalNStars(int num) {
        for (int i = 0; i < num; i++) {
            horizontalStars(num);
            System.out.println();
        }
    }

    public static void ascendingNStars(int num) {
        for (int i = 1; i <= num; i++) {
            horizontalStars(i);
            System.out.println();
        }
    }

    public static void descendingNStars(int num) {
        for (int i = num; i > 0; i--) {
            horizontalStars(i);
            System.out.println();
        }
    }
}
